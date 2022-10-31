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

import es.redsys.configuracion.model.T31503;

@Stateless
public class ModifComercioService {

	private static final Logger logger =  LoggerFactory.getLogger(ModifComercioService.class);

	@PersistenceContext
	private EntityManager em = null;
	
	public ModifComercioService() {

	}
	
	@SuppressWarnings("unchecked")	
	public List<T31503> findAll() {
		Query query = em.createNamedQuery("T31503.findAll");				
		List<T31503> list = query.getResultList();
		
		return list;
	}

	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
		T31503 t31503 = em.find(T31503.class, new Integer(rowid));
				
		if(t31503 != null){
			logger.debug(t31503.toString());
			mapParamRequest.put("id", t31503.getId());
			mapParamRequest.put("c01", t31503.getC01());
			mapParamRequest.put("c02", t31503.getC02());
			mapParamRequest.put("c03", t31503.getC03());
			mapParamRequest.put("c04", t31503.getC04());
			mapParamRequest.put("c05", t31503.getC05());
			mapParamRequest.put("c06", t31503.getC06());
			mapParamRequest.put("c07", t31503.getC07());
			mapParamRequest.put("c08", t31503.getC08());
			mapParamRequest.put("c09", t31503.getC09());
			mapParamRequest.put("c10", t31503.getC10());
			mapParamRequest.put("c11", t31503.getC11());
			mapParamRequest.put("c12", t31503.getC12());
			mapParamRequest.put("c13", t31503.getC13());
			mapParamRequest.put("c14", t31503.getC14());
			mapParamRequest.put("c15", t31503.getC15());
			mapParamRequest.put("c16", t31503.getC16());
			mapParamRequest.put("c17", t31503.getC17());
			mapParamRequest.put("c18", t31503.getC18());
			mapParamRequest.put("c19", t31503.getC19());
			mapParamRequest.put("c20", t31503.getC20());
			mapParamRequest.put("c21", t31503.getC21());
			mapParamRequest.put("c22", t31503.getC22());
			mapParamRequest.put("c23", t31503.getC23());
			mapParamRequest.put("c24", t31503.getC24());
			
			mapParamRequest.put("version", t31503.getVersion());
			mapParamRequest.put("entidad", t31503.getBanco());
		}

		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	

		T31503 t31503 = new T31503();
		t31503.setC01((String) mapParamRequest.get("c01"));
		t31503.setC02((String) mapParamRequest.get("c02"));
		t31503.setC03((String) mapParamRequest.get("c03"));
		t31503.setC04((String) mapParamRequest.get("c04"));
		t31503.setC05((String) mapParamRequest.get("c05"));
		t31503.setC06((String) mapParamRequest.get("c06"));
		t31503.setC07((String) mapParamRequest.get("c07"));
		t31503.setC08((String) mapParamRequest.get("c08"));
		t31503.setC09((String) mapParamRequest.get("c09"));
		t31503.setC10((String) mapParamRequest.get("c10"));
		t31503.setC11((String) mapParamRequest.get("c11"));
		t31503.setC12((String) mapParamRequest.get("c12"));
		t31503.setC13((String) mapParamRequest.get("c13"));
		t31503.setC14((String) mapParamRequest.get("c14"));
		t31503.setC15((String) mapParamRequest.get("c15"));
		t31503.setC16((String) mapParamRequest.get("c16"));
		t31503.setC17((String) mapParamRequest.get("c17"));
		t31503.setC18((String) mapParamRequest.get("c18"));
		t31503.setC19((String) mapParamRequest.get("c19"));
		t31503.setC20((String) mapParamRequest.get("c20"));
		t31503.setC21((String) mapParamRequest.get("c21"));
		t31503.setC22((String) mapParamRequest.get("c22"));
		t31503.setC23((String) mapParamRequest.get("c23"));
		t31503.setC24((String) mapParamRequest.get("c24"));
		
		t31503.setFechaTrans(new Date());
		t31503.setBanco(entidad);
		t31503.setVersion(version);
		
		logger.debug(t31503.toString());
		
		em.persist(t31503);			
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T31503 t31503 = em.find(T31503.class, new Integer(fila));
		em.remove(t31503);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
		T31503 t31503 = em.find(T31503.class, new Integer(fila));
		
		t31503.setC01((String) mapParamRequest.get("c01"));
		t31503.setC02((String) mapParamRequest.get("c02"));
		t31503.setC03((String) mapParamRequest.get("c03"));
		t31503.setC04((String) mapParamRequest.get("c04"));
		t31503.setC05((String) mapParamRequest.get("c05"));
		t31503.setC06((String) mapParamRequest.get("c06"));
		t31503.setC07((String) mapParamRequest.get("c07"));
		t31503.setC08((String) mapParamRequest.get("c08"));
		t31503.setC09((String) mapParamRequest.get("c09"));
		t31503.setC10((String) mapParamRequest.get("c10"));
		t31503.setC11((String) mapParamRequest.get("c11"));
		t31503.setC12((String) mapParamRequest.get("c12"));
		t31503.setC13((String) mapParamRequest.get("c13"));
		t31503.setC14((String) mapParamRequest.get("c14"));
		t31503.setC15((String) mapParamRequest.get("c15"));
		t31503.setC16((String) mapParamRequest.get("c16"));
		t31503.setC17((String) mapParamRequest.get("c17"));
		t31503.setC18((String) mapParamRequest.get("c18"));
		t31503.setC19((String) mapParamRequest.get("c19"));
		t31503.setC20((String) mapParamRequest.get("c20"));
		t31503.setC21((String) mapParamRequest.get("c21"));
		t31503.setC22((String) mapParamRequest.get("c22"));
		t31503.setC23((String) mapParamRequest.get("c23"));
		t31503.setC24((String) mapParamRequest.get("c24"));
		
		t31503.setBanco(entidad);
		t31503.setVersion(version);
	}


}
