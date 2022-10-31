/**
 * GemaOroServicesImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package es.redsys.gestorGemaOro.webservice.cliente;

public class GemaOroServicesImplServiceLocator extends org.apache.axis.client.Service implements es.redsys.gestorGemaOro.webservice.cliente.GemaOroServicesImplService {

	private java.lang.String address = null;

    public GemaOroServicesImplServiceLocator() {
    }


    public GemaOroServicesImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public GemaOroServicesImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for GemaOroServicesImplPort
    

    public java.lang.String getGemaOroServicesImplPortAddress() {
        return address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String GemaOroServicesImplPortWSDDServiceName = "GemaOroServicesImplPort";

    public java.lang.String getGemaOroServicesImplPortWSDDServiceName() {
        return GemaOroServicesImplPortWSDDServiceName;
    }

    public void setGemaOroServicesImplPortWSDDServiceName(java.lang.String name) {
        GemaOroServicesImplPortWSDDServiceName = name;
    }

    public es.redsys.gestorGemaOro.webservice.cliente.GemaOroServices getGemaOroServicesImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(getGemaOroServicesImplPortAddress());
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getGemaOroServicesImplPort(endpoint);
    }

    public es.redsys.gestorGemaOro.webservice.cliente.GemaOroServices getGemaOroServicesImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.redsys.gestorGemaOro.webservice.cliente.GemaOroServicesImplServiceSoapBindingStub _stub = new es.redsys.gestorGemaOro.webservice.cliente.GemaOroServicesImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getGemaOroServicesImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setGemaOroServicesImplPortEndpointAddress(java.lang.String anAddress) {
        address = anAddress;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.redsys.gestorGemaOro.webservice.cliente.GemaOroServices.class.isAssignableFrom(serviceEndpointInterface)) {
                es.redsys.gestorGemaOro.webservice.cliente.GemaOroServicesImplServiceSoapBindingStub _stub = new es.redsys.gestorGemaOro.webservice.cliente.GemaOroServicesImplServiceSoapBindingStub(new java.net.URL(getGemaOroServicesImplPortAddress()), this);
                _stub.setPortName(getGemaOroServicesImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort_(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("GemaOroServicesImplPort".equals(inputPortName)) {
            return getGemaOroServicesImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.services.odin.sermepa.com/", "GemaOroServicesImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.services.odin.sermepa.com/", "GemaOroServicesImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
   	 if ("GemaOroServicesImplPort".equals(portName)) {
            setGemaOroServicesImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
