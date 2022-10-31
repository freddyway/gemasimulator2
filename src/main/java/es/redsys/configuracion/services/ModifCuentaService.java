package es.redsys.configuracion.services;

import java.util.Date;
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

import es.redsys.configuracion.model.T31532;

@Stateless
public class ModifCuentaService {
	private static final Logger logger =  LoggerFactory.getLogger(ModifCuentaService.class);
	
	@PersistenceContext
	private EntityManager em = null;
		
	@SuppressWarnings("unchecked")
	public List<T31532> findAll(){
	    
//		em.getTransaction().begin();
		
		Query query = em.createNamedQuery("T31532.findAll");		
		List<T31532> list = query.getResultList();
		
//		em.getTransaction().commit();
		
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
//		em.getTransaction().begin();
		
		T31532 t31532 = em.find(T31532.class, new Integer(rowid));
		
		if(t31532 != null){
			logger.debug(t31532.toString());
			mapParamRequest.put("id",  t31532.getId());
			mapParamRequest.put("c01", t31532.getC01());
			mapParamRequest.put("c02", t31532.getC02());
			mapParamRequest.put("c03", t31532.getC03());
			mapParamRequest.put("c04", t31532.getC04());
			mapParamRequest.put("c05", t31532.getC05());
			mapParamRequest.put("c06", t31532.getC06());
			mapParamRequest.put("c07", t31532.getC07());
			mapParamRequest.put("c08", t31532.getC08());
			mapParamRequest.put("c09", t31532.getC09());
			mapParamRequest.put("c10", t31532.getC10());
			mapParamRequest.put("c11", t31532.getC11());
			mapParamRequest.put("c12", t31532.getC12());
			mapParamRequest.put("c13", t31532.getC13());
			
			mapParamRequest.put("version", t31532.getVersion());
			mapParamRequest.put("entidad", t31532.getBanco());
		}
		
//		em.getTransaction().commit();
		
		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	
						
		T31532 t31532 = new T31532();
		t31532.setC01((String) mapParamRequest.get("c01"));
		t31532.setC02((String) mapParamRequest.get("c02"));
		t31532.setC03((String) mapParamRequest.get("c03"));
		t31532.setC04((String) mapParamRequest.get("c04"));
		t31532.setC05((String) mapParamRequest.get("c05"));
		t31532.setC06((String) mapParamRequest.get("c06"));
		t31532.setC07((String) mapParamRequest.get("c07"));
		t31532.setC08((String) mapParamRequest.get("c08"));
		t31532.setC09((String) mapParamRequest.get("c09"));
		t31532.setC10((String) mapParamRequest.get("c10"));
		t31532.setC11((String) mapParamRequest.get("c11"));
		t31532.setC12((String) mapParamRequest.get("c12"));
		t31532.setC13((String) mapParamRequest.get("c13"));
		
		t31532.setFechaTrans(new Date());
		t31532.setBanco(entidad);
		t31532.setVersion(version);

		logger.debug(t31532.toString());
		
		em.persist(t31532);
	}

//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
//		em.getTransaction().begin();
		
		T31532 t31532 = em.find(T31532.class, new Integer(fila));
		
		t31532.setC01((String) mapParamRequest.get("c01"));
		t31532.setC02((String) mapParamRequest.get("c02"));
		t31532.setC03((String) mapParamRequest.get("c03"));
		t31532.setC04((String) mapParamRequest.get("c04"));
		t31532.setC05((String) mapParamRequest.get("c05"));
		t31532.setC06((String) mapParamRequest.get("c06"));
		t31532.setC07((String) mapParamRequest.get("c07"));
		t31532.setC08((String) mapParamRequest.get("c08"));
		t31532.setC09((String) mapParamRequest.get("c09"));
		t31532.setC10((String) mapParamRequest.get("c10"));
		t31532.setC11((String) mapParamRequest.get("c11"));
		t31532.setC12((String) mapParamRequest.get("c12"));
		t31532.setC13((String) mapParamRequest.get("c13"));
		
		t31532.setFechaTrans(new Date());
		t31532.setBanco(entidad);
		t31532.setVersion(version);
		
//		em.getTransaction().commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T31532 t31532 = em.find(T31532.class, new Integer(fila));
		em.remove(t31532);
	}
}
