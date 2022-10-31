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

import es.redsys.configuracion.model.T31510;

@Stateless
public class AltaTerminalService {
	private static final Logger logger =  LoggerFactory.getLogger(AltaTerminalService.class);

	@PersistenceContext
	private EntityManager em = null;
	
	@SuppressWarnings("unchecked")
	public List<T31510> findAll() {
		Query query = em.createNamedQuery("T31510.findAll");		
		List<T31510> list = query.getResultList();
		
		return list;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest) throws Exception {	
		T31510 t31510 = new T31510();
		t31510.setC01((String) mapParamRequest.get("c01"));
		t31510.setC02((String) mapParamRequest.get("c02"));
		t31510.setC03((String) mapParamRequest.get("c03"));
		t31510.setC04((String) mapParamRequest.get("c04"));
		t31510.setC05((String) mapParamRequest.get("c05"));
		t31510.setC06((String) mapParamRequest.get("c06"));
		t31510.setC07((String) mapParamRequest.get("c07"));
		t31510.setC08((String) mapParamRequest.get("c08"));
		t31510.setC09((String) mapParamRequest.get("c09"));
		t31510.setC10((String) mapParamRequest.get("c10"));
		t31510.setC11((String) mapParamRequest.get("c11"));
		t31510.setC12((String) mapParamRequest.get("c12"));
		t31510.setC13((String) mapParamRequest.get("c13"));
		t31510.setC14((String) mapParamRequest.get("c14"));
		t31510.setC15((String) mapParamRequest.get("c15"));
		t31510.setC16((String) mapParamRequest.get("c16"));
		t31510.setC17((String) mapParamRequest.get("c17"));
		t31510.setC18((String) mapParamRequest.get("c18"));
		t31510.setC19((String) mapParamRequest.get("c19"));
		t31510.setC20((String) mapParamRequest.get("c20"));
		t31510.setC21((String) mapParamRequest.get("c21"));
		t31510.setC22((String) mapParamRequest.get("c22"));
		t31510.setC23((String) mapParamRequest.get("c23"));
				
		logger.debug(t31510.toString());
		em.persist(t31510);		
	}
	
	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
				     
		T31510 t31510 = em.find(T31510.class, new Integer(rowid));
				
		if(t31510 != null){
			logger.debug(t31510.toString());
			
			mapParamRequest.put("c01", t31510.getC01());
			mapParamRequest.put("c02", t31510.getC02());
			mapParamRequest.put("c03", t31510.getC03());
			mapParamRequest.put("c04", t31510.getC04());
			mapParamRequest.put("c05", t31510.getC05());
			mapParamRequest.put("c06", t31510.getC06());
			mapParamRequest.put("c07", t31510.getC07());
			mapParamRequest.put("c08", t31510.getC08());
			mapParamRequest.put("c09", t31510.getC09());
			mapParamRequest.put("c10", t31510.getC10());
		}

		return mapParamRequest;
	}


}
