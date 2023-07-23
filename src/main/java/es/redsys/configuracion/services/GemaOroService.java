package es.redsys.configuracion.services;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.StringTokenizer;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntrada;
import com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntradaService;
import com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntradaServiceLocator;

import es.redsys.configuracion.util.StringToHex;

public class GemaOroService {
	private static final Logger log = LoggerFactory.getLogger(GemaOroService.class);
	
	private ResourceBundle configWS;

	private String idComercio;

	private static final String identifTrans = "000000000000000000000000"; //24 posiones
	private static final String sesion = "00000000000000"; //14 posiones
//	private static final String terminal = "00000049790001"; // 14 posiones OK
	private static final String terminal = "00000000000000"; // 14 posiones OK
	private static final String user = "ALF";
	private static final char sep = 28; // x1c
	
	public GemaOroService() {
		configWS = ResourceBundle.getBundle("conf-activdcc-clientes-ws");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] enviarTandem(String trans,Map<String, Object> datos, String entidad, String version) throws Exception 
	{
		String mensaje = "";
		String respuesta = "";
		String codRespuesta = "";
//		String transac= "";
		String[] strings = {};
		
//		StringTokenizer tokenizer = new StringTokenizer(trans, "-");
//		transac = (String) tokenizer.nextElement();
//		version = (String) tokenizer.nextElement();
		
		try {
			// Formar los datos cabecera para TANDEM
			StringBuffer bufferCabecera = new StringBuffer();
//			bufferCabecera.append(String.format("%04d", 49));
			bufferCabecera.append(entidad);
			bufferCabecera.append(sep);
			bufferCabecera.append(version);
			bufferCabecera.append(sep);
			bufferCabecera.append("P");
			bufferCabecera.append(sep);
			bufferCabecera.append(trans);
			bufferCabecera.append(sep);
			bufferCabecera.append(identifTrans);
			bufferCabecera.append(sep);
			bufferCabecera.append(sesion);
			bufferCabecera.append(sep);
			bufferCabecera.append(terminal);
			bufferCabecera.append(sep);
			bufferCabecera.append(user);
			bufferCabecera.append(sep);
	
//			String dataHead = SerClsUtilHexadecimal.toHexadecimal(bufferCabecera.toString().getBytes());
			String dataHead = StringToHex.convertStringToHex(bufferCabecera.toString());
//			log.debug("dataHead=" + dataHead);
	
			// Formar los datos variable para TANDEM
			StringBuffer bufferVariable = new StringBuffer();
			
			Set campos = datos.keySet();			
//			log.debug("Campos="+campos);
			
			for (Iterator<String> iterator = campos.iterator(); iterator.hasNext();) {
				String keyName = iterator.next();
				
				bufferVariable.append((String) datos.get(keyName));
				bufferVariable.append(sep);
			}

			
//			String datoEntrada = SerClsUtilHexadecimal.toHexadecimal(bufferVariable.toString().getBytes());
			String datoEntrada = StringToHex.convertStringToHex(bufferVariable.toString());
//			log.debug("datoEntrada=" + datoEntrada);
	
			mensaje = dataHead + datoEntrada;
			log.debug("  entrada=" + mensaje);
			hex2ASCII(mensaje);
			
			respuesta = sendMensajeGema(mensaje);
			log.debug("respuesta=" + respuesta);
 			hex2ASCII(respuesta);
				
			strings = respuesta.split("1C|1c");
//			codRespuesta = SerClsUtilHexadecimal.empaquetar(strings[8]);
			codRespuesta = StringToHex.convertHexToString(strings[8]);
			if(strings.length > 9)
			{
//			   idComercio = SerClsUtilHexadecimal.empaquetar(strings[9]);
			   idComercio =	StringToHex.convertHexToString(strings[9]);
			   log.info("idComercio ="+idComercio);
			}
			
		} catch (Exception e) {
			log.error("ERROR. ENVIO A GEMA-ORO NO COMPLETADO !!!");
			throw e;
		}
		
		return strings;
	}

