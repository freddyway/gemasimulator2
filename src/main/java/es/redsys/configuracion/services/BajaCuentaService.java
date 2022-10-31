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

import es.redsys.configuracion.model.T31500;
import es.redsys.configuracion.model.T31533;

@Stateless
public class BajaCuentaService {
	private static final Logger logger =  LoggerFactory.getLogger(BajaCuentaService.class);

	@PersistenceContext
	private EntityManager em = null;

	@SuppressWarnings("unchecked")
	public List<T31533> findAll() {
		Query query = em.createNamedQuery("T31533.findAll");		
		List<T31533> list = query.getResultList();
		
		return list;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {					
		T31533 t31533 = new T31533();
		t31533.setC01((String) mapParamRequest.get("c01"));
		t31533.setC02((String) mapParamRequest.get("c02"));
		t31533.setC03((String) mapParamRequest.get("c03"));
		t31533.setC04((String) mapParamRequest.get("c04"));
		t31533.setC05((String) mapParamRequest.get("c05"));
				
		t31533.setFechaTrans(new Date());
		t31533.setBanco(entidad);
		t31533.setVersion(version);

		logger.debug(t31533.toString());
		
		em.persist(t31533);		
	}

	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		T31533 t31533 = em.find(T31533.class, new Integer(rowid));
		if(t31533 != null){
			logger.debug(t31533.toString());
			mapParamRequest.put("id",  t31533.getId());
			mapParamRequest.put("c01", t31533.getC01());
			mapParamRequest.put("c02", t31533.getC02());
			mapParamRequest.put("c03", t31533.getC03());
			mapParamRequest.put("c04", t31533.getC04());
			mapParamRequest.put("c05", t31533.getC05());
			mapParamRequest.put("version", t31533.getVersion());
			mapParamRequest.put("entidad", t31533.getBanco());
		}
		
		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
		T31533 t31533 = em.find(T31533.class, new Integer(fila));
		
		t31533.setC01((String) mapParamRequest.get("c01"));
		t31533.setC02((String) mapParamRequest.get("c02"));
		t31533.setC03((String) mapParamRequest.get("c03"));
		t31533.setC04((String) mapParamRequest.get("c04"));
		t31533.setC05((String) mapParamRequest.get("c05"));
		
		t31533.setBanco(entidad);
		t31533.setVersion(version);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T31533 t31533 = em.find(T31533.class, new Integer(fila));
		em.remove(t31533);
	}


}
