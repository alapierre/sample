/**
 * Copyright 2016-04-06 the original author or authors.
 */
package pl.com.softproject.sample.velocity.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@Entity
public class VelocityTemplate {

    @Id
    private String id;

    @Column(columnDefinition="TEXT", name = "template_definition")
    private String templateDefinition;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateDefinition() {
        return templateDefinition;
    }

    public void setTemplateDefinition(String templateDefinition) {
        this.templateDefinition = templateDefinition;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @PrePersist
    private void lastModifiedDateInitialization() {
        lastModifiedDate = new Date();
    }
}
