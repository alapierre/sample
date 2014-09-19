/*
 * Copyright 2014-09-18 the original author or authors.
 */

package pl.com.softproject.sample.spring.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@WebService
public interface HelloService {

    String sayHallo(@WebParam(name = "name")String name);
    
}
