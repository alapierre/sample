package pl.com.softproject.sample.jpa.model;
/**
 * Copyright 2015-07-21 the original author or authors.
 */

import javax.persistence.Entity;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
public class Task extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
