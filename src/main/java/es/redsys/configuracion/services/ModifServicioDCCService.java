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

import es.redsys.configuracion.model.T32081;

@Stateless
public class ModifServicioDCCService {
	private static final Logger logger =  LoggerFactory.getLogger(ModifServicioDCCService.class);
	
	@PersistenceContext
	private EntityManager em = null;
	
	public ModifServicioDCCService() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<T32081> findAll() {
		Query query = em.createNamedQuery("T32081.findAll");		
		List<T32081> list = query.getResultList();
		return list;
	}

	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		T32081 t32081 = em.find(T32081.class, new Integer(rowid));
		if(t32081 != null){
			logger.debug(t32081.toString());
			
			mapParamRequest.put("c01", t32081.getC01());
			mapParamRequest.put("c02", t32081.getC02());
			mapParamRequest.put("c03", t32081.getC03());
			mapParamRequest.put("c04", t32081.getC04());
			mapParamRequest.put("c05", t32081.getC05());
			mapParamRequest.put("c06", t32081.getC06());
			mapParamRequest.put("c07", t32081.getC07());
			mapParamRequest.put("c08", t32081.getC08());
			mapParamRequest.put("c09", t32081.getC09());
			mapParamRequest.put("c10", t32081.getC10());
			mapParamRequest.put("c11", t32081.getC11());
			mapParamRequest.put("c12", t32081.getC12());
			mapParamRequest.put("c13", t32081.getC13());
		}
		
		return mapParamRequest;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest) throws Exception {	
		T32081 t32081 = new T32081();
		t32081.setC01((String) mapParamRequest.get("c01"));
		t32081.setC02((String) mapParamRequest.get("c02"));
		t32081.setC03((String) mapParamRequest.get("c03"));
		t32081.setC04((String) mapParamRequest.get("c04"));
		t32081.setC05((String) mapParamRequest.get("c05"));
		t32081.setC06((String) mapParamRequest.get("c06"));
		t32081.setC07((String) mapParamRequest.get("c07"));
		t32081.setC08((String) mapParamRequest.get("c08"));
		t32081.setC09((String) mapParamRequest.get("c09"));
		t32081.setC10((String) mapParamRequest.get("c10"));
		t32081.setC11((String) mapParamRequest.get("c11"));
		t32081.setC12((String) mapParamRequest.get("c12"));
		t32081.setC13((String) mapParamRequest.get("c13"));
		
		logger.debug(t32081.toString());
		
		em.persist(t32081);
	}

}
