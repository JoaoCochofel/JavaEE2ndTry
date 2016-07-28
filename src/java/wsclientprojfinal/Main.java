/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsclientprojfinal;

import javax.xml.ws.WebServiceRef;
import ws.ProjFinalWs_Service;

/**
 *
 * @author Altran
 */
public class Main {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/WsProjFinal/ProjFinalWs.wsdl")
    private static ProjFinalWs_Service service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    private static String hello(java.lang.String name) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.ProjFinalWs port = service.getProjFinalWsPort();
        return port.hello(name);
    }
    
}
