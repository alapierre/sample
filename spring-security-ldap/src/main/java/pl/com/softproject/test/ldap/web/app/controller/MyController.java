package pl.com.softproject.test.ldap.web.app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Marcin Jasinski {@literal <mkjasinski@gmail.com>}
 */
@Controller
public class MyController {

    private static final Logger logger = Logger.getLogger(MyController.class);

    @RequestMapping(value = {"/home", "/welcome/**"}, method = RequestMethod.GET)
    public String home() {

        logger.debug("MyController.home()");

        return "/home";
    }

    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    public String secured() {

        logger.debug("MyController.secured()");

        return "/home";
    }
}
