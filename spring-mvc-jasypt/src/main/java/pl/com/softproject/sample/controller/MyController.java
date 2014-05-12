/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.com.softproject.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.security.PasswordEncoder;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
public class MyController {
    
    protected Logger logger = Logger.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/defaultTarget")
    public ModelAndView defaultTarget() {

        logger.debug("MyController.defaultTarget()");

        return createModelAndView("defaultTarget");
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        
        logger.debug("MyController.home()");

        return createModelAndView("home");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {

        logger.debug("MyController.login()");

        return new ModelAndView("login");
    }

    private ModelAndView createModelAndView(String viewName) {

        //Here, we assume that encrypted passwords are fetched from database
        String adminPass = passwordEncoder.decodePassword("isCj1nETCT8apNQdlLOnnA==");
        String userPass = passwordEncoder.decodePassword("CER/7WEG+OIE9zsaKpRHVA==");

        ModelAndView model = new ModelAndView("home");
        model.addObject("adminPass", adminPass);
        model.addObject("userPass", userPass);
        model.setViewName(viewName);

        return model;
    }
}