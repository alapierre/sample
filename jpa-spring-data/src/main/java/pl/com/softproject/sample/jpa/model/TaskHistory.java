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
@DiscriminatorValue(value="TH")
public class TaskHistory extends AbstractHistory{

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
