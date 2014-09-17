/*
 * Copyright 2014-09-17 the original author or authors.
 */

package pl.com.softproject.sample.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class JmsMessageListener implements MessageListener {

    static Logger logger = Logger.getLogger(JmsMessageListener.class);
    
    @Override
    public void onMessage(Message message) {
        
        try {   
            //int messageCount = message.getIntProperty(JmsMessageProducer.MESSAGE_COUNT);
            
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage)message;
                String msg = tm.getText();
                
                logger.info("Processed message " + msg);
            }
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
        
    }
    
}
