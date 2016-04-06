/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.sample.spring.ws.client;

import pl.com.softproject.sample.spring.ws.HelloServiceImplService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {

        //HelloServiceImplService service = new HelloServiceImplService();

        //new QName("http://ws.spring.sample.softproject.com.pl/", "HelloServiceImplService")
//http://localhost:8080/services/HelloWorld?wsdl

        //Authenticator.setDefault(new MyAuthenticator());

        HelloServiceImplService service =
                new HelloServiceImplService(new URL("http://localhost:8080/services/HelloWorld?wsdl"),
                new QName("http://ws.spring.sample.softproject.com.pl/", "HelloServiceImplService"));


        String res = service.getHelloServiceImplPort().sayHallo("Alicja");

        System.out.println("res -> " + res);
        
    }

}
