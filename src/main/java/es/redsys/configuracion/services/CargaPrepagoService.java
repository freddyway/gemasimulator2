package es.redsys.configuracion.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.redsys.configuracion.model.T31240;

@Stateless
public class CargaPrepagoService {
	private static final Logger logger = LoggerFactory.getLogger(CargaPrepagoService.class);

	@PersistenceContext(unitName = "gemaPU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	
	@SuppressWarnings("unchecked")
	public List<T31240> findAll() {
		List<T31240> list = getEntityManager().createNamedQuery("T31240.findAll").getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> findById(String rowid) {
		Map<String, Object> mapParamRequest = null;

		T31240 t31240 = getEntityManager().find(T31240.class, new Integer(rowid));

		if (t31240 != null) {
			logger.debug("findById {}",t31240.toString());
			
			ObjectMapper oMapper = new ObjectMapper();
			mapParamRequest = oMapper.convertValue(t31240, Map.class);
		}
		
		return mapParamRequest;
	}

	public void save(Map<String, Object> mapParamRequest) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		T31240 t31240 = mapper.convertValue(mapParamRequest, T31240.class);
		
		logger.debug("save {}",t31240.toString());
		
		getEntityManager().persist(t31240);
	}

	public void update(Map<String, Object> mapParamRequest) {

		ObjectMapper mapper = new ObjectMapper();
		T31240 t31240 = mapper.convertValue(mapParamRequest, T31240.class);
		
		logger.debug("upadte {}",t31240.toString());

		getEntityManager().merge(t31240);
	}

	public void delete(String fila) throws Exception {
		T31240 t31240 = getEntityManager().find(T31240.class, new Integer(fila));
		
		logger.debug("delete {}",t31240.toString());
		
		getEntityManager().remove(t31240);
	}
}
