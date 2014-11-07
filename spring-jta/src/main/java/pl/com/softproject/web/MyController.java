package pl.com.softproject.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.softproject.service.PersonService;

/**
 * Created by admin01 on 04.11.14.
 */
@Controller
public class MyController {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private PersonService personService;

    @RequestMapping("/save")
    public String savePersons() {

        try {
            personService.savePersons();

        } catch (Exception e) {

            logger.error("", e);
            return "fail";
        }
        return "ok";
    }
}
