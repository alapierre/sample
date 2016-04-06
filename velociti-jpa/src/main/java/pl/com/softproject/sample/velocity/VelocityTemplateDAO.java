/**
 * Copyright 2016-04-06 the original author or authors.
 */
package pl.com.softproject.sample.velocity;

import pl.com.softproject.sample.velocity.model.VelocityTemplate;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
public interface VelocityTemplateDAO {
    VelocityTemplate load(String name);
}
