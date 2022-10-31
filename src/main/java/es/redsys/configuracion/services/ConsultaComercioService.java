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

import es.redsys.configuracion.model.T31502;


@Stateless
public class ConsultaComercioService {

	private static final Logger logger =  LoggerFactory.getLogger(ConsultaComercioService.class);

	@PersistenceContext
	private EntityManager em = null;
	
	public ConsultaComercioService() {

	}
	
	@SuppressWarnings("unchecked")	
	public List<T31502> findAll() {
		Query query = em.createNamedQuery("T31502.findAll");				
		List<T31502> list = query.getResultList();
		
		return list;
	}

	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
		T31502 t31502 = em.find(T31502.class, new Integer(rowid));
				
		if(t31502 != null){
			logger.debug(t31502.toString());
			mapParamRequest.put("id", t31502.getId());
			mapParamRequest.put("c01", t31502.getC01());
			mapParamRequest.put("c02", t31502.getC02());
			mapParamRequest.put("c03", t31502.getC03());
			mapParamRequest.put("c04", t31502.getC04());
			mapParamRequest.put("c05", t31502.getC05());
			mapParamRequest.put("c06", t31502.getC06());
			mapParamRequest.put("c07", t31502.getC07());
			mapParamRequest.put("c08", t31502.getC08());
			mapParamRequest.put("c09", t31502.getC09());
			mapParamRequest.put("c10", t31502.getC10());
			mapParamRequest.put("c11", t31502.getC11());
			mapParamRequest.put("c12", t31502.getC12());
			mapParamRequest.put("c13", t31502.getC13());
			mapParamRequest.put("c14", t31502.getC14());
			mapParamRequest.put("c15", t31502.getC15());
			mapParamRequest.put("c16", t31502.getC16());
			mapParamRequest.put("c17", t31502.getC17());
			mapParamRequest.put("c18", t31502.getC18());
			mapParamRequest.put("c19", t31502.getC19());
			mapParamRequest.put("c20", t31502.getC20());
			mapParamRequest.put("c21", t31502.getC21());
			mapParamRequest.put("c22", t31502.getC22());
			mapParamRequest.put("c23", t31502.getC23());
			mapParamRequest.put("c24", t31502.getC24());
			mapParamRequest.put("c25", t31502.getC25());
			mapParamRequest.put("c26", t31502.getC26());
			mapParamRequest.put("c27", t31502.getC27());
			mapParamRequest.put("c28", t31502.getC28());
			mapParamRequest.put("c29", t31502.getC29());
			mapParamRequest.put("c30", t31502.getC30());
			
			mapParamRequest.put("version", t31502.getVersion());
		}

		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest) throws Exception {	

		T31502 t31502 = new T31502();
		t31502.setC01((String) mapParamRequest.get("c01"));
		t31502.setC02((String) mapParamRequest.get("c02"));
		t31502.setC03((String) mapParamRequest.get("c03"));
		t31502.setC04((String) mapParamRequest.get("c04"));
		t31502.setC05((String) mapParamRequest.get("c05"));
		t31502.setC06((String) mapParamRequest.get("c06"));
		t31502.setC07((String) mapParamRequest.get("c07"));
		t31502.setC08((String) mapParamRequest.get("c08"));
		t31502.setC09((String) mapParamRequest.get("c09"));
		t31502.setC10((String) mapParamRequest.get("c10"));
		t31502.setC11((String) mapParamRequest.get("c11"));
		t31502.setC12((String) mapParamRequest.get("c12"));
		t31502.setC13((String) mapParamRequest.get("c13"));
		t31502.setC14((String) mapParamRequest.get("c14"));
		t31502.setC15((String) mapParamRequest.get("c15"));
		t31502.setC16((String) mapParamRequest.get("c16"));
		t31502.setC17((String) mapParamRequest.get("c17"));
		t31502.setC18((String) mapParamRequest.get("c18"));
		t31502.setC19((String) mapParamRequest.get("c19"));
		t31502.setC20((String) mapParamRequest.get("c20"));
		t31502.setC21((String) mapParamRequest.get("c21"));
		t31502.setC22((String) mapParamRequest.get("c22"));
		t31502.setC23((String) mapParamRequest.get("c23"));
		t31502.setC24((String) mapParamRequest.get("c24"));
		t31502.setC25((String) mapParamRequest.get("c25"));
		t31502.setC26((String) mapParamRequest.get("c26"));
		t31502.setC27((String) mapParamRequest.get("c27"));
		t31502.setC28((String) mapParamRequest.get("c28"));
		t31502.setC29((String) mapParamRequest.get("c29"));
		t31502.setC30((String) mapParamRequest.get("c30"));
		
		t31502.setFechaTrans(new Date());
		t31502.setBanco((String) mapParamRequest.get("entidad"));
		t31502.setVersion((String) mapParamRequest.get("version"));
		
		logger.debug(t31502.toString());
		
		em.persist(t31502);			
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T31502 t31502 = em.find(T31502.class, new Integer(fila));
		em.remove(t31502);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest){
    
		String fila = (String) mapParamRequest.get("id");
		T31502 t31502 = em.find(T31502.class, new Integer(fila));
		
		t31502.setC01((String) mapParamRequest.get("c01"));
		t31502.setC02((String) mapParamRequest.get("c02"));
		t31502.setC03((String) mapParamRequest.get("c03"));
		t31502.setC04((String) mapParamRequest.get("c04"));
		t31502.setC05((String) mapParamRequest.get("c05"));
		t31502.setC06((String) mapParamRequest.get("c06"));
		t31502.setC07((String) mapParamRequest.get("c07"));
		t31502.setC08((String) mapParamRequest.get("c08"));
		t31502.setC09((String) mapParamRequest.get("c09"));
		t31502.setC10((String) mapParamRequest.get("c10"));
		t31502.setC11((String) mapParamRequest.get("c11"));
		t31502.setC12((String) mapParamRequest.get("c12"));
		t31502.setC13((String) mapParamRequest.get("c13"));
		t31502.setC14((String) mapParamRequest.get("c14"));
		t31502.setC15((String) mapParamRequest.get("c15"));
		t31502.setC16((String) mapParamRequest.get("c16"));
		t31502.setC17((String) mapParamRequest.get("c17"));
		t31502.setC18((String) mapParamRequest.get("c18"));
		t31502.setC19((String) mapParamRequest.get("c19"));
		t31502.setC20((String) mapParamRequest.get("c20"));
		t31502.setC21((String) mapParamRequest.get("c21"));
		t31502.setC22((String) mapParamRequest.get("c22"));
		t31502.setC23((String) mapParamRequest.get("c23"));
		t31502.setC24((String) mapParamRequest.get("c24"));
		t31502.setC25((String) mapParamRequest.get("c25"));
		t31502.setC26((String) mapParamRequest.get("c26"));
		t31502.setC27((String) mapParamRequest.get("c27"));
		t31502.setC28((String) mapParamRequest.get("c28"));
		t31502.setC29((String) mapParamRequest.get("c29"));
		t31502.setC30((String) mapParamRequest.get("c30"));
	}

	public Map<String, Object> mapper(String[] respuesta) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
		if(respuesta.length > 10){
			mapParamRequest.put("c01", respuesta[9]);
			mapParamRequest.put("c02", respuesta[10]);
			mapParamRequest.put("c03", respuesta[11]);
			mapParamRequest.put("c04", respuesta[12]);
			mapParamRequest.put("c05", respuesta[13]);
			mapParamRequest.put("c06", respuesta[14]);
			mapParamRequest.put("c07", respuesta[15]);
			mapParamRequest.put("c08", respuesta[16]);
			mapParamRequest.put("c09", respuesta[17]);
			mapParamRequest.put("c10", respuesta[18]);
			mapParamRequest.put("c11", respuesta[19]);
			mapParamRequest.put("c12", respuesta[20]);
			mapParamRequest.put("c13", respuesta[21]);
			mapParamRequest.put("c14", respuesta[22]);
			mapParamRequest.put("c15", respuesta[23]);
			mapParamRequest.put("c16", respuesta[24]);
			mapParamRequest.put("c17", respuesta[25]);
			mapParamRequest.put("c18", respuesta[26]);
			mapParamRequest.put("c19", respuesta[27]);
			mapParamRequest.put("c20", respuesta[28]);
			mapParamRequest.put("c21", respuesta[29]);
			mapParamRequest.put("c22", respuesta[30]);
			mapParamRequest.put("c23", respuesta[31]);
			mapParamRequest.put("c24", respuesta[32]);
			mapParamRequest.put("c25", respuesta[33]);
			mapParamRequest.put("c26", respuesta[34]);
			mapParamRequest.put("c27", respuesta[35]);
			mapParamRequest.put("c28", respuesta[36]);
			mapParamRequest.put("c29", respuesta[37]);
			mapParamRequest.put("c30", respuesta[38]);
		} 
		
		return mapParamRequest;
	}


}
