package es.redsys.configuracion.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.redsys.configuracion.services.ActivarTarjetaEstadoService;
import es.redsys.configuracion.services.ActivarTarjetaService;
import es.redsys.configuracion.services.AltaCuentaService;
import es.redsys.configuracion.services.CargaPrepagoService;
import es.redsys.configuracion.services.ConsultaSaldoService;
import es.redsys.configuracion.services.GemaOroService;
import es.redsys.configuracion.util.RequestParamsMapper;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "CargaPrepagoServlet", urlPatterns = {"/cargaprepag"})

public class CargaPrepagoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =  LoggerFactory.getLogger(CargaPrepagoController.class);
		
	@EJB
	CargaPrepagoService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargaPrepagoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] respuesta = {};
		String pageResponse = "/index.jsp";
		String entidad= "";
		String version= "";
		String command = "";
		
		logger.info("CargaPrepagoController...");
		
		try{
			Map<String,Object> mapParamRequest = RequestParamsMapper.toMap(request); 
							
			String contextPath = request.getContextPath();
			logger.debug(contextPath);
			
			String servletPath = request.getServletPath();
			logger.debug(servletPath);
						
			if("/cargaprepag".equals(servletPath)){					
				command = request.getParameter("command");
				entidad = request.getParameter("entidad");
				version = request.getParameter("version");

				logger.info("command="+command);

				if("consultar".equals(command)){
					mapParamRequest.put("listTR31240", service.findAll());					
				}
				
				if("procesar".equals(command)){
					GemaOroService gemaOroService = new GemaOroService();
					respuesta = gemaOroService.processRequest(mapParamRequest,"31240",version,entidad);	
					mapParamRequest.put("codRespuesta", respuesta[8]);
				}
				
				if("grabar".equals(command)){
//					service.save(mapParamRequest,entidad,version);
					mapParamRequest.put("banco", entidad);
					mapParamRequest.put("version", version);
					mapParamRequest.put("fechaTrans", new Date());
					
					service.save(mapParamRequest);
					mapParamRequest.put("listTR31240", service.findAll());
				}
				
				if("fila".equals(command)){
					String fila = (String) request.getParameter("rowid");										
					mapParamRequest = service.findById(fila);					
				}
				
				if("eliminar".equals(command)){					
					String fila = (String) request.getParameter("rowid");
					service.delete(fila);					
					mapParamRequest.put("codRespJPA","Eliminacion Correcta!!!");
					mapParamRequest.put("listTR31240", service.findAll());
				}

				if("update".equals(command)){
					String id = (String) request.getParameter("id");
//					service.update(mapParamRequest,id,entidad,version);
					
					mapParamRequest.put("id", id);
					mapParamRequest.put("banco", entidad);
					mapParamRequest.put("version", version);
					mapParamRequest.put("fechaTrans", new Date());
					
					service.update(mapParamRequest);
					
					mapParamRequest.put("codRespJPA","Modficacion Correcta!!!");
					mapParamRequest.put("listTR31240", service.findAll());
				}

				pageResponse = "/tr31240.jsp";
			}
			
			logger.debug("mapParamRequest={}",mapParamRequest.toString());
			
			request.setAttribute("respuesta", mapParamRequest);
			request.getRequestDispatcher(pageResponse).forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}
