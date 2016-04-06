/**
 * Copyright 2016-04-06 the original author or authors.
 */
package pl.com.softproject.sample.velocity;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.log4j.Logger;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import pl.com.softproject.sample.velocity.model.VelocityTemplate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public class VelocityResourceLoader extends ResourceLoader {

    protected Logger logger = Logger.getLogger(getClass());

    private VelocityTemplateDAO velocityTemplateDAO;

    private ApplicationContext applicationContext;

    @Override
    public void init(ExtendedProperties configuration) {

        applicationContext = SpringContextHolder.getApplicationContext();
        velocityTemplateDAO = applicationContext.getBean(VelocityTemplateDAO.class);

        if (logger.isDebugEnabled()) {
            logger.debug("configuration = " + configuration);
            logger.debug(applicationContext);
        }

    }

    @Override
    public InputStream getResourceStream(String templateId) throws ResourceNotFoundException {

        if(logger.isDebugEnabled()) logger.debug("templateId: " + templateId);

        VelocityTemplate template = null;
        try {
            template = velocityTemplateDAO.load(templateId);
        } catch (DataAccessException dataAccessException) {
            throw new ResourceNotFoundException("template not found: " + dataAccessException.getMessage());
        }

        if(template != null && template.getTemplateDefinition() != null) {
            try {
                return new ByteArrayInputStream(template.getTemplateDefinition().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new ResourceNotFoundException("Could not convert template to encoding: UTF-8, exception: " + e.getMessage());
            }
        } else  {
            return null;
        }

    }

    @Override
    public boolean isSourceModified(org.apache.velocity.runtime.resource.Resource resource) {
        if (logger.isDebugEnabled()) {
            logger.debug("resource.getName() = " + resource.getName());
        }
        return resource.getLastModified() != getLastModified(resource);
    }

    @Override
    public long getLastModified(org.apache.velocity.runtime.resource.Resource resource) {
        VelocityTemplate template = velocityTemplateDAO.load(resource.getName());
        return template.getLastModifiedDate().getTime();
    }
}
