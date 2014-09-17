/*
 * Copyright 2014-09-17 the original author or authors.
 */

package pl.com.softproject.sample.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Producer {
   
    static Logger logger = Logger.getLogger(Producer.class);
    
    
    public static void main(String[] args) {
    
        final String text = "ala ma kota";
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("producer-context.xml");
        
    
        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
        
        jmsTemplate.send(new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    TextMessage message = session.createTextMessage(text);
                    //message.setIntProperty(MESSAGE_COUNT, index);
                    
                    logger.info("Sending message: " + text);
                    
                    return message;
                }
            });
        
    }
    
}
