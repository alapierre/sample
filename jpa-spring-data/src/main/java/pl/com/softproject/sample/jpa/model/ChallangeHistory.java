package pl.com.softproject.sample.jpa.model;
/**
 * Copyright 2015-07-21 the original author or authors.
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Entity
@DiscriminatorValue(value="CH")
public class ChallangeHistory extends AbstractHistory{

    @ManyToOne
    @JoinColumn(name="challage_id")
    private Challage challage;

    public Challage getChallage() {
        return challage;
    }

    public void setChallage(Challage challage) {
        this.challage = challage;
    }
}
