package com.kodgemisi.controller;

import com.kodgemisi.model.JobApplicationForm;
import com.kodgemisi.service.JobApplicationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ari on 21.03.2017.
 */
@Controller
@RequestMapping(value = "/applicationForm")
public class JobApplicationFormController {

    private final JobApplicationFormService jobApplicationFormService;


    @Autowired
    public JobApplicationFormController(JobApplicationFormService jobApplicationFormService) {
        this.jobApplicationFormService = jobApplicationFormService;
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public ModelAndView createForm(){
        return new ModelAndView("jobApplicationForm","jobApplicationForm",new JobApplicationForm());
    }


    @RequestMapping(value = "",method = RequestMethod.POST)
    public String formHandle(@ModelAttribute("jobApplicationForm")JobApplicationForm jobApplicationForm){

        jobApplicationFormService.create(jobApplicationForm);

        return "redirect:/applicationForm";
    }


    @RequestMapping(value = "")
    public ModelAndView getAllApplicationForm(){
        return new ModelAndView("listApplicationForm","jobApplicationForms",jobApplicationFormService.getAll());
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView getFormById(@PathVariable("id") Long id){
        return new ModelAndView("viewApplicationForm","jobApplicationForm",jobApplicationFormService.findOne(id));

    }



}
