package es.redsys.configuracion.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.redsys.configuracion.model.T31042;

@Stateless
public class EstadoTarjetaService {
	private static final Logger logger = LoggerFactory.getLogger(EstadoTarjetaService.class);

	@PersistenceContext(unitName = "gemaPU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	
	@SuppressWarnings("unchecked")
	public List<T31042> findAll() {
		List<T31042> list = getEntityManager().createNamedQuery("T31042.findAll").getResultList();
		return list;
	}

	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Map<String, Object> findById(String rowid) {
		Map<String, Object> mapParamRequest = null;

		T31042 t31042 = getEntityManager().find(T31042.class, new Integer(rowid));

		if (t31042 != null) {
			logger.debug("findById {}",t31042.toString());
			
			ObjectMapper oMapper = new ObjectMapper();
			mapParamRequest = oMapper.convertValue(t31042, Map.class);

//			T31042 t31661 = oMapper.convertValue(mapParamRequest, T31042.class);
//			logger.debug("MAPPER {}",t31661.toString());
			
//			mapParamRequest.put("id", t31042.getId());
//			mapParamRequest.put("c01", t31042.getC01());
//			mapParamRequest.put("c02", t31042.getC02());
//			mapParamRequest.put("c03", t31042.getC03());
//
//			mapParamRequest.put("version", t31042.getVersion());
//			mapParamRequest.put("entidad", t31042.getBanco());
		}

		return mapParamRequest;
	}

//  @TransactionAttribute(TransactionAttributeType.REQUIRED)
//	public void save(Map<String, Object> mapParamRequest, String entidad, String version) throws Exception {
//		
//		T31042 t31042 = new T31042();
//
//		t31042.setC01((String) mapParamRequest.get("c01"));
//		t31042.setC02((String) mapParamRequest.get("c02"));
//		t31042.setC03((String) mapParamRequest.get("c03"));
//
//		t31042.setFechaTrans(new Date());
//		t31042.setBanco(entidad);
//		t31042.setVersion(version);
//
//		logger.debug("save {}",t31042.toString());
//		
//		getEntityManager().persist(t31042);
//
//	}

	public void save(Map<String, Object> mapParamRequest) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		T31042 t31042 = mapper.convertValue(mapParamRequest, T31042.class);
		
		logger.debug("save {}",t31042.toString());
		
		getEntityManager().persist(t31042);

	}

//  @TransactionAttribute(TransactionAttributeType.REQUIRED)
//	public void update(Map<String, Object> mapParamRequest, String fila, String entidad, String version) {
//		T31042 t31042 = new T31042();
//
//		t31042.setC01((String) mapParamRequest.get("c01"));
//		t31042.setC02((String) mapParamRequest.get("c02"));
//		t31042.setC03((String) mapParamRequest.get("c03"));
//
//		t31042.setFechaTrans(new Date());
//		t31042.setBanco(entidad);
//		t31042.setVersion(version);
//
//		getEntityManager().merge(t31042);
//	}

	public void update(Map<String, Object> mapParamRequest) {

		ObjectMapper mapper = new ObjectMapper();
		T31042 t31042 = mapper.convertValue(mapParamRequest, T31042.class);
		
		logger.debug("upadte {}",t31042.toString());

		getEntityManager().merge(t31042);
	}

//  @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception {
		T31042 t31042 = getEntityManager().find(T31042.class, new Integer(fila));
		
		logger.debug("delete {}",t31042.toString());
		
		getEntityManager().remove(t31042);

	}
}
