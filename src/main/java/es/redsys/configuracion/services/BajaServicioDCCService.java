package es.redsys.configuracion.services;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class BajaServicioDCCService {

	private static final Logger logger =  LoggerFactory.getLogger(BajaServicioDCCService.class);
	
	public BajaServicioDCCService() {
		
	}
	
	public Map<String,Object> getRow(String fila){
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
		logger.debug("fila="+fila);
		
		StringTokenizer tokenizer = new StringTokenizer(fila, ";");
		mapParamRequest.put("c01", tokenizer.nextElement());				
		mapParamRequest.put("c02", tokenizer.nextElement());
		mapParamRequest.put("c03", tokenizer.nextElement());
		mapParamRequest.put("c04", tokenizer.nextElement());
		mapParamRequest.put("c05", tokenizer.nextElement());				
		mapParamRequest.put("c06", tokenizer.nextElement());
		mapParamRequest.put("c07", tokenizer.nextElement());
		mapParamRequest.put("c08", tokenizer.nextElement());
		mapParamRequest.put("c09", tokenizer.nextElement());
		mapParamRequest.put("c10", tokenizer.nextElement());
		mapParamRequest.put("c11", tokenizer.nextElement());
		
		return mapParamRequest;
	}

}
