/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.com.softproject.sample.spring.mvc.jquery.model;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class KeyValueItem {

    private long key;
    private String value;

    public KeyValueItem() {
    }

    public KeyValueItem(long key, String value) {
        this.key = key;
        this.value = value;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
