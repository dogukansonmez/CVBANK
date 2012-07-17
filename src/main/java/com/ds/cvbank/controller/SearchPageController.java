package com.ds.cvbank.controller;

/**
 * @author Dogukan Sonmez
 */


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SearchPageController {

    private static Logger logger = Logger.getLogger(SearchPageController.class.getName());

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("requesting home");
        return "home";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String searchCandidate(@RequestParam(value = "searchBox") String searchBox) {
        logger.info("received search " + searchBox);
        return "redirect:/";
    }

}

