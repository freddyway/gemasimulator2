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

import es.redsys.configuracion.services.BajaCuentaService;
import es.redsys.configuracion.services.GemaOroService;
import es.redsys.configuracion.services.MarcarCtaPriorService;
import es.redsys.configuracion.util.RequestParamsMapper;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "BajaCuentaServlet", urlPatterns = {"/bajacuenta"})

public class BajaCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =  LoggerFactory.getLogger(BajaCuentaController.class);
		
	@EJB
	BajaCuentaService bajaCuentaService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaCuentaController() {
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
		
		logger.info("BajaCuentaController...");
		
		try{
			Map<String,Object> mapParamRequest = RequestParamsMapper.toMap(request); 
							
			String contextPath = request.getContextPath();
			logger.debug(contextPath);
			
			String servletPath = request.getServletPath();
			logger.debug(servletPath);
			
			
			if("/bajacuenta".equals(servletPath)){					
				command = request.getParameter("command");
				entidad = request.getParameter("entidad");
				version = request.getParameter("version");

				logger.info("command="+command);
				if("consultar".equals(command)){
					mapParamRequest.put("listTR31533", bajaCuentaService.findAll());					
				}
				if("procesar".equals(command)){
					GemaOroService gemaOroService = new GemaOroService();
					respuesta = gemaOroService.processRequest(mapParamRequest,"31533",version,entidad);
					mapParamRequest.put("codRespuesta", respuesta[8]);
				}
				
				if("grabar".equals(command)){
					bajaCuentaService.save(mapParamRequest,entidad,version);
				}
				
				if("eliminar".equals(command)){					
					String fila = (String) request.getParameter("rowid");
					bajaCuentaService.delete(fila);					
					mapParamRequest.put("codRespJPA","Eliminacion Correcta!!!");
				}

				if("update".equals(command)){
					String id = (String) request.getParameter("id");
					bajaCuentaService.update(mapParamRequest,id,entidad,version);
					mapParamRequest.put("codRespJPA","Modficacion Correcta!!!");
				}

				if("fila".equals(command)){
					String fila = (String) request.getParameter("rowid");
					mapParamRequest = bajaCuentaService.findById(fila);
				}
				
				pageResponse = "/tr31533.jsp";
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
