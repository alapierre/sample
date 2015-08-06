/*
 * Copyright 2015-08-05 the original author or authors.
 */
package pl.com.softproject.sample.oauth.controller;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.com.softproject.sample.oauth.model.Person;
import pl.com.softproject.sample.oauth.service.UserService;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@RestController
@RequestMapping("/rest")
public class MyRestController {

    @Autowired
    private UserService userService;
    
    protected Logger logger = Logger.getLogger(getClass());
    
    @RequestMapping(value = "/person", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person loadPerson() {

        logger.debug("loadPerson");
        
        logger.debug(Arrays.toString(userService.getUserRoles()));
        
        Person person = new Person();
        person.setLastName("Kowalski ąłńćź");
        person.setName("Jan");

        return person;
    }
    
    @RequestMapping(value = "/person", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public Person savePerson(@RequestBody Person person) {
        return person;
    }

}
