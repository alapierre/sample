package pl.com.softproject.test.web.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 * @author Marcin Jasinski <mkjasinski@gmail.com>
 */
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Nazwa nie może być pusta")
    private String name;

    @NotEmpty(message = "Opis nie może być pusty")
    private String description;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
}
