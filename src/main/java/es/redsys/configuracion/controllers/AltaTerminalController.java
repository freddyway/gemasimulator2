package es.redsys.configuracion.controllers;

import java.io.IOException;
import java.util.List;
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

import es.redsys.configuracion.model.T31510;
import es.redsys.configuracion.services.AltaTerminalService;
import es.redsys.configuracion.services.GemaOroService;
import es.redsys.configuracion.util.RequestParamsMapper;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "AltaTerminalServlet", urlPatterns = {"/altaterminal"})

public class AltaTerminalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =  LoggerFactory.getLogger(AltaTerminalController.class);
	
	private List<T31510> listT31510;
		
	@EJB
	AltaTerminalService altaTerminalService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaTerminalController() {
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
				
		logger.info("AltaTerminalController...");
		
		try{
			Map<String,Object> mapParamRequest = RequestParamsMapper.toMap(request); 
							
			String contextPath = request.getContextPath();
			logger.debug(contextPath);
			
			String servletPath = request.getServletPath();
			logger.debug(servletPath);

			if("/altaterminal".equals(servletPath)){					
				command = request.getParameter("command");
				logger.info("command="+command);
				
				if("consultar".equals(command)){
					listT31510 = altaTerminalService.findAll();
					mapParamRequest.put("listTR31510", listT31510);					
				}
				if("procesar".equals(command)){
					entidad = request.getParameter("entidad");
					version = request.getParameter("version");
					GemaOroService gemaOroService = new GemaOroService();
					respuesta = gemaOroService.processRequest(mapParamRequest,"31510",version,entidad);
					mapParamRequest.put("codRespuesta", respuesta[8]);
				}
				
				if("grabar".equals(command)){
					altaTerminalService.save(mapParamRequest);
				}
				
				if("fila".equals(command)){
					String fila = (String) request.getParameter("rowid");
					mapParamRequest = altaTerminalService.findById(fila);
				}
				
				pageResponse = "/tr31510.jsp";
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
