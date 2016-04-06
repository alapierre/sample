/**
 * Copyright 2016-04-06 the original author or authors.
 */
package pl.com.softproject.sample.velocity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
@ContextConfiguration("/spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringContextTest {

    @Autowired
    private TemplateService templateService;

    @Test
    public void test() {

        System.out.println("!!!");

        Map<String, Object> params = new HashMap<>();
        params.put("name", "World");

        String content = templateService.mergeTemplate("sample", params);

        System.out.println(content);



    }


}
