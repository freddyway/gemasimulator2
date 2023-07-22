package es.redsys.configuracion.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.redsys.configuracion.model.T01026;

@Stateless
public class AmpliarLimiteTarjetaService {
	private static final Logger logger = LoggerFactory.getLogger(AmpliarLimiteTarjetaService.class);

	@PersistenceContext(unitName = "gemaPU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	
	@SuppressWarnings("unchecked")
	public List<T01026> findAll() {
		List<T01026> list = getEntityManager().createNamedQuery("T01026.findAll").getResultList();
		return list;
	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Map<String, Object> findById(String rowid) {
		Map<String, Object> mapParamRequest = null;

		T01026 t01026 = getEntityManager().find(T01026.class, new Integer(rowid));

		if (t01026 != null) {
			logger.debug("findById {}",t01026.toString());
			
			ObjectMapper oMapper = new ObjectMapper();
			mapParamRequest = oMapper.convertValue(t01026, Map.class);

//			T01026 t31661 = oMapper.convertValue(mapParamRequest, T01026.class);
//			logger.debug("MAPPER {}",t31661.toString());
			
//			mapParamRequest.put("id", t01026.getId());
//			mapParamRequest.put("c01", t01026.getC01());
//			mapParamRequest.put("c02", t01026.getC02());
//			mapParamRequest.put("c03", t01026.getC03());
//
//			mapParamRequest.put("version", t01026.getVersion());
//			mapParamRequest.put("entidad", t01026.getBanco());
		}

		return mapParamRequest;
	}

//  @TransactionAttribute(TransactionAttributeType.REQUIRED)
//	public void save(Map<String, Object> mapParamRequest, String entidad, String version) throws Exception {
//		
//		T01026 t01026 = new T01026();
//
//		t01026.setC01((String) mapParamRequest.get("c01"));
//		t01026.setC02((String) mapParamRequest.get("c02"));
//		t01026.setC03((String) mapParamRequest.get("c03"));
//
//		t01026.setFechaTrans(new Date());
//		t01026.setBanco(entidad);
//		t01026.setVersion(version);
//
//		logger.debug("save {}",t01026.toString());
//		
//		getEntityManager().persist(t01026);
//
//	}

	public void save(Map<String, Object> mapParamRequest) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		T01026 t01026 = mapper.convertValue(mapParamRequest, T01026.class);
		
		logger.debug("save {}",t01026.toString());
		
		getEntityManager().persist(t01026);

	}

//  @TransactionAttribute(TransactionAttributeType.REQUIRED)
//	public void update(Map<String, Object> mapParamRequest, String fila, String entidad, String version) {
//		T01026 t01026 = new T01026();
//
//		t01026.setC01((String) mapParamRequest.get("c01"));
//		t01026.setC02((String) mapParamRequest.get("c02"));
//		t01026.setC03((String) mapParamRequest.get("c03"));
//
//		t01026.setFechaTrans(new Date());
//		t01026.setBanco(entidad);
//		t01026.setVersion(version);
//
//		getEntityManager().merge(t01026);
//	}

	public void update(Map<String, Object> mapParamRequest) {

		ObjectMapper mapper = new ObjectMapper();
		T01026 t01026 = mapper.convertValue(mapParamRequest, T01026.class);
		
		logger.debug("upadte {}",t01026.toString());

		getEntityManager().merge(t01026);
	}

//  @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception {
		T01026 t01026 = getEntityManager().find(T01026.class, new Integer(fila));
		
		logger.debug("delete {}",t01026.toString());
		
		getEntityManager().remove(t01026);

	}
}
