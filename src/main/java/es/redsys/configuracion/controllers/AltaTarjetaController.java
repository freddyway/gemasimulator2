package es.redsys.configuracion.controllers;

import java.io.IOException;
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

import es.redsys.configuracion.services.AltaComercioService;
import es.redsys.configuracion.services.AltaTarjetaService;
import es.redsys.configuracion.services.GemaOroService;
import es.redsys.configuracion.services.ejb.AltaComercioServiceEJB;
import es.redsys.configuracion.util.RequestParamsMapper;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "AltaTarjetaServlet", urlPatterns = {"/altatarjeta"})

public class AltaTarjetaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =  LoggerFactory.getLogger(AltaTarjetaController.class);
	
	@EJB
	AltaTarjetaService service;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaTarjetaController() {
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
		String command = "";
		String version = "";
		String fila = "";
		
		logger.info("AltaTarjetaController...");
		
		try{
			Map<String,Object> mapParamRequest = RequestParamsMapper.toMap(request); 
						
			String contextPath = request.getContextPath();
			logger.debug(contextPath);
			
			String servletPath = request.getServletPath();
			logger.debug(servletPath);
														
			if("/altatarjeta".equals(servletPath)){
				command = request.getParameter("command");
				entidad = request.getParameter("entidad");
				version = request.getParameter("version");
				fila =  request.getParameter("rowid");
				
				logger.info("command="+command);
								
				if("consultar".equals(command)){
					mapParamRequest.put("listTR31390", service.findAll());					
				}
				if("procesar".equals(command)){
					GemaOroService gemaOroService = new GemaOroService();
					respuesta = gemaOroService.processRequest(mapParamRequest,"31390",version,entidad);		
					mapParamRequest.put("codRespuesta", respuesta[8]);
				}
				if("grabar".equals(command)){
					service.save(mapParamRequest,entidad, version);
				}

				if("eliminar".equals(command)){					
					service.delete(fila);					
					mapParamRequest.put("codRespJPA","Eliminacion Correcta!!!");
				}

				if("update".equals(command)){
					String id = (String) request.getParameter("id");
					service.update(mapParamRequest,id,entidad,version);
					mapParamRequest.put("codRespJPA","Modficacion Correcta!!!");
				}

				if("fila".equals(command)){
					mapParamRequest = service.findById(fila);
				}
				
				pageResponse = "/tr31390.jsp";
			}
							
			logger.debug(mapParamRequest.toString());

			request.setAttribute("respuesta", mapParamRequest);
			request.getRequestDispatcher(pageResponse).forward(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}
