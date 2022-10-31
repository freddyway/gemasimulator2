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
import es.redsys.configuracion.services.ModifCuentaService;
import es.redsys.configuracion.util.RequestParamsMapper;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "ModifCuentaServlet", urlPatterns = {"/modifcuenta"})

public class ModifCuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =  LoggerFactory.getLogger(ModifCuentaController.class);
	private static final String TRX_GEMA = "31532";
		
	@EJB
	ModifCuentaService modifCuentaService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifCuentaController() {
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
		Map<String,Object> mapParamRequest = null;
		
		logger.info("ModifCuentaController...");
		
		try{
			mapParamRequest = RequestParamsMapper.toMap(request); 
							
			String contextPath = request.getContextPath();
			logger.debug(contextPath);
			
			String servletPath = request.getServletPath();
			logger.debug(servletPath);
						
			if("/modifcuenta".equals(servletPath)){					
				command = request.getParameter("command");
				entidad = request.getParameter("entidad");
				version = request.getParameter("version");

				logger.info("command="+command);
				pageResponse = "/tr31532.jsp";
				
				if("consultar".equals(command)){
					mapParamRequest.put("listTR31532", modifCuentaService.findAll());					
				}
				
				if("procesar".equals(command)){
					GemaOroService gemaOroService = new GemaOroService();
					respuesta = gemaOroService.processRequest(mapParamRequest,TRX_GEMA,version,entidad);	
					if(respuesta != null && respuesta.length > 0)
					   mapParamRequest.put("codRespuesta", respuesta[8]);
					else
					   mapParamRequest.put("codRespuesta", "9999");
				}
				
				if("grabar".equals(command)){
					modifCuentaService.save(mapParamRequest,entidad,version);
					mapParamRequest.put("listTR31532", modifCuentaService.findAll());
				}
				
				if("fila".equals(command)){
					String fila = (String) request.getParameter("rowid");										
					mapParamRequest = modifCuentaService.findById(fila);					
				}
				
				if("eliminar".equals(command)){					
					String fila = (String) request.getParameter("rowid");
					modifCuentaService.delete(fila);					
					mapParamRequest.put("codRespJPA","Eliminacion Correcta!!!");
					mapParamRequest.put("listTR31532", modifCuentaService.findAll());
				}

				if("update".equals(command)){
					String id = (String) request.getParameter("id");
					modifCuentaService.update(mapParamRequest,id,entidad,version);
					mapParamRequest.put("codRespJPA","Modficacion Correcta!!!");
					mapParamRequest.put("listTR31532", modifCuentaService.findAll());
				}
			}
			
			request.setAttribute("respuesta", mapParamRequest);
			logger.debug(mapParamRequest.toString());			
		}
		catch(Exception e){
			logger.error("ERROR GENERAL!!!!",e);			
		} finally {
			request.getRequestDispatcher(pageResponse).forward(request, response);
		}
	}	
}
