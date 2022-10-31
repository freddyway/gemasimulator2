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

import es.redsys.configuracion.model.T32084;
import es.redsys.configuracion.model.T32084;

@Stateless
public class ActivacionServicioDCCService {

	private static final Logger logger =  LoggerFactory.getLogger(ActivacionServicioDCCService.class);

	@PersistenceContext
	private EntityManager em = null;
	
	@SuppressWarnings("unchecked")
	public List<T32084> findAll() {
		Query query = em.createNamedQuery("T32084.findAll");		
		List<T32084> list = query.getResultList();
		
		return list;
	}

	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		T32084 t32084 = em.find(T32084.class, new Integer(rowid));
		
		if(t32084 != null){
			logger.debug(t32084.toString());
			mapParamRequest.put("id",  t32084.getId());
			mapParamRequest.put("c01", t32084.getC01());
			mapParamRequest.put("c02", t32084.getC02());
			mapParamRequest.put("c03", t32084.getC03());
			mapParamRequest.put("c04", t32084.getC04());
			mapParamRequest.put("c05", t32084.getC05());
			mapParamRequest.put("c06", t32084.getC06());
			mapParamRequest.put("c07", t32084.getC07());
			mapParamRequest.put("c08", t32084.getC08());
			mapParamRequest.put("c09", t32084.getC09());
			mapParamRequest.put("entidad", t32084.getBanco());
			mapParamRequest.put("version", t32084.getVersion());
		}
		
		return  mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	
						
		T32084 t32084 = new T32084();
		t32084.setC01((String) mapParamRequest.get("c01"));
		t32084.setC02((String) mapParamRequest.get("c02"));
		t32084.setC03((String) mapParamRequest.get("c03"));
		t32084.setC04((String) mapParamRequest.get("c04"));
		t32084.setC05((String) mapParamRequest.get("c05"));
		t32084.setC06((String) mapParamRequest.get("c06"));
		t32084.setC07((String) mapParamRequest.get("c07"));
		t32084.setC08((String) mapParamRequest.get("c08"));
		t32084.setC09((String) mapParamRequest.get("c09"));
		
		t32084.setFechaTrans(new Date());
		t32084.setBanco(entidad);
		t32084.setVersion(version);
		
		logger.debug(t32084.toString());
		
		em.persist(t32084);		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
		T32084 t32084 = em.find(T32084.class, new Integer(fila));
		
		t32084.setC01((String) mapParamRequest.get("c01"));
		t32084.setC02((String) mapParamRequest.get("c02"));
		t32084.setC03((String) mapParamRequest.get("c03"));
		t32084.setC04((String) mapParamRequest.get("c04"));
		t32084.setC05((String) mapParamRequest.get("c05"));
		t32084.setC06((String) mapParamRequest.get("c06"));
		t32084.setC07((String) mapParamRequest.get("c07"));
		t32084.setC08((String) mapParamRequest.get("c08"));
		t32084.setC09((String) mapParamRequest.get("c09"));
		
		t32084.setFechaTrans(new Date());
		t32084.setBanco(entidad);
		t32084.setVersion(version);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T32084 t32084 = em.find(T32084.class, new Integer(fila));
		em.remove(t32084);
	}
}
