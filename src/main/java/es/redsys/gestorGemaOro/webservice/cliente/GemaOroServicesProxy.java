package es.redsys.gestorGemaOro.webservice.cliente;

public class GemaOroServicesProxy {

	private String endpoint = "http://172.16.132.112:9085/odin-services/gemaOroServices";

  private es.redsys.gestorGemaOro.webservice.cliente.GemaOroServices gemaOroServices = null;

  public GemaOroServicesProxy() {
  }

  private void _initGemaOroServicesProxy() {
    try {
   	 GemaOroServicesImplServiceLocator locator = new es.redsys.gestorGemaOro.webservice.cliente.GemaOroServicesImplServiceLocator();
   	 locator.setGemaOroServicesImplPortEndpointAddress(getEndpoint());
      gemaOroServices = locator.getGemaOroServicesImplPort();
      if (gemaOroServices != null) {
        if (endpoint != null)
          ((javax.xml.rpc.Stub)gemaOroServices)._setProperty("javax.xml.rpc.service.endpoint.address", getEndpoint());
        else
      	  endpoint = (String)((javax.xml.rpc.Stub)gemaOroServices)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }

  /** @return URL destino del web service */
  public String getEndpoint() {
    return endpoint;
  }

  /**
   * Fija la URL destino del WS
   * @param anEndpoint URL destino del WS
   */
  public void setEndpoint(final String anEndpoint) {
	  if (anEndpoint != null) {
	  		endpoint = anEndpoint;
	  		if (gemaOroServices != null) {
	  			((javax.xml.rpc.Stub) gemaOroServices).
	  						_setProperty("javax.xml.rpc.service.endpoint.address", getEndpoint());
	  		}
	  }
  }

  public es.redsys.gestorGemaOro.webservice.cliente.GemaOroServices getGemaOroServices() {
    if (gemaOroServices == null) {
      _initGemaOroServicesProxy();
    }
    return gemaOroServices;
  }

}