	public String[] enviarTandem(String msg) throws Exception 
	{
		String mensaje = "";
		String respuesta = "";
		String codRespuesta = "";
		String[] strings = {};

		try {
		
			char[] chars = msg.toCharArray();
			for(int i = 0; i < chars.length; i++){
				if(chars[i] == '?')
					chars[i] = 28;     //x1C
			}
			
			msg = new String(chars);
			
			//ENVIO MENSAJE AL TANDEM
			mensaje = StringToHex.convertStringToHex(msg);
			log.debug("mensaje=" + mensaje);
			
			respuesta = sendMensajeGema(mensaje);
			
			log.debug("respuesta=" + respuesta);
 			hex2ASCII(respuesta);
				
			strings = respuesta.split("1C|1c");
			codRespuesta = StringToHex.convertHexToString(strings[8]);
			if(strings.length > 9)
			{
			   idComercio =	StringToHex.convertHexToString(strings[9]);
			   log.info("idComercio ="+idComercio);
			}
			
		} catch (Exception e) {
			log.error("ERROR. MARCAR con servicio DCC, ENVIO A GEMA-ORO NO COMPLETADO !!!");
			throw e;
		}
		
		return strings;
	}

	private void hex2ASCII(String msg) {
		
		String[] strings = msg.split("1C|1c");
		for (int i = 0; i < strings.length; i++) {
//			log.info("["+i+"]="+SerClsUtilHexadecimal.empaquetar(strings[i]));
			log.info("["+i+"]="+StringToHex.convertHexToString(strings[i]));
		}
		
	}

	private String sendMensajeGema(String datoEntrada) throws Exception {
		String respuesta = "";

		String address = configWS.getString("gemaoro.url");
		log.debug(address);
		
		if(address != null && !"".equals(address))
		{
			URL url = new URL(address);
			SerClsWSEntradaService ss = new SerClsWSEntradaServiceLocator();
			SerClsWSEntrada entrada = ss.getSerClsWSEntrada(url);

			String user     = configWS.getString("gemaoro.username");
			String password = configWS.getString("gemaoro.password");
			respuesta = entrada.trataPeticion(datoEntrada,user,password);
		}
		
		return respuesta;
	}
	
	public String[] processRequest(Map<String, Object> mapParamRequest,String transac,String version, String entidad) {
		String[] respuesta = null;

		try {
			String[] strings = enviarTandem(transac, mapParamRequest,entidad,version);
			
			respuesta = new String[strings.length];
			for (int i = 0; i < strings.length; i++) {
//				respuesta[i] = SerClsUtilHexadecimal.empaquetar(strings[i]);
				respuesta[i] = StringToHex.convertHexToString(strings[i]);
			}
		} catch (Exception e) {
			log.error("ERROR. RESPUESTA A GEMA-ORO NO COMPLETADO !!!",e);
		}
		
		return respuesta;		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// gemaoro.url=https://odin-i.redsys.es:21543/gestorGemaOro/services/SerClsWSEntrada?wsdl
		
		GemaOroService gemaOroService = new GemaOroService();
		
		//campo 1 = 0049  entidad
		//campo 2 = 0001  version
		//campo 3 = P     pregunta
		//campo 4 = 31534 transaccion
		//campo 5 = 20191023093057000620-8460706493087682763 identidad transaccion
		//campo 6 = 10000049000007 id.terminal/sesion
		//campo 7 = 
		//campo 8 = usuario
		//campo 9 = '0047674643?0049?3474?19?2114019671?'  datos-transaccion
		
		String msg = "0049?0001?P?31534?20191023093057000620-8460706493087682763?10000049000007???0047674643?0049?3474?19?2114019671?";
		
		try {
			gemaOroService.enviarTandem(msg);
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	
}
