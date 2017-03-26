package com.kodgemisi.controller;

import com.kodgemisi.model.Job;
import com.kodgemisi.service.ApplicantService;
import com.kodgemisi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by ari on 21.03.2017.
 */

@Controller
@RequestMapping(value = "/jobs")
public class JobController {

    private final JobService jobService;
    private final ApplicantService applicantService;

    @Autowired
    public JobController(JobService jobService, ApplicantService applicantService) {
        this.jobService = jobService;
        this.applicantService = applicantService;
    }

    @RequestMapping(value = "/new")
    public ModelAndView createJob(){
        return new ModelAndView("jobForm","job",new Job());
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String createJobHandle(@Valid @ModelAttribute("job") Job job , BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "jobForm";
        jobService.create(job);
        return "redirect:/jobs";
    }

    @RequestMapping(value ="" )
    public String getJobs(Model model){
        model.addAttribute("jobs",jobService.getAll());
        return "listJobs";
    }


    @RequestMapping(value = "/{id}")
    public String getJobByid(@PathVariable("id") Long id,Model model ){
        if(!(jobService.exists(id)))
            return "redirect:/jobs";
        model.addAttribute("job",jobService.findOne(id));
        return "viewJob";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteJob(@PathVariable("id") Long id){
        jobService.delete(id);
        return "redirect:/jobs";
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String updateJob(@ModelAttribute Job job){
        jobService.update(job);
        return "redirect:/jobs";
    }








}
