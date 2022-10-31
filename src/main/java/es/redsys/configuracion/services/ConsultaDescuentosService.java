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

import es.redsys.configuracion.model.T31521;

@Stateless
public class ConsultaDescuentosService {
	private static final Logger logger =  LoggerFactory.getLogger(ConsultaDescuentosService.class);
	
	@PersistenceContext
	private EntityManager em = null;
	
	@SuppressWarnings("unchecked")
	public List<T31521> findAll(){
	     
		Query query = em.createNamedQuery("T31521.findAll");		
		List<T31521> list = query.getResultList();
		
		return list;
	}
	
	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		T31521 t31521 = em.find(T31521.class, new Integer(rowid));
		
		if(t31521 != null){
			logger.debug(t31521.toString());
			mapParamRequest.put("id",  t31521.getId());
			mapParamRequest.put("c01", t31521.getC01());
			mapParamRequest.put("c02", t31521.getC02());
			mapParamRequest.put("c03", t31521.getC03());
			
			mapParamRequest.put("version", t31521.getVersion());
		}
		
		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	
						
		T31521 t31521 = new T31521();
		t31521.setC01((String) mapParamRequest.get("c01"));
		t31521.setC02((String) mapParamRequest.get("c02"));
		t31521.setC03((String) mapParamRequest.get("c03"));
		
		t31521.setFechaTrans(new Date());
		t31521.setBanco(entidad);
		t31521.setVersion(version);

		logger.debug(t31521.toString());
		
		em.persist(t31521);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
		T31521 t31521 = em.find(T31521.class, new Integer(fila));
		
		t31521.setC01((String) mapParamRequest.get("c01"));
		t31521.setC02((String) mapParamRequest.get("c02"));
		t31521.setC03((String) mapParamRequest.get("c03"));
		
		t31521.setFechaTrans(new Date());
		t31521.setBanco(entidad);
		t31521.setVersion(version);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T31521 t31521 = em.find(T31521.class, new Integer(fila));
		em.remove(t31521);
	}
}
