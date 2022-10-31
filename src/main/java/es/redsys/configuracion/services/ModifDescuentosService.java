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

import es.redsys.configuracion.model.T31522;

@Stateless
public class ModifDescuentosService {

	private static final Logger logger =  LoggerFactory.getLogger(ModifDescuentosService.class);

	@PersistenceContext
	private EntityManager em = null;
	
	public ModifDescuentosService() {

	}
	
	@SuppressWarnings("unchecked")	
	public List<T31522> findAll() {
		Query query = em.createNamedQuery("T31522.findAll");				
		List<T31522> list = query.getResultList();
		
		return list;
	}

	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
		T31522 t31522 = em.find(T31522.class, new Integer(rowid));
				
		if(t31522 != null){
			logger.debug(t31522.toString());
			mapParamRequest.put("id", t31522.getId());
			mapParamRequest.put("c01", t31522.getC01());
			mapParamRequest.put("c02", t31522.getC02());
			mapParamRequest.put("c03", t31522.getC03());
			mapParamRequest.put("c04", t31522.getC04());
			mapParamRequest.put("c05", t31522.getC05());
			mapParamRequest.put("c06", t31522.getC06());
			mapParamRequest.put("c07", t31522.getC07());
			mapParamRequest.put("c08", t31522.getC08());
			mapParamRequest.put("c09", t31522.getC09());
			mapParamRequest.put("c10", t31522.getC10());
			mapParamRequest.put("c11", t31522.getC11());
			mapParamRequest.put("c12", t31522.getC12());
			mapParamRequest.put("c13", t31522.getC13());
			mapParamRequest.put("c14", t31522.getC14());
			mapParamRequest.put("c15", t31522.getC15());
			mapParamRequest.put("c16", t31522.getC16());
			mapParamRequest.put("c17", t31522.getC17());
			mapParamRequest.put("c18", t31522.getC18());
			mapParamRequest.put("c19", t31522.getC19());
			mapParamRequest.put("c20", t31522.getC20());
			
			mapParamRequest.put("version", t31522.getVersion());
			mapParamRequest.put("entidad", t31522.getBanco());
		}

		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	

		T31522 t31522 = new T31522();
		t31522.setC01((String) mapParamRequest.get("c01"));
		t31522.setC02((String) mapParamRequest.get("c02"));
		t31522.setC03((String) mapParamRequest.get("c03"));
		t31522.setC04((String) mapParamRequest.get("c04"));
		t31522.setC05((String) mapParamRequest.get("c05"));
		t31522.setC06((String) mapParamRequest.get("c06"));
		t31522.setC07((String) mapParamRequest.get("c07"));
		t31522.setC08((String) mapParamRequest.get("c08"));
		t31522.setC09((String) mapParamRequest.get("c09"));
		t31522.setC10((String) mapParamRequest.get("c10"));
		t31522.setC11((String) mapParamRequest.get("c11"));
		t31522.setC12((String) mapParamRequest.get("c12"));
		t31522.setC13((String) mapParamRequest.get("c13"));
		t31522.setC14((String) mapParamRequest.get("c14"));
		t31522.setC15((String) mapParamRequest.get("c15"));
		t31522.setC16((String) mapParamRequest.get("c16"));
		t31522.setC17((String) mapParamRequest.get("c17"));
		t31522.setC18((String) mapParamRequest.get("c18"));
		t31522.setC19((String) mapParamRequest.get("c19"));
		t31522.setC20((String) mapParamRequest.get("c20"));
		
		t31522.setFechaTrans(new Date());
		t31522.setBanco(entidad);
		t31522.setVersion(version);
		
		logger.debug(t31522.toString());
		
		em.persist(t31522);			
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T31522 t31522 = em.find(T31522.class, new Integer(fila));
		em.remove(t31522);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
		T31522 t31522 = em.find(T31522.class, new Integer(fila));
		
		t31522.setC01((String) mapParamRequest.get("c01"));
		t31522.setC02((String) mapParamRequest.get("c02"));
		t31522.setC03((String) mapParamRequest.get("c03"));
		t31522.setC04((String) mapParamRequest.get("c04"));
		t31522.setC05((String) mapParamRequest.get("c05"));
		t31522.setC06((String) mapParamRequest.get("c06"));
		t31522.setC07((String) mapParamRequest.get("c07"));
		t31522.setC08((String) mapParamRequest.get("c08"));
		t31522.setC09((String) mapParamRequest.get("c09"));
		t31522.setC10((String) mapParamRequest.get("c10"));
		t31522.setC11((String) mapParamRequest.get("c11"));
		t31522.setC12((String) mapParamRequest.get("c12"));
		t31522.setC13((String) mapParamRequest.get("c13"));
		t31522.setC14((String) mapParamRequest.get("c14"));
		t31522.setC15((String) mapParamRequest.get("c15"));
		t31522.setC16((String) mapParamRequest.get("c16"));
		t31522.setC17((String) mapParamRequest.get("c17"));
		t31522.setC18((String) mapParamRequest.get("c18"));
		t31522.setC19((String) mapParamRequest.get("c19"));
		t31522.setC20((String) mapParamRequest.get("c20"));
		
		t31522.setBanco(entidad);
		t31522.setVersion(version);
	}


}
