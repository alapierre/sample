/**
 * Copyright 2016-04-06 the original author or authors.
 */
package pl.com.softproject.sample.velocity;

import org.springframework.stereotype.Repository;
import pl.com.softproject.sample.velocity.model.VelocityTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Repository
public class VelocityTemplateDAOImpl implements VelocityTemplateDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    public VelocityTemplate load(String name) {
        return em.find(VelocityTemplate.class, name);
    }

}
