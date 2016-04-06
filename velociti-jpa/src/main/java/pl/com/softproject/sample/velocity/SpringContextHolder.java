/*
 * Copyright 2011-05-17 the original author or authors.
 */
package pl.com.softproject.sample.velocity;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author <a href="mailto:alapierre@soft-project.pl">Adrian Lapierre</a>
 *
 *
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    protected static Logger logger = Logger.getLogger(ApplicationContextAware.class);
    
    private static ApplicationContext applicationContext = null;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // Assign the ApplicationContext into a static variable
        this.applicationContext = applicationContext;
        logger.info("initializing SpringContextHolder bean");
        
        
    }
}
