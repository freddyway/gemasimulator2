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

import es.redsys.configuracion.services.GemaOroService;
import es.redsys.configuracion.services.ModifComercioService;
import es.redsys.configuracion.util.RequestParamsMapper;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "ModifComercioServlet", urlPatterns = {"/modifcomercio"})

public class ModifComercioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =  LoggerFactory.getLogger(ModifComercioController.class);
	
	@EJB
	ModifComercioService modifComercioService;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifComercioController() {
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
		String version= "";
		String fila = "";
		
		logger.info("ModifComercioController...");
		
		try{
			Map<String,Object> mapParamRequest = RequestParamsMapper.toMap(request); 
						
			String contextPath = request.getContextPath();
			logger.debug(contextPath);
			
			String servletPath = request.getServletPath();
			logger.debug(servletPath);
														
			if("/modifcomercio".equals(servletPath)){
				command = request.getParameter("command");
				entidad = request.getParameter("entidad");
				version = request.getParameter("version");
				  fila =  request.getParameter("rowid");
				  
				logger.info("command="+command);
								
				if("consultar".equals(command)){
					mapParamRequest.put("listTR31503", modifComercioService.findAll());					
				}
				if("procesar".equals(command)){
					GemaOroService gemaOroService = new GemaOroService();
					respuesta = gemaOroService.processRequest(mapParamRequest,"31503",version,entidad);	
					mapParamRequest.put("codRespuesta", respuesta[8]);
				}
				if("grabar".equals(command)){
					modifComercioService.save(mapParamRequest,entidad,version);
				}

				if("eliminar".equals(command)){
					modifComercioService.delete(fila);					
					mapParamRequest.put("codRespJPA","Eliminacion Correcta!!!");
				}

				if("update".equals(command)){
					String id =  request.getParameter("id");
					modifComercioService.update(mapParamRequest,id,entidad,version);
					mapParamRequest.put("codRespJPA","Modficacion Correcta!!!");
				}

				if("fila".equals(command)){
					mapParamRequest = modifComercioService.findById(fila);
				}
				
				pageResponse = "/tr31503.jsp";
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
