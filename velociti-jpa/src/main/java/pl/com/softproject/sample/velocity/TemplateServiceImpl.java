/**
 * Copyright 2016-04-06 the original author or authors.
 */
package pl.com.softproject.sample.velocity;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.Map;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private VelocityEngine velocityEngine;

    @Value("template/mail/")
    private String templatePath;

    @Override
    public String mergeTemplateFromFile(String templateName, Map<String, Object> model) {

        return VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine,
                templatePath + templateName + ".vm", "UTF8",
                model
        );
    }

    @Override
    public String mergeTemplate(String templateName, Map<String, Object> model) {

        String result = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
                templateName, "UTF8", model);

        return result;

    }
}
