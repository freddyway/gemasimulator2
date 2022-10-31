package es.redsys.configuracion.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.redsys.configuracion.model.T31660;

@Stateless
public class ActivarTarjetaService {
	private static final Logger logger = LoggerFactory.getLogger(ActivarTarjetaService.class);

	@PersistenceContext(unitName = "gemaPU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	
	@SuppressWarnings("unchecked")
	public List<T31660> findAll() {
		List<T31660> list = getEntityManager().createNamedQuery("T31660.findAll").getResultList();
		return list;
	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Map<String, Object> findById(String rowid) {
		Map<String, Object> mapParamRequest = null;

		T31660 t31660 = getEntityManager().find(T31660.class, new Integer(rowid));

		if (t31660 != null) {
			logger.debug("findById {}",t31660.toString());
			
			ObjectMapper oMapper = new ObjectMapper();
			mapParamRequest = oMapper.convertValue(t31660, Map.class);

//			T31660 t31661 = oMapper.convertValue(mapParamRequest, T31660.class);
//			logger.debug("MAPPER {}",t31661.toString());
			
//			mapParamRequest.put("id", t31660.getId());
//			mapParamRequest.put("c01", t31660.getC01());
//			mapParamRequest.put("c02", t31660.getC02());
//			mapParamRequest.put("c03", t31660.getC03());
//
//			mapParamRequest.put("version", t31660.getVersion());
//			mapParamRequest.put("entidad", t31660.getBanco());
		}

		return mapParamRequest;
	}

//  @TransactionAttribute(TransactionAttributeType.REQUIRED)
//	public void save(Map<String, Object> mapParamRequest, String entidad, String version) throws Exception {
//		
//		T31660 t31660 = new T31660();
//
//		t31660.setC01((String) mapParamRequest.get("c01"));
//		t31660.setC02((String) mapParamRequest.get("c02"));
//		t31660.setC03((String) mapParamRequest.get("c03"));
//
//		t31660.setFechaTrans(new Date());
//		t31660.setBanco(entidad);
//		t31660.setVersion(version);
//
//		logger.debug("save {}",t31660.toString());
//		
//		getEntityManager().persist(t31660);
//
//	}

	public void save(Map<String, Object> mapParamRequest) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		T31660 t31660 = mapper.convertValue(mapParamRequest, T31660.class);
		
		logger.debug("save {}",t31660.toString());
		
		getEntityManager().persist(t31660);

	}

//  @TransactionAttribute(TransactionAttributeType.REQUIRED)
//	public void update(Map<String, Object> mapParamRequest, String fila, String entidad, String version) {
//		T31660 t31660 = new T31660();
//
//		t31660.setC01((String) mapParamRequest.get("c01"));
//		t31660.setC02((String) mapParamRequest.get("c02"));
//		t31660.setC03((String) mapParamRequest.get("c03"));
//
//		t31660.setFechaTrans(new Date());
//		t31660.setBanco(entidad);
//		t31660.setVersion(version);
//
//		getEntityManager().merge(t31660);
//	}

	public void update(Map<String, Object> mapParamRequest) {

		ObjectMapper mapper = new ObjectMapper();
		T31660 t31660 = mapper.convertValue(mapParamRequest, T31660.class);
		
		logger.debug("upadte {}",t31660.toString());

		getEntityManager().merge(t31660);
	}

//  @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception {
		T31660 t31660 = getEntityManager().find(T31660.class, new Integer(fila));
		
		logger.debug("delete {}",t31660.toString());
		
		getEntityManager().remove(t31660);

	}
}
