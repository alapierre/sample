/*
 * Copyright 2014-05-27 the original author or authors.
 */

package pl.com.softproject.sample.spring.mvc.jquery.model;

import java.io.Serializable;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class SampleCommand implements Serializable {
    
    private String str;
    private int i;
    
    private int step = 1;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "SampleCommand{" + "str=" + str + ", i=" + i + ", step=" + step + '}';
    }

}
