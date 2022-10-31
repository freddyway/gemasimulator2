package es.redsys.configuracion.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import es.redsys.configuracion.model.T31390;

@Local
public interface AltaTarjetaService {
	
	public List<T31390> findAll();
	public Map<String,Object> findById(String rowid);
	public void save(Map<String, Object> mapParamRequest,String entidad,String version) throws Exception;
	public void delete(String fila) throws Exception;
	public void update(Map<String, Object> mapParamRequest,String fila,String entidad,String version);
}
