/*
 * Copyright 2014-09-18 the original author or authors.
 */

package pl.com.softproject.sample.spring.ws;

import javax.jws.WebService;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@WebService(endpointInterface = "pl.com.softproject.sample.spring.ws.HelloService")
public class HelloServiceImpl implements HelloService {
    
    @Override
    public String sayHallo(String name) {
        return "Hello " + name;
    }
    
}
