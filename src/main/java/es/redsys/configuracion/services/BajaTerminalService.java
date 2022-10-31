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

import es.redsys.configuracion.model.T01083;

@Stateless
public class BajaTerminalService {
	private static final Logger logger =  LoggerFactory.getLogger(BajaTerminalService.class);

	@PersistenceContext
	private EntityManager em = null;
	
	@SuppressWarnings("unchecked")
	public List<T01083> findAll() {
		Query query = em.createNamedQuery("T01083.findAll");		
		List<T01083> list = query.getResultList();
		
		return list;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	
		T01083 t01083 = new T01083();
		t01083.setC01((String) mapParamRequest.get("c01"));
		t01083.setC02((String) mapParamRequest.get("c02"));
		t01083.setC03((String) mapParamRequest.get("c03"));
				
		t01083.setFechaTrans(new Date());
		t01083.setBanco(entidad);
		t01083.setVersion(version);

		logger.debug(t01083.toString());
		em.persist(t01083);		
	}
	
	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
				     
		T01083 t01083 = em.find(T01083.class, new Integer(rowid));
				
		if(t01083 != null){
			logger.debug(t01083.toString());
			
			mapParamRequest.put("c01", t01083.getC01());
			mapParamRequest.put("c02", t01083.getC02());
			mapParamRequest.put("c03", t01083.getC03());
			
			mapParamRequest.put("entidad", t01083.getBanco());
			mapParamRequest.put("version", t01083.getVersion());
		}

		return mapParamRequest;
	}


}
