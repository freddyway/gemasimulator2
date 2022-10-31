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

import es.redsys.configuracion.model.T01380;
import es.redsys.configuracion.model.T31530;
import es.redsys.configuracion.model.T31533;

@Stateless
public class ActivarTarjetaEstadoService {
	private static final Logger logger =  LoggerFactory.getLogger(ActivarTarjetaEstadoService.class);
	
	@PersistenceContext
	private EntityManager em = null;
		
	@SuppressWarnings("unchecked")
	public List<T01380> findAll(){
	    
//		em.getTransaction().begin();
		
		Query query = em.createNamedQuery("T01380.findAll");		
		List<T01380> list = query.getResultList();
		
//		em.getTransaction().commit();
		
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
//		em.getTransaction().begin();
		
		T01380 t01380 = em.find(T01380.class, new Integer(rowid));
		
		if(t01380 != null){
			logger.debug(t01380.toString());
			mapParamRequest.put("id",  t01380.getId());
			mapParamRequest.put("c01", t01380.getC01());
			mapParamRequest.put("c02", t01380.getC02());
			
			mapParamRequest.put("version", t01380.getVersion());
		}
		
//		em.getTransaction().commit();
		
		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	
						
		T01380 t01380 = new T01380();
		t01380.setC01((String) mapParamRequest.get("c01"));
		t01380.setC02((String) mapParamRequest.get("c02"));
		
		t01380.setFechaTrans(new Date());
		t01380.setBanco(entidad);
		t01380.setVersion(version);

		logger.debug(t01380.toString());
		
		em.persist(t01380);
	}

//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
//		em.getTransaction().begin();
		
		T01380 t01380 = em.find(T01380.class, new Integer(fila));
		
		t01380.setC01((String) mapParamRequest.get("c01"));
		t01380.setC02((String) mapParamRequest.get("c02"));
		
		t01380.setFechaTrans(new Date());
		t01380.setBanco(entidad);
		t01380.setVersion(version);
		
//		em.getTransaction().commit();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T01380 t01380 = em.find(T01380.class, new Integer(fila));
		em.remove(t01380);
	}
}
