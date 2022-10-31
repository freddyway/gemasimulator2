/**
 * SerClsWSEntradaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.sermepa.odin.clientes.gestorGemaOro.generated;

public class SerClsWSEntradaServiceLocator extends org.apache.axis.client.Service implements com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntradaService {

    public SerClsWSEntradaServiceLocator() {
    }


    public SerClsWSEntradaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SerClsWSEntradaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SerClsWSEntrada
    private java.lang.String SerClsWSEntrada_address = "http://sis-d.sermepa.es:80/gestorGemaOro/services/SerClsWSEntrada";

    public java.lang.String getSerClsWSEntradaAddress() {
        return SerClsWSEntrada_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SerClsWSEntradaWSDDServiceName = "SerClsWSEntrada";

    public java.lang.String getSerClsWSEntradaWSDDServiceName() {
        return SerClsWSEntradaWSDDServiceName;
    }

    public void setSerClsWSEntradaWSDDServiceName(java.lang.String name) {
        SerClsWSEntradaWSDDServiceName = name;
    }

    public com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntrada getSerClsWSEntrada() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SerClsWSEntrada_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSerClsWSEntrada(endpoint);
    }

    public com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntrada getSerClsWSEntrada(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntradaSoapBindingStub _stub = new com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntradaSoapBindingStub(portAddress, this);
            _stub.setPortName(getSerClsWSEntradaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSerClsWSEntradaEndpointAddress(java.lang.String address) {
        SerClsWSEntrada_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntrada.class.isAssignableFrom(serviceEndpointInterface)) {
                com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntradaSoapBindingStub _stub = new com.sermepa.odin.clientes.gestorGemaOro.generated.SerClsWSEntradaSoapBindingStub(new java.net.URL(SerClsWSEntrada_address), this);
                _stub.setPortName(getSerClsWSEntradaWSDDServiceName());
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
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SerClsWSEntrada".equals(inputPortName)) {
            return getSerClsWSEntrada();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servidor.webservice.gestorGemaOro.redsys.es", "SerClsWSEntradaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servidor.webservice.gestorGemaOro.redsys.es", "SerClsWSEntrada"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SerClsWSEntrada".equals(portName)) {
            setSerClsWSEntradaEndpointAddress(address);
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
