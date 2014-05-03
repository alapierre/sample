/*
 * Copyright 2011-08-31 the original author or authors.
 */

package pl.com.softproject.sample.spring.mvc.jquery.model;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class DictionaryItem {
    
    private Long id;
    private String name;

    public DictionaryItem() {
    }

    public DictionaryItem(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
