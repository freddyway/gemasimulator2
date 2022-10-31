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
import es.redsys.configuracion.services.ModifDescuentosService;
import es.redsys.configuracion.util.RequestParamsMapper;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "ModifDescuentosServlet", urlPatterns = {"/modifdtos"})

public class ModifDescuentosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =  LoggerFactory.getLogger(ModifDescuentosController.class);
	
	@EJB
	ModifDescuentosService modifDescuentosService;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifDescuentosController() {
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
		
		logger.info("ModifDescuentosController...");
		
		try{
			Map<String,Object> mapParamRequest = RequestParamsMapper.toMap(request); 
						
			String contextPath = request.getContextPath();
			logger.debug(contextPath);
			
			String servletPath = request.getServletPath();
			logger.debug(servletPath);
														
			if("/modifdtos".equals(servletPath)){
				command = request.getParameter("command");
				entidad = request.getParameter("entidad");
				version = request.getParameter("version");
				  fila =  request.getParameter("rowid");
				  
				logger.info("command="+command);
								
				if("consultar".equals(command)){
					mapParamRequest.put("listTR31522", modifDescuentosService.findAll());					
				}
				if("procesar".equals(command)){
					GemaOroService gemaOroService = new GemaOroService();
					respuesta = gemaOroService.processRequest(mapParamRequest,"31522",version,entidad);	
					mapParamRequest.put("codRespuesta", respuesta[8]);
				}
				if("grabar".equals(command)){
					modifDescuentosService.save(mapParamRequest,entidad,version);
				}

				if("eliminar".equals(command)){
					modifDescuentosService.delete(fila);					
					mapParamRequest.put("codRespJPA","Eliminacion Correcta!!!");
				}

				if("update".equals(command)){
					String id =  request.getParameter("id");
					modifDescuentosService.update(mapParamRequest,id,entidad,version);
					mapParamRequest.put("codRespJPA","Modficacion Correcta!!!");
				}

				if("fila".equals(command)){
					mapParamRequest = modifDescuentosService.findById(fila);
				}
				
				pageResponse = "/tr31522.jsp";
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
