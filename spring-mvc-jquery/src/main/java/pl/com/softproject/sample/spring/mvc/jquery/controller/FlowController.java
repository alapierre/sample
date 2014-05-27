/*
 * Copyright 2014-05-27 the original author or authors.
 */

package pl.com.softproject.sample.spring.mvc.jquery.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.com.softproject.sample.spring.mvc.jquery.model.SampleCommand;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
@RequestMapping("/wizzard")
@SessionAttributes(value = "command")
public class FlowController {
    
    Logger logger = Logger.getLogger(getClass());
    
    @RequestMapping
    public String firstStep(Model model) {
        
        final SampleCommand sampleCommand = new SampleCommand();
        sampleCommand.setStr("ala ma kota");
        
        model.addAttribute("command", sampleCommand);
        
        logger.debug("step 1");
        
        return "wizzard";
    }
    
    @RequestMapping("/next")
    public String nextStep(Model model, @ModelAttribute("command") SampleCommand command) {
        
        command.setStep(command.getStep() + 1);
        
        logger.debug("next step -> " + command);
        
        return "wizzard"; 
    }
    
    @RequestMapping("/previous")
    private String previousStep(Model model, @ModelAttribute("command") SampleCommand command) {
        
        
        
        command.setStep(command.getStep() - 1);
        
        logger.debug("next step -> " + command);
        
        return "wizzard"; 
    }
    
}
