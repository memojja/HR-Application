package com.kodgemisi.controller;

import com.kodgemisi.model.Job;
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

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(value = "/home")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/new")
    public ModelAndView createJob(){
        return new ModelAndView("createJob","job",new Job());
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String createJobHandle(@Valid @ModelAttribute("job") Job job , BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/new";
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
        if(!(jobService.existsJob(id)))
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
