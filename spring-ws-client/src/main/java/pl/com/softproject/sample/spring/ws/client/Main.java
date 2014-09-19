/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.sample.spring.ws.client;

import pl.com.softproject.sample.spring.ws.HelloServiceImplService;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public class Main {

    public static void main(String[] args) {

        HelloServiceImplService service = new HelloServiceImplService();
        
        String res = service.getHelloServiceImplPort().sayHallo("Alicja");

        System.out.println("res -> " + res);
        
    }

}
