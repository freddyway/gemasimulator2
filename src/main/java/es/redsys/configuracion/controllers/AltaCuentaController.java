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

import es.redsys.configuracion.services.AltaCuentaService;
import es.redsys.configuracion.services.GemaOroService;
import es.redsys.configuracion.util.RequestParamsMapper;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "AltaCuentaServlet", urlPatterns = {"/altacuenta"})

public class AltaCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =  LoggerFactory.getLogger(AltaCuentaController.class);
		
	@EJB
	AltaCuentaService altaCuentaService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCuentaController() {
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
		
		logger.info("AltaCuentaController...");
		
		try{
			Map<String,Object> mapParamRequest = RequestParamsMapper.toMap(request); 
							
			String contextPath = request.getContextPath();
			logger.debug(contextPath);
			
			String servletPath = request.getServletPath();
			logger.debug(servletPath);
						
			if("/altacuenta".equals(servletPath)){					
				command = request.getParameter("command");
				entidad = request.getParameter("entidad");
				version = request.getParameter("version");

				logger.info("command="+command);

				if("consultar".equals(command)){
					mapParamRequest.put("listTR31530", altaCuentaService.findAll());					
				}
				
				if("procesar".equals(command)){
					GemaOroService gemaOroService = new GemaOroService();
					respuesta = gemaOroService.processRequest(mapParamRequest,"31530",version,entidad);	
					mapParamRequest.put("codRespuesta", respuesta[8]);
				}
				
				if("grabar".equals(command)){
					altaCuentaService.save(mapParamRequest,entidad,version);
					mapParamRequest.put("listTR31530", altaCuentaService.findAll());
				}
				
				if("fila".equals(command)){
					String fila = (String) request.getParameter("rowid");										
					mapParamRequest = altaCuentaService.findById(fila);					
				}
				
				if("eliminar".equals(command)){					
					String fila = (String) request.getParameter("rowid");
					altaCuentaService.delete(fila);					
					mapParamRequest.put("codRespJPA","Eliminacion Correcta!!!");
					mapParamRequest.put("listTR31530", altaCuentaService.findAll());
				}

				if("update".equals(command)){
					String id = (String) request.getParameter("id");
					altaCuentaService.update(mapParamRequest,id,entidad,version);
					mapParamRequest.put("codRespJPA","Modficacion Correcta!!!");
					mapParamRequest.put("listTR31530", altaCuentaService.findAll());
				}

				pageResponse = "/tr31530.jsp";
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
