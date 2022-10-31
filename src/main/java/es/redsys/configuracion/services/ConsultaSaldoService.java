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

import es.redsys.configuracion.model.T31245;
import es.redsys.configuracion.model.T31533;

@Stateless
public class ConsultaSaldoService {
	private static final Logger logger =  LoggerFactory.getLogger(ConsultaSaldoService.class);
	
	@PersistenceContext
	private EntityManager em = null;
	
	@SuppressWarnings("unchecked")
	public List<T31245> findAll(){
	     
		Query query = em.createNamedQuery("T31245.findAll");		
		List<T31245> list = query.getResultList();
		
		return list;
	}
	
	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		T31245 t31245 = em.find(T31245.class, new Integer(rowid));
		
		if(t31245 != null){
			logger.debug(t31245.toString());
			mapParamRequest.put("id",  t31245.getId());
			mapParamRequest.put("c01", t31245.getC01());
			mapParamRequest.put("c02", t31245.getC02());
			
			mapParamRequest.put("version", t31245.getVersion());
			mapParamRequest.put("banco", t31245.getBanco());
		}
		
		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	
						
		T31245 t31245 = new T31245();
		t31245.setC01((String) mapParamRequest.get("c01"));
		t31245.setC02((String) mapParamRequest.get("c02"));
		
		t31245.setFechaTrans(new Date());
		t31245.setBanco(entidad);
		t31245.setVersion(version);

		logger.debug(t31245.toString());
		
		em.persist(t31245);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
		T31245 t31245 = em.find(T31245.class, new Integer(fila));
		
		t31245.setC01((String) mapParamRequest.get("c01"));
		t31245.setC02((String) mapParamRequest.get("c02"));
		
		t31245.setFechaTrans(new Date());
		t31245.setBanco(entidad);
		t31245.setVersion(version);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T31245 t31245 = em.find(T31245.class, new Integer(fila));
		em.remove(t31245);
	}
}
