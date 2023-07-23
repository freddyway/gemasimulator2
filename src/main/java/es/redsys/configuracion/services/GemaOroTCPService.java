package es.redsys.configuracion.services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.redsys.configuracion.util.StringToHex;
import es.sermepa.util.SerClsRellenar;
import es.sermepa.util.SerClsUtilHexadecimal;

public class GemaOroTCPService {
    private static final Logger logger = LoggerFactory.getLogger(GemaOroTCPService.class);
    
    private static String mensajeHead = "0100000000010100000100202020202020202000000000000000000000000000000000000000";

    // rdsaixd4
    private static final String IP_DESA = "10.129.3.204";

    private static final char sep = 28; // x1c
    
    public GemaOroTCPService() {
		
	}

	public String processRequest(Map<String, Object> datos, String transac, String version, String entidad) {
    	String respuesta= "9999";
    	
        try {            
			int port = getPort(entidad);

			String msgEnvio = formatMessage(datos, transac, version);
			
			
            Socket socket = new Socket(IP_DESA, port);
            socket.setKeepAlive(true);
     
            BufferedOutputStream canalEnvio = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream canalRecepcion = new BufferedInputStream(socket.getInputStream());

            enviarDatos(canalEnvio, msgEnvio);
            respuesta = recibirDatos(canalRecepcion);

            socket.close();
  
        } catch (Exception e) {
            logger.error("ERROR GRAVE DE I/O!!!", e);
        }
        
        return respuesta;
    }

	private int getPort(String entidad) {
		int port = 0;
		
		switch (entidad) {
		case "0075":
			port = 50300;
			break;
		case "0624":
			port = 50320;
			break;
		case "0224":
			port = 50340;
			break;
		case "0699":
			port = 50410;
			break;
		case "0049":
			port = 50370;
			break;

		default:
			port = 50370;
			break;
		}
		
		return port;
	}

	private String formatMessage(Map<String, Object> datos, String transac, String version) {
		String formatMessage = "";
		
		// Formar los datos variable para TANDEM
		StringBuffer bufferVariable = new StringBuffer();
		
		Set<String> campos = datos.keySet();			
		for (String campo : campos) {
			String keyName = campo;
			
			bufferVariable.append((String) datos.get(keyName));
			bufferVariable.append(sep);
		}
		
		int dataSize = bufferVariable.toString().length();
		
		String dataSizeExt = String.format("%05d", dataSize);
		logger.info("dataSizeExt=" + dataSizeExt);
		
		String dataSizeHex = StringToHex.convertStringToHex(dataSizeExt);
		logger.info("dataSizeHex=" + dataSizeHex);
		
		
		String datoEntrada = StringToHex.convertStringToHex(bufferVariable.toString());
		logger.info("datoEntrada=" + datoEntrada);

		StringBuffer bufferEnvio = new StringBuffer();
		bufferEnvio.append(mensajeHead);
		bufferEnvio.append(version);
		bufferEnvio.append(transac);
		bufferEnvio.append(dataSizeHex);
		bufferEnvio.append(datoEntrada);
		
		formatMessage = bufferEnvio.toString();		
		logger.info("MsgEnvio="+formatMessage);
		return formatMessage;
	}

    private String recibirDatos(BufferedInputStream canalRecepcion) {
    	String codRespuesta = "";
    	
        if (canalRecepcion != null) {
            try {
                byte[] tamMensaje = null;
                int bytesCabecera = 0;
                int tamanoCABECERA = 4;
                tamMensaje = new byte[tamanoCABECERA];
                // Se lee el tamaño de los datos de cabecera
                bytesCabecera = canalRecepcion.read(tamMensaje, 0, tamanoCABECERA);

                String tamanoMensajeStr = "";
                if (tamanoCABECERA > 0) {
                    tamanoMensajeStr = SerClsUtilHexadecimal.toHexadecimal(tamMensaje, 0, tamanoCABECERA);
                }

                // System.out.println("tamanoMensajeStr="+tamanoMensajeStr);

                int tamanoMensaje = Integer.parseInt(tamanoMensajeStr, 16);
                // System.out.println("tamanoMensajer="+tamanoMensaje);

                int bytesLeidos = 0;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int bitLeido = 0;
                while (tamanoMensaje > 0 && bitLeido != -1) {
                    bitLeido = canalRecepcion.read();
                    if (bitLeido != -1) {
                        baos.write(bitLeido);
                    }
                    tamanoMensaje--;
                    bytesLeidos++;
                }

                byte buffer[] = baos.toByteArray();
                String mensajeHex = SerClsUtilHexadecimal.toHexadecimal(buffer, 0, buffer.length);
                logger.info("Mensaje HEX :" + mensajeHex);

                codRespuesta = mensajeHex.substring(6, 10);
                logger.info("codRespuesta=" + codRespuesta);

            } catch (Exception e) {
                logger.error("Error en recibir de datos por el canal: ", e);
            }
        }

        return codRespuesta;
    }

    public boolean enviarDatos(final BufferedOutputStream canalEnvio, final String datos) {
        boolean enviados = false;
        if (canalEnvio != null) {
            logger.info("Mensaje a enviar[" + datos + "]");
            byte[] mensaje = SerClsUtilHexadecimal.toByteArray(datos);
            int longitudMensaje = mensaje.length;
            int tamanyoLongitudMensaje = 0;
            final int tamanoCABECERA = 4;
            if (tamanoCABECERA > 0) {
                tamanyoLongitudMensaje = tamanoCABECERA * 2;
            }
            int tamanyoTotalMensaje = longitudMensaje;

            String tamanyo = "";
            if (tamanoCABECERA > 0) {
                tamanyo = SerClsRellenar.rellenaIzqConSta(Integer.toHexString(tamanyoTotalMensaje), "0", tamanyoLongitudMensaje);
            }

            logger.info("Mensaje completo a enviar[" + tamanyo + datos + "]");
            try {
                // Se envía en primer lugar el tamaño del mensaje
                if (tamanoCABECERA > 0) {
                    byte[] cabecera = SerClsUtilHexadecimal.toByteArray(tamanyo);
                    canalEnvio.write(cabecera);
                }
                int bytesEnviados = 0;
                ByteArrayInputStream bais = new ByteArrayInputStream(mensaje);
                byte[] buf = new byte[1024];
                while (bytesEnviados < longitudMensaje) {
                    int bytesLeidos = bais.read(buf, 0, 1024);
                    canalEnvio.write(buf, 0, bytesLeidos);
                    bytesEnviados += bytesLeidos;
                }
                canalEnvio.flush();
                enviados = true;

            } catch (Exception e) {
                logger.error( "Error en envío de datos por el canal: ", e);
                enviados = false;
            }
        }
        logger.info("Mensaje enviado=[" + enviados + "]");

        return enviados;
    }

}
