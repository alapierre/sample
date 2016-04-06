/**
 * Copyright 2016-04-06 the original author or authors.
 */
package pl.com.softproject.sample.velocity;

import java.util.Map;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public interface TemplateService {
    String mergeTemplateFromFile(String templateName, Map<String, Object> map);

    String mergeTemplate(String templateName, Map<String, Object> model);
}
