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
import es.redsys.configuracion.model.T31534;

@Stateless
public class MarcarCtaPriorService {
	private static final Logger logger =  LoggerFactory.getLogger(MarcarCtaPriorService.class);

	@PersistenceContext
	private EntityManager em = null;

	@SuppressWarnings("unchecked")
	public List<T31534> findAll() {
		Query query = em.createNamedQuery("T31534.findAll");		
		List<T31534> list = query.getResultList();
		
		return list;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {					
		T31534 t31534 = new T31534();
		t31534.setC01((String) mapParamRequest.get("c01"));
		t31534.setC02((String) mapParamRequest.get("c02"));
		t31534.setC03((String) mapParamRequest.get("c03"));
		t31534.setC04((String) mapParamRequest.get("c04"));
		t31534.setC05((String) mapParamRequest.get("c05"));
				
		t31534.setFechaTrans(new Date());
		t31534.setBanco(entidad);
		t31534.setVersion(version);

		logger.debug(t31534.toString());
		
		em.persist(t31534);		
	}

	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		T31534 t31534 = em.find(T31534.class, new Integer(rowid));
		if(t31534 != null){
			logger.debug(t31534.toString());
			mapParamRequest.put("id",  t31534.getId());
			mapParamRequest.put("c01", t31534.getC01());
			mapParamRequest.put("c02", t31534.getC02());
			mapParamRequest.put("c03", t31534.getC03());
			mapParamRequest.put("c04", t31534.getC04());
			mapParamRequest.put("c05", t31534.getC05());
			mapParamRequest.put("version", t31534.getVersion());
			mapParamRequest.put("entidad", t31534.getBanco());
		}
		
		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
		T31534 t31534 = em.find(T31534.class, new Integer(fila));
		
		t31534.setC01((String) mapParamRequest.get("c01"));
		t31534.setC02((String) mapParamRequest.get("c02"));
		t31534.setC03((String) mapParamRequest.get("c03"));
		t31534.setC04((String) mapParamRequest.get("c04"));
		t31534.setC05((String) mapParamRequest.get("c05"));
				
		t31534.setFechaTrans(new Date());
		t31534.setBanco(entidad);
		t31534.setVersion(version);
		
		em.merge(t31534);

	}

}
