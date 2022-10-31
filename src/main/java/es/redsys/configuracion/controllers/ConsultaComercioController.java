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

import es.redsys.configuracion.services.ConsultaComercioService;
import es.redsys.configuracion.services.GemaOroService;
import es.redsys.configuracion.services.ejb.AltaComercioServiceEJB;
import es.redsys.configuracion.util.RequestParamsMapper;


/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(name = "ConsultaComercioServlet", urlPatterns = {"/consulcomercio"})

public class ConsultaComercioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger =  LoggerFactory.getLogger(ConsultaComercioController.class);
	
	@EJB
	ConsultaComercioService consultaComercioService;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaComercioController() {
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
		
		logger.info("ConsultaComercioController...");
		
		try{
			Map<String,Object> mapParamRequest = RequestParamsMapper.toMap(request); 
						
			String contextPath = request.getContextPath();
			logger.debug(contextPath);
			
			String servletPath = request.getServletPath();
			logger.debug(servletPath);
														
			if("/consulcomercio".equals(servletPath)){
				String command = request.getParameter("command");
				logger.info("command="+command);
								
//				if("consultar".equals(command)){
//					mapParamRequest.put("listTR31500", altaComercioService.consultarT31500Regs());					
//				}
				if("procesar".equals(command)){
					entidad = request.getParameter("entidad");
					version = request.getParameter("version");
					GemaOroService gemaOroService = new GemaOroService();
					respuesta = gemaOroService.processRequest(mapParamRequest,"31502",version,entidad);					
					mapParamRequest = consultaComercioService.mapper(respuesta);
					mapParamRequest.put("codRespuesta", respuesta[8]);
				}
//				if("grabar".equals(command)){
//					altaComercioService.grabarT31500Reg(mapParamRequest);
//				}
//
//				if("eliminar".equals(command)){
//					String fila = (String) request.getParameter("rowid");
//					altaComercioService.eliminarT31500Reg(fila);					
//					mapParamRequest.put("codRespJPA","Eliminacion Correcta!!!");
//				}
//
//				if("update".equals(command)){
//					altaComercioService.updateT31500Reg(mapParamRequest);
//					mapParamRequest.put("codRespJPA","Modficacion Correcta!!!");
//				}
//
//				if("fila".equals(command)){
//					String fila = (String) request.getParameter("rowid");
//					mapParamRequest = altaComercioService.consultarT31500Reg(fila);
//				}
				
				pageResponse = "/tr31502.jsp";
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
