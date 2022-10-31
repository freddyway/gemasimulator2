package es.redsys.configuracion.services.ejb;

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

import es.redsys.configuracion.model.T31390;
import es.redsys.configuracion.services.AltaTarjetaService;

@Stateless
public class AltaTarjetaServiceEJB implements AltaTarjetaService {

	private static final Logger logger =  LoggerFactory.getLogger(AltaTarjetaServiceEJB.class);

	@PersistenceContext
	private EntityManager em = null;
	
	public AltaTarjetaServiceEJB() {

	}
	
	@SuppressWarnings("unchecked")	
	public List<T31390> findAll() {
		Query query = em.createNamedQuery("T31390.findAll");				
		List<T31390> list = query.getResultList();
		
		return list;
	}

	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
		T31390 t31390 = em.find(T31390.class, new Integer(rowid));
				
		if(t31390 != null){
			logger.debug(t31390.toString());
			mapParamRequest.put("id", t31390.getId());
			mapParamRequest.put("c01", t31390.getC01());
			mapParamRequest.put("c02", t31390.getC02());
			mapParamRequest.put("c03", t31390.getC03());
			mapParamRequest.put("c04", t31390.getC04());
			mapParamRequest.put("c05", t31390.getC05());
			mapParamRequest.put("c06", t31390.getC06());
			mapParamRequest.put("c07", t31390.getC07());
			mapParamRequest.put("c08", t31390.getC08());
			mapParamRequest.put("c09", t31390.getC09());
			mapParamRequest.put("c10", t31390.getC10());
			mapParamRequest.put("c11", t31390.getC11());
			mapParamRequest.put("c12", t31390.getC12());
			mapParamRequest.put("c13", t31390.getC13());
			mapParamRequest.put("c14", t31390.getC14());
			mapParamRequest.put("c15", t31390.getC15());
			mapParamRequest.put("c16", t31390.getC16());
			mapParamRequest.put("c17", t31390.getC17());
			mapParamRequest.put("c18", t31390.getC18());
			mapParamRequest.put("c19", t31390.getC19());
			mapParamRequest.put("c20", t31390.getC20());
			mapParamRequest.put("c21", t31390.getC21());
			mapParamRequest.put("c22", t31390.getC22());
			mapParamRequest.put("c23", t31390.getC23());
			mapParamRequest.put("c24", t31390.getC24());
			mapParamRequest.put("c25", t31390.getC25());
			mapParamRequest.put("c26", t31390.getC26());
			mapParamRequest.put("c27", t31390.getC27());
			mapParamRequest.put("c28", t31390.getC28());
			mapParamRequest.put("c29", t31390.getC29());
			mapParamRequest.put("c30", t31390.getC30());
			mapParamRequest.put("c31", t31390.getC31());
			mapParamRequest.put("c32", t31390.getC32());
			mapParamRequest.put("c33", t31390.getC33());
			mapParamRequest.put("c34", t31390.getC34());
			mapParamRequest.put("c35", t31390.getC35());
			
			mapParamRequest.put("version", t31390.getVersion());
			mapParamRequest.put("entidad", t31390.getBanco());
		}

		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	

