package es.redsys.configuracion.util;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class EntityMapper<T> {
	private static final Logger logger =  LoggerFactory.getLogger(EntityMapper.class);
	
	private Class<T> entityClass;

    public EntityMapper(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
	@SuppressWarnings("rawtypes")
	public Map<String,Object> toMap(T entity){
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
//		Enumeration enumeration = request.getParameterNames();
//		while(enumeration.hasMoreElements())
//		{						
//			String paramName = (String) enumeration.nextElement();
//			logger.debug(paramName+"="+request.getParameter(paramName));
//			
//			if(!"command".equals(paramName) && !"entidad".equals(paramName) && !"id".equals(paramName) && !"version".equals(paramName))
//				mapParamRequest.put(paramName, request.getParameter(paramName));
//		}
		
		logger.debug("MapParamsRequest="+mapParamRequest);
		
		return mapParamRequest;
	}
}
