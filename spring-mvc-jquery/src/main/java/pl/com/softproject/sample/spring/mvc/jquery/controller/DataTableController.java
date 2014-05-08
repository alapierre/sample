/*
 * Copyright 2011-08-31 the original author or authors.
 */

package pl.com.softproject.sample.spring.mvc.jquery.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
public class DataTableController {
    
    @RequestMapping("/loadData")
    public @ResponseBody String loadData(HttpServletRequest request) {
    
        for(Map.Entry<String, String[]> params : request.getParameterMap().entrySet()) {
            System.out.print(params.getKey());
            System.out.println(" -> " + Arrays.toString(params.getValue()));
        }
        
        return "OK";
        
    }
    
}
