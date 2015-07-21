package pl.com.softproject.sample.jpa;
/**
 * Copyright 2015-07-21 the original author or authors.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.com.softproject.sample.jpa.dao.HistoryDAO;
import pl.com.softproject.sample.jpa.model.AbstractHistory;
import pl.com.softproject.sample.jpa.model.ChallangeHistory;
import pl.com.softproject.sample.jpa.model.TaskHistory;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring-config.xml"})
public class TestContext {

    @Autowired
    private HistoryDAO historyDAO;

    @Test
    public void test() {
        System.out.println("!!!!");

        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setDescription("ala ma kota");

        historyDAO.save(taskHistory);

        ChallangeHistory challangeHistory = new ChallangeHistory();
        historyDAO.save(challangeHistory);

        Iterable<AbstractHistory> res = historyDAO.findAll();

        for(AbstractHistory item : res) {
            System.out.println(item);
        }

    }

}
