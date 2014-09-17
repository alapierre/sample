/*
 * Copyright 2014-09-17 the original author or authors.
 */

package pl.com.softproject.sample.spring.jms;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Consument {
   
    static Logger logger = Logger.getLogger(Consument.class);
    
    
    public static void main(String[] args) {
    
        ApplicationContext ctx = new ClassPathXmlApplicationContext("consumer-context.xml");
        
    }
    
}
