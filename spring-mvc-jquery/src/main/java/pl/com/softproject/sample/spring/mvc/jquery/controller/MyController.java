/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.com.softproject.sample.spring.mvc.jquery.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.com.softproject.sample.spring.mvc.jquery.model.DictionaryItem;
import pl.com.softproject.sample.spring.mvc.jquery.model.KeyValueItem;
import pl.com.softproject.sample.spring.mvc.jquery.service.DictionaryService;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
public class MyController {
    
    protected Logger logger = Logger.getLogger(getClass());
    
    @Autowired
    private DictionaryService dictionaryService;
    
    
    @RequestMapping("/home")
    public ModelAndView home() {
        
        logger.debug("MyController.home()");
        
        return new ModelAndView("home");
    }
    
    @RequestMapping("/countries")
    public @ResponseBody List<DictionaryItem> loadDictionary(@RequestParam("term") String query) {
        
        logger.debug("term = " + query);
        
        return dictionaryService.loadByNameFragment(query);
    }
    
    
    @RequestMapping("/test")
    public @ResponseBody List<String> loadDictionary2(@RequestParam("term") String query) {
        
        logger.debug("term = " + query);
        
        List<DictionaryItem> tmp = dictionaryService.loadByNameFragment(query);
        List<String> res = new ArrayList<>();
        
        for(DictionaryItem d : tmp) {
            res.add(d.getName());
        }
        return res;
    }
    
    @RequestMapping("/keyValue")
    public @ResponseBody List<KeyValueItem> loadDictionary3(@RequestParam("term") String query) {
        
        logger.debug("term = " + query);
        
        List<DictionaryItem> tmp = dictionaryService.loadByNameFragment(query);
        List<KeyValueItem> res = new ArrayList<>();
        
        for(DictionaryItem d : tmp) {
            res.add(new KeyValueItem(d.getId(), d.getName()));
        }
        return res;
    }
}