		T31390 t31390 = new T31390();
		t31390.setC01((String) mapParamRequest.get("c01"));
		t31390.setC02((String) mapParamRequest.get("c02"));
		t31390.setC03((String) mapParamRequest.get("c03"));
		t31390.setC04((String) mapParamRequest.get("c04"));
		t31390.setC05((String) mapParamRequest.get("c05"));
		t31390.setC06((String) mapParamRequest.get("c06"));
		t31390.setC07((String) mapParamRequest.get("c07"));
		t31390.setC08((String) mapParamRequest.get("c08"));
		t31390.setC09((String) mapParamRequest.get("c09"));
		t31390.setC10((String) mapParamRequest.get("c10"));
		t31390.setC11((String) mapParamRequest.get("c11"));
		t31390.setC12((String) mapParamRequest.get("c12"));
		t31390.setC13((String) mapParamRequest.get("c13"));
		t31390.setC14((String) mapParamRequest.get("c14"));
		t31390.setC15((String) mapParamRequest.get("c15"));
		t31390.setC16((String) mapParamRequest.get("c16"));
		t31390.setC17((String) mapParamRequest.get("c17"));
		t31390.setC18((String) mapParamRequest.get("c18"));
		t31390.setC19((String) mapParamRequest.get("c19"));
		t31390.setC20((String) mapParamRequest.get("c20"));
		t31390.setC21((String) mapParamRequest.get("c21"));
		t31390.setC22((String) mapParamRequest.get("c22"));
		t31390.setC23((String) mapParamRequest.get("c23"));
		t31390.setC24((String) mapParamRequest.get("c24"));
		t31390.setC25((String) mapParamRequest.get("c25"));
		t31390.setC26((String) mapParamRequest.get("c26"));
		t31390.setC27((String) mapParamRequest.get("c27"));
		t31390.setC28((String) mapParamRequest.get("c28"));
		t31390.setC29((String) mapParamRequest.get("c29"));
		t31390.setC30((String) mapParamRequest.get("c30"));
		t31390.setC31((String) mapParamRequest.get("c31"));
		t31390.setC32((String) mapParamRequest.get("c32"));
		t31390.setC33((String) mapParamRequest.get("c33"));
		t31390.setC34((String) mapParamRequest.get("c34"));
		t31390.setC35((String) mapParamRequest.get("c35"));
		
		t31390.setBanco(entidad);
		t31390.setVersion(version);
		t31390.setFechaTrans(new Date());
		
		logger.debug(t31390.toString());
		
		em.persist(t31390);			
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T31390 t31390 = em.find(T31390.class, new Integer(fila));
		em.remove(t31390);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
		T31390 t31390 = em.find(T31390.class, new Integer(fila));
		
		t31390.setC01((String) mapParamRequest.get("c01"));
		t31390.setC02((String) mapParamRequest.get("c02"));
		t31390.setC03((String) mapParamRequest.get("c03"));
		t31390.setC04((String) mapParamRequest.get("c04"));
		t31390.setC05((String) mapParamRequest.get("c05"));
		t31390.setC06((String) mapParamRequest.get("c06"));
		t31390.setC07((String) mapParamRequest.get("c07"));
		t31390.setC08((String) mapParamRequest.get("c08"));
		t31390.setC09((String) mapParamRequest.get("c09"));
		t31390.setC10((String) mapParamRequest.get("c10"));
		t31390.setC11((String) mapParamRequest.get("c11"));
		t31390.setC12((String) mapParamRequest.get("c12"));
		t31390.setC13((String) mapParamRequest.get("c13"));
		t31390.setC14((String) mapParamRequest.get("c14"));
		t31390.setC15((String) mapParamRequest.get("c15"));
		t31390.setC16((String) mapParamRequest.get("c16"));
		t31390.setC17((String) mapParamRequest.get("c17"));
		t31390.setC18((String) mapParamRequest.get("c18"));
		t31390.setC19((String) mapParamRequest.get("c19"));
		t31390.setC20((String) mapParamRequest.get("c20"));
		t31390.setC21((String) mapParamRequest.get("c21"));
		t31390.setC22((String) mapParamRequest.get("c22"));
		t31390.setC23((String) mapParamRequest.get("c23"));
		t31390.setC24((String) mapParamRequest.get("c24"));
		t31390.setC25((String) mapParamRequest.get("c25"));
		t31390.setC26((String) mapParamRequest.get("c26"));
		t31390.setC27((String) mapParamRequest.get("c27"));
		t31390.setC28((String) mapParamRequest.get("c28"));
		t31390.setC29((String) mapParamRequest.get("c29"));
		t31390.setC30((String) mapParamRequest.get("c30"));
		t31390.setC31((String) mapParamRequest.get("c31"));
		t31390.setC32((String) mapParamRequest.get("c32"));
		t31390.setC33((String) mapParamRequest.get("c33"));
		t31390.setC34((String) mapParamRequest.get("c34"));
		t31390.setC35((String) mapParamRequest.get("c35"));
		
		t31390.setBanco(entidad);
		t31390.setVersion(version);
		t31390.setFechaTrans(new Date());
	}


}
