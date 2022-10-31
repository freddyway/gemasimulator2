package com.sermepa.odin.clientes.gestorGemaOro.generated;

public class SerClsWSEntradaProxy implements com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntrada {
  private String _endpoint = null;
  private com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntrada serClsWSEntrada = null;
  
  public SerClsWSEntradaProxy() {
    _initSerClsWSEntradaProxy();
  }
  
  private void _initSerClsWSEntradaProxy() {
    try {
      serClsWSEntrada = (new com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntradaServiceLocator()).getSerClsWSEntrada();
      if (serClsWSEntrada != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serClsWSEntrada)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serClsWSEntrada)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serClsWSEntrada != null)
      ((javax.xml.rpc.Stub)serClsWSEntrada)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntrada getSerClsWSEntrada() {
    if (serClsWSEntrada == null)
      _initSerClsWSEntradaProxy();
    return serClsWSEntrada;
  }
  
  public java.lang.String trataPeticion(java.lang.String datoEntrada) throws java.rmi.RemoteException{
    if (serClsWSEntrada == null)
      _initSerClsWSEntradaProxy();
    return serClsWSEntrada.trataPeticion(datoEntrada);
  }
  
  public java.lang.String trataPeticion(java.lang.String datoEntrada,String user,String passw) throws java.rmi.RemoteException{
	    if (serClsWSEntrada == null)
	      _initSerClsWSEntradaProxy();
	    return serClsWSEntrada.trataPeticion(datoEntrada,user,passw);
	  }
  
}