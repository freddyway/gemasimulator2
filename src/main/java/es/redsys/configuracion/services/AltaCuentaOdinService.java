package es.redsys.configuracion.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.redsys.configuracion.model.T71530;

@Stateless
public class AltaCuentaOdinService {
	private static final Logger logger =  LoggerFactory.getLogger(AltaCuentaOdinService.class);
	
	@PersistenceContext
	private EntityManager em = null;
		
	@SuppressWarnings("unchecked")
	public List<T71530> findAll(){
	    
//		em.getTransaction().begin();
		
		Query query = em.createNamedQuery("T71530.findAll");		
		List<T71530> list = query.getResultList();
		
//		em.getTransaction().commit();
		
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
//		em.getTransaction().begin();
		
		T71530 t71530 = em.find(T71530.class, new Integer(rowid));
		
		if(t71530 != null){
			logger.debug(t71530.toString());
			mapParamRequest.put("id",  t71530.getId());
			mapParamRequest.put("c01", t71530.getC01());
			mapParamRequest.put("c02", t71530.getC02());
			mapParamRequest.put("c03", t71530.getC03());
			mapParamRequest.put("c04", t71530.getC04());
			mapParamRequest.put("c05", t71530.getC05());
			mapParamRequest.put("c06", t71530.getC06());
			mapParamRequest.put("c07", t71530.getC07());
			mapParamRequest.put("c08", t71530.getC08());
			mapParamRequest.put("c09", t71530.getC09());
			mapParamRequest.put("c10", t71530.getC10());
			mapParamRequest.put("c11", t71530.getC11());
			mapParamRequest.put("c12", t71530.getC12());
			mapParamRequest.put("c13", t71530.getC13());
			
			mapParamRequest.put("entidad", t71530.getBanco());
			mapParamRequest.put("version", t71530.getVersion());
		}
		
//		em.getTransaction().commit();
		
		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	
						
		T71530 t71530 = new T71530();
		t71530.setC01((String) mapParamRequest.get("c01"));
		t71530.setC02((String) mapParamRequest.get("c02"));
		t71530.setC03((String) mapParamRequest.get("c03"));
		t71530.setC04((String) mapParamRequest.get("c04"));
		t71530.setC05((String) mapParamRequest.get("c05"));
		t71530.setC06((String) mapParamRequest.get("c06"));
		t71530.setC07((String) mapParamRequest.get("c07"));
		t71530.setC08((String) mapParamRequest.get("c08"));
		t71530.setC09((String) mapParamRequest.get("c09"));
		t71530.setC10((String) mapParamRequest.get("c10"));
		t71530.setC11((String) mapParamRequest.get("c11"));
		t71530.setC12((String) mapParamRequest.get("c12"));
		t71530.setC13((String) mapParamRequest.get("c13"));
		
		t71530.setFechaTrans(new Date());
		t71530.setBanco(entidad);
		t71530.setVersion(version);

		logger.debug(t71530.toString());
		
		em.persist(t71530);
	}

//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
//		em.getTransaction().begin();
		
		T71530 t71530 = em.find(T71530.class, new Integer(fila));
		
		t71530.setC01((String) mapParamRequest.get("c01"));
		t71530.setC02((String) mapParamRequest.get("c02"));
		t71530.setC03((String) mapParamRequest.get("c03"));
		t71530.setC04((String) mapParamRequest.get("c04"));
		t71530.setC05((String) mapParamRequest.get("c05"));
		t71530.setC06((String) mapParamRequest.get("c06"));
		t71530.setC07((String) mapParamRequest.get("c07"));
		t71530.setC08((String) mapParamRequest.get("c08"));
		t71530.setC09((String) mapParamRequest.get("c09"));
		t71530.setC10((String) mapParamRequest.get("c10"));
		t71530.setC11((String) mapParamRequest.get("c11"));
		t71530.setC12((String) mapParamRequest.get("c12"));
		t71530.setC13((String) mapParamRequest.get("c13"));
		
		t71530.setFechaTrans(new Date());
		t71530.setBanco(entidad);
		t71530.setVersion(version);
		
//		em.getTransaction().commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T71530 t71530 = em.find(T71530.class, new Integer(fila));
		em.remove(t71530);
	}
}
