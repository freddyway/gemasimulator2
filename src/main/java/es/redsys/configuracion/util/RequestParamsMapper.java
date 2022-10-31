package es.redsys.configuracion.util;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestParamsMapper {
	private static final Logger logger =  LoggerFactory.getLogger(RequestParamsMapper.class);
	
	@SuppressWarnings("rawtypes")
	public static Map<String,Object> toMap(HttpServletRequest request){
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
		Enumeration enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements())
		{						
			String paramName = (String) enumeration.nextElement();
			logger.debug(paramName+"="+request.getParameter(paramName));
			
			if(!"command".equals(paramName) && !"entidad".equals(paramName) && !"id".equals(paramName) && !"version".equals(paramName))
				mapParamRequest.put(paramName, request.getParameter(paramName));
		}
		
		logger.debug("MapParamsRequest="+mapParamRequest);
		
		return mapParamRequest;
	}
}
