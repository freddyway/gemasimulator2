package es.redsys.configuracion.services;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.redsys.configuracion.model.T32082;

@Stateless
public class AltaServicioDCCService {
	private static final Logger logger =  LoggerFactory.getLogger(AltaServicioDCCService.class);
	
	@PersistenceContext
	private EntityManager em = null;

	public AltaServicioDCCService() {
		
	}

	@SuppressWarnings("unchecked")
	public List<T32082> findAll() {
		     
		Query query = em.createNamedQuery("T32082.findAll");		
		List<T32082> list = query.getResultList();
		
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest) throws Exception {	
		T32082 t32082 = new T32082();
		t32082.setC01((String) mapParamRequest.get("c01"));
		t32082.setC02((String) mapParamRequest.get("c02"));
		t32082.setC03((String) mapParamRequest.get("c03"));
		t32082.setC04((String) mapParamRequest.get("c04"));
		t32082.setC05((String) mapParamRequest.get("c05"));
		t32082.setC06((String) mapParamRequest.get("c06"));
		t32082.setC07((String) mapParamRequest.get("c07"));
		t32082.setC08((String) mapParamRequest.get("c08"));
		t32082.setC09((String) mapParamRequest.get("c09"));
		t32082.setC10((String) mapParamRequest.get("c10"));
		t32082.setC11((String) mapParamRequest.get("c11"));
		t32082.setC12((String) mapParamRequest.get("c12"));
		t32082.setC13((String) mapParamRequest.get("c13"));
		
		logger.debug(t32082.toString());
		
		em.persist(t32082);		
	}


	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		T32082 t32082 = em.find(T32082.class, new Integer(rowid));
		if(t32082 != null){
			logger.debug(t32082.toString());
			
			mapParamRequest.put("c01", t32082.getC01());
			mapParamRequest.put("c02", t32082.getC02());
			mapParamRequest.put("c03", t32082.getC03());
			mapParamRequest.put("c04", t32082.getC04());
			mapParamRequest.put("c05", t32082.getC05());
			mapParamRequest.put("c06", t32082.getC06());
			mapParamRequest.put("c07", t32082.getC07());
			mapParamRequest.put("c08", t32082.getC08());
			mapParamRequest.put("c09", t32082.getC09());
			mapParamRequest.put("c10", t32082.getC10());
			mapParamRequest.put("c11", t32082.getC11());
			mapParamRequest.put("c12", t32082.getC12());
			mapParamRequest.put("c13", t32082.getC13());
			
			mapParamRequest.put("version", t32082.getVersion());
		}
		
		return mapParamRequest;
	}

}
