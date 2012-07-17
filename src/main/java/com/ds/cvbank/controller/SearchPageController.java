package com.ds.cvbank.controller;

/**
 * @author Dogukan Sonmez
 */


import com.ds.cvbank.model.Candidate;
import com.ds.cvbank.model.SearchBox;
import com.ds.cvbank.service.Recruiter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class SearchPageController {

    private static Logger logger = Logger.getLogger(SearchPageController.class.getName());

    @Inject
    private Recruiter recruiter;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(value = "searchBox", required = false) SearchBox searchBox ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject(new SearchBox());
        return mv;
    }



    @RequestMapping(method = RequestMethod.POST)
    public String searchCandidate(@ModelAttribute("searchBox") SearchBox searchBox ) {
        logger.info("received search " + searchBox);
        List<Candidate> candidates = recruiter.searchForCandidates(searchBox);
        return "redirect:/";
    }

}

