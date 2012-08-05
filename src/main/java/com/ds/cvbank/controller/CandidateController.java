package com.ds.cvbank.controller;

import com.ds.cvbank.model.Candidate;
import com.ds.cvbank.service.Recruiter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;


/**
 * @author Dogukan Sonmez
 */

@Controller
@RequestMapping("/deposit")
public class CandidateController {

    private static Logger logger = Logger.getLogger(CandidateController.class.getName());

    @Inject
    private Recruiter recruiter;

    @RequestMapping(method = RequestMethod.POST)
    public String addNewCandidate(@ModelAttribute("candidate") Candidate candidate) {
        boolean isSucceed = recruiter.addNewCandidate(candidate);
        if (isSucceed) {
            logger.info("Successfully added new candidate");
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView depositCandidate(@RequestParam(value = "candidate", required = false) Candidate candidate) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("deposit");
        mv.addObject(new Candidate());
        return mv;
    }

}
