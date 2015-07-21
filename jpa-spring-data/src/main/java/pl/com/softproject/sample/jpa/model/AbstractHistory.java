package pl.com.softproject.sample.jpa.model;
/**
 * Copyright 2015-07-21 the original author or authors.
 */

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */

@Entity
@Table(name = "history")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType= DiscriminatorType.STRING
)
public abstract class AbstractHistory extends BaseEntity {

        private String description;

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}
