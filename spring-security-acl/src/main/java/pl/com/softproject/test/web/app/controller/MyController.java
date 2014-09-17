package pl.com.softproject.test.web.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.com.softproject.test.web.app.model.Event;
import pl.com.softproject.test.web.app.service.EventService;

import javax.validation.Valid;

/**
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 * @author Marcin Jasinski <mkjasinski@gmail.com>
 */
@Controller
public class MyController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {

        logger.debug("MyController.home()");

        return "home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut() {

        logger.debug("MyController.logOut()");

        return "redirect:/j_spring_security_logout";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {

        logger.debug("MyController.admin()");

        return "admin";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {

        logger.debug("MyController.list()");

        model.addAttribute("events", eventService.getAll());

        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {

        logger.debug("MyController.add()");

        model.addAttribute("event", new Event());

        return "add";
    }

    @RequestMapping(value = "/addAction", method = RequestMethod.POST)
    public String addAction(
            @Valid @ModelAttribute(value = "event") Event event,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        logger.debug("MyController.addAction()");

        if (bindingResult.hasErrors()) {
            return "add";
        }

        eventService.add(event);

        redirectAttributes.addFlashAttribute("message", "Event has added");

        return "redirect:/list";
    }

    @RequestMapping(value = "/{eventId}/show", method = RequestMethod.GET)
    public String show(Model model, @PathVariable(value = "eventId") int eventId) {

        logger.debug("MyController.show()");

        Event event = eventService.load(eventId);

        model.addAttribute("event", event);

        return "show";
    }

    @RequestMapping(value = "/{eventId}/edit", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(value = "eventId") int eventId) {

        logger.debug("MyController.edit()");

        Event event = eventService.load(eventId);

        model.addAttribute("event", event);

        return "edit";
    }

    @RequestMapping(value = "/editAction", method = RequestMethod.POST)
    public String editAction(
            @Valid @ModelAttribute(value = "event") Event event,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        logger.debug("MyController.editAction()");

        if (bindingResult.hasErrors()) {
            return "edit";
        }

        eventService.edit(event);

        redirectAttributes.addFlashAttribute("message", "Event has changed");

        return "redirect:/list";
    }

    @RequestMapping(value = "/{eventId}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "eventId") int eventId, RedirectAttributes redirectAttributes) {

        logger.debug("MyController.delete()");

        Event event = eventService.load(eventId);
        eventService.delete(event);

        redirectAttributes.addFlashAttribute("message", "Event has removed");

        return "redirect:/list";
    }
}
