
package com.todoservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TodoListServiceService", targetNamespace = "http://www.todoservices.com", wsdlLocation = "http://127.0.0.1:8091/webservice/todolistservice?WSDL")
public class TodoListServiceService
    extends Service
{

    private final static URL TODOLISTSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException TODOLISTSERVICESERVICE_EXCEPTION;
    private final static QName TODOLISTSERVICESERVICE_QNAME = new QName("http://www.todoservices.com", "TodoListServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:8091/webservice/todolistservice?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TODOLISTSERVICESERVICE_WSDL_LOCATION = url;
        TODOLISTSERVICESERVICE_EXCEPTION = e;
    }

    public TodoListServiceService() {
        super(__getWsdlLocation(), TODOLISTSERVICESERVICE_QNAME);
    }

    public TodoListServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TODOLISTSERVICESERVICE_QNAME, features);
    }

    public TodoListServiceService(URL wsdlLocation) {
        super(wsdlLocation, TODOLISTSERVICESERVICE_QNAME);
    }

    public TodoListServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TODOLISTSERVICESERVICE_QNAME, features);
    }

    public TodoListServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TodoListServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TodoListInterfaceService
     */
    @WebEndpoint(name = "TodoListServicePort")
    public TodoListInterfaceService getTodoListServicePort() {
        return super.getPort(new QName("http://www.todoservices.com", "TodoListServicePort"), TodoListInterfaceService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TodoListInterfaceService
     */
    @WebEndpoint(name = "TodoListServicePort")
    public TodoListInterfaceService getTodoListServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.todoservices.com", "TodoListServicePort"), TodoListInterfaceService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TODOLISTSERVICESERVICE_EXCEPTION!= null) {
            throw TODOLISTSERVICESERVICE_EXCEPTION;
        }
        return TODOLISTSERVICESERVICE_WSDL_LOCATION;
    }

}
