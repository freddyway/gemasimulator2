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

import es.redsys.configuracion.model.T31500;
import es.redsys.configuracion.services.AltaComercioService;

@Stateless
public class AltaComercioServiceEJB implements AltaComercioService {

	private static final Logger logger =  LoggerFactory.getLogger(AltaComercioServiceEJB.class);

	@PersistenceContext
	private EntityManager em = null;
	
	public AltaComercioServiceEJB() {

	}
	
	@SuppressWarnings("unchecked")	
	public List<T31500> findAll() {
		Query query = em.createNamedQuery("T31500.findAll");				
		List<T31500> list = query.getResultList();
		
		return list;
	}

	public Map<String,Object> findById(String rowid) {
		Map<String,Object> mapParamRequest = new TreeMap<String, Object>();
		
		T31500 t31500 = em.find(T31500.class, new Integer(rowid));
				
		if(t31500 != null){
			logger.debug(t31500.toString());
			mapParamRequest.put("id", t31500.getId());
			mapParamRequest.put("c01", t31500.getC01());
			mapParamRequest.put("c02", t31500.getC02());
			mapParamRequest.put("c03", t31500.getC03());
			mapParamRequest.put("c04", t31500.getC04());
			mapParamRequest.put("c05", t31500.getC05());
			mapParamRequest.put("c06", t31500.getC06());
			mapParamRequest.put("c07", t31500.getC07());
			mapParamRequest.put("c08", t31500.getC08());
			mapParamRequest.put("c09", t31500.getC09());
			mapParamRequest.put("c10", t31500.getC10());
			mapParamRequest.put("c11", t31500.getC11());
			mapParamRequest.put("c12", t31500.getC12());
			mapParamRequest.put("c13", t31500.getC13());
			mapParamRequest.put("c14", t31500.getC14());
			mapParamRequest.put("c15", t31500.getC15());
			mapParamRequest.put("c16", t31500.getC16());
			mapParamRequest.put("c17", t31500.getC17());
			mapParamRequest.put("c18", t31500.getC18());
			mapParamRequest.put("c19", t31500.getC19());
			mapParamRequest.put("c20", t31500.getC20());
			mapParamRequest.put("c21", t31500.getC21());
			mapParamRequest.put("c22", t31500.getC22());
			mapParamRequest.put("c23", t31500.getC23());
			mapParamRequest.put("c24", t31500.getC24());
			mapParamRequest.put("c25", t31500.getC25());
			mapParamRequest.put("c26", t31500.getC26());
			mapParamRequest.put("c27", t31500.getC27());
			mapParamRequest.put("c28", t31500.getC28());
			mapParamRequest.put("c29", t31500.getC29());
			mapParamRequest.put("c30", t31500.getC30());
			mapParamRequest.put("c31", t31500.getC31());
			mapParamRequest.put("c32", t31500.getC32());
			mapParamRequest.put("c33", t31500.getC33());
			mapParamRequest.put("c34", t31500.getC34());
			mapParamRequest.put("c35", t31500.getC35());
			mapParamRequest.put("c36", t31500.getC36());
			mapParamRequest.put("c37", t31500.getC37());
			mapParamRequest.put("c38", t31500.getC38());
			mapParamRequest.put("c39", t31500.getC39());
			mapParamRequest.put("c40", t31500.getC40());
			mapParamRequest.put("c41", t31500.getC41());
			mapParamRequest.put("c42", t31500.getC42());
			mapParamRequest.put("c43", t31500.getC43());
			mapParamRequest.put("c44", t31500.getC44());
			mapParamRequest.put("c45", t31500.getC45());
			mapParamRequest.put("c46", t31500.getC46());
			
			mapParamRequest.put("version", t31500.getVersion());
			mapParamRequest.put("entidad", t31500.getBanco());
		}

		return mapParamRequest;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception {	

		T31500 t31500 = new T31500();
		t31500.setC01((String) mapParamRequest.get("c01"));
		t31500.setC02((String) mapParamRequest.get("c02"));
		t31500.setC03((String) mapParamRequest.get("c03"));
		t31500.setC04((String) mapParamRequest.get("c04"));
		t31500.setC05((String) mapParamRequest.get("c05"));
		t31500.setC06((String) mapParamRequest.get("c06"));
		t31500.setC07((String) mapParamRequest.get("c07"));
		t31500.setC08((String) mapParamRequest.get("c08"));
		t31500.setC09((String) mapParamRequest.get("c09"));
		t31500.setC10((String) mapParamRequest.get("c10"));
		t31500.setC11((String) mapParamRequest.get("c11"));
		t31500.setC12((String) mapParamRequest.get("c12"));
		t31500.setC13((String) mapParamRequest.get("c13"));
		t31500.setC14((String) mapParamRequest.get("c14"));
		t31500.setC15((String) mapParamRequest.get("c15"));
		t31500.setC16((String) mapParamRequest.get("c16"));
		t31500.setC17((String) mapParamRequest.get("c17"));
		t31500.setC18((String) mapParamRequest.get("c18"));
		t31500.setC19((String) mapParamRequest.get("c19"));
		t31500.setC20((String) mapParamRequest.get("c20"));
		t31500.setC21((String) mapParamRequest.get("c21"));
		t31500.setC22((String) mapParamRequest.get("c22"));
		t31500.setC23((String) mapParamRequest.get("c23"));
		t31500.setC24((String) mapParamRequest.get("c24"));
		t31500.setC25((String) mapParamRequest.get("c25"));
		t31500.setC26((String) mapParamRequest.get("c26"));
		t31500.setC27((String) mapParamRequest.get("c27"));
		t31500.setC28((String) mapParamRequest.get("c28"));
		t31500.setC29((String) mapParamRequest.get("c29"));
		t31500.setC30((String) mapParamRequest.get("c30"));
		t31500.setC31((String) mapParamRequest.get("c31"));
		t31500.setC32((String) mapParamRequest.get("c32"));
		t31500.setC33((String) mapParamRequest.get("c33"));
		t31500.setC34((String) mapParamRequest.get("c34"));
		t31500.setC35((String) mapParamRequest.get("c35"));
		t31500.setC36((String) mapParamRequest.get("c36"));
		t31500.setC37((String) mapParamRequest.get("c37"));
		t31500.setC38((String) mapParamRequest.get("c38"));
		t31500.setC39((String) mapParamRequest.get("c39"));
		t31500.setC40((String) mapParamRequest.get("c40"));
		t31500.setC41((String) mapParamRequest.get("c41"));
		t31500.setC42((String) mapParamRequest.get("c42"));
		t31500.setC43((String) mapParamRequest.get("c43"));
		t31500.setC44((String) mapParamRequest.get("c44"));
		t31500.setC45((String) mapParamRequest.get("c45"));
		t31500.setC46((String) mapParamRequest.get("c46"));
		
		t31500.setFechaTrans(new Date());
		t31500.setBanco(entidad);
		t31500.setVersion(version);
		
		logger.debug(t31500.toString());
		
		em.persist(t31500);			
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String fila) throws Exception{
		T31500 t31500 = em.find(T31500.class, new Integer(fila));
		em.remove(t31500);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version){
    
		T31500 t31500 = em.find(T31500.class, new Integer(fila));
		
		t31500.setC01((String) mapParamRequest.get("c01"));
		t31500.setC02((String) mapParamRequest.get("c02"));
		t31500.setC03((String) mapParamRequest.get("c03"));
		t31500.setC04((String) mapParamRequest.get("c04"));
		t31500.setC05((String) mapParamRequest.get("c05"));
		t31500.setC06((String) mapParamRequest.get("c06"));
		t31500.setC07((String) mapParamRequest.get("c07"));
		t31500.setC08((String) mapParamRequest.get("c08"));
		t31500.setC09((String) mapParamRequest.get("c09"));
		t31500.setC10((String) mapParamRequest.get("c10"));
		t31500.setC11((String) mapParamRequest.get("c11"));
		t31500.setC12((String) mapParamRequest.get("c12"));
		t31500.setC13((String) mapParamRequest.get("c13"));
		t31500.setC14((String) mapParamRequest.get("c14"));
		t31500.setC15((String) mapParamRequest.get("c15"));
		t31500.setC16((String) mapParamRequest.get("c16"));
		t31500.setC17((String) mapParamRequest.get("c17"));
		t31500.setC18((String) mapParamRequest.get("c18"));
		t31500.setC19((String) mapParamRequest.get("c19"));
		t31500.setC20((String) mapParamRequest.get("c20"));
		t31500.setC21((String) mapParamRequest.get("c21"));
		t31500.setC22((String) mapParamRequest.get("c22"));
		t31500.setC23((String) mapParamRequest.get("c23"));
		t31500.setC24((String) mapParamRequest.get("c24"));
		t31500.setC25((String) mapParamRequest.get("c25"));
		t31500.setC26((String) mapParamRequest.get("c26"));
		t31500.setC27((String) mapParamRequest.get("c27"));
		t31500.setC28((String) mapParamRequest.get("c28"));
		t31500.setC29((String) mapParamRequest.get("c29"));
		t31500.setC30((String) mapParamRequest.get("c30"));
		t31500.setC31((String) mapParamRequest.get("c31"));
		t31500.setC32((String) mapParamRequest.get("c32"));
		t31500.setC33((String) mapParamRequest.get("c33"));
		t31500.setC34((String) mapParamRequest.get("c34"));
		t31500.setC35((String) mapParamRequest.get("c35"));
		t31500.setC36((String) mapParamRequest.get("c36"));
		t31500.setC37((String) mapParamRequest.get("c37"));
		t31500.setC38((String) mapParamRequest.get("c38"));
		t31500.setC39((String) mapParamRequest.get("c39"));
		t31500.setC40((String) mapParamRequest.get("c40"));
		t31500.setC41((String) mapParamRequest.get("c41"));
		t31500.setC42((String) mapParamRequest.get("c42"));
		t31500.setC43((String) mapParamRequest.get("c43"));
		t31500.setC44((String) mapParamRequest.get("c44"));
		t31500.setC45((String) mapParamRequest.get("c45"));
		t31500.setC46((String) mapParamRequest.get("c46"));
		
		t31500.setBanco(entidad);
		t31500.setVersion(version);
	}


}
