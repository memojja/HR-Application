package com.kodgemisi.controller;

import com.kodgemisi.dao.JobDao;
import com.kodgemisi.model.Job;
import com.kodgemisi.model.JobApplicationForm;
import com.kodgemisi.model.JobDTO;
import com.kodgemisi.service.JobApplicationFormService;
import com.kodgemisi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ari on 21.03.2017.
 */
@Controller
public class JobApplicationFormController {

    private final JobApplicationFormService jobApplicationFormService;
    private final JobService jobService;


    @Autowired
    public JobApplicationFormController(JobApplicationFormService jobApplicationFormService, JobService jobService) {
        this.jobApplicationFormService = jobApplicationFormService;
        this.jobService = jobService;
    }

    @RequestMapping(value = "/applicationForm/new",method = RequestMethod.GET)
    public String createForm(@RequestParam(value="id") String id,Model model){

        JobDTO dto =new JobDTO();
        dto.setJobId(id);
        model.addAttribute("jobId",dto.getJobId());
        model.addAttribute("jobApplicationForm",dto);
        return "jobApplicationForm";
    }


    @RequestMapping(value = "/applicationForm",method = RequestMethod.POST)
    public String formHandle(@ModelAttribute("jobApplicationForm") JobDTO dto){
/*
        JobApplicationForm jobApplicationForm = new JobApplicationForm();
        jobApplicationForm.setAdress(dto.getAdress());
        jobApplicationForm.setEmail(dto.getEmail());
        jobApplicationForm.setName(dto.getName());
        jobApplicationForm.setPhoneNumber(dto.getPhoneNumber());
        Long iii =Long.parseLong(dto.getJobId());
        jobApplicationForm.setJob(jobService.findOne(iii));
        jobApplicationFormService.create(jobApplicationForm);

        jobApplicationFormService.assignJobApplicationForm(Long.parseLong(dto.getJobId()),jobApplicationForm.getId());
        */
        jobApplicationFormService.assignJobApplicationForm(dto);


        return "redirect:/jobs";
    }

    @RequestMapping(value = "/applicationForm")
    public ModelAndView getAllApplicationForm(){
        return new ModelAndView("listApplicationForm","jobApplicationForm",jobApplicationFormService.getAll());
    }

    @RequestMapping(value = "/applicationForm/{id}")
    public ModelAndView getFormById(@PathVariable("id") Long id){
        return new ModelAndView("viewApplicationForm","jobApplicationForm",jobApplicationFormService.findOne(id));

    }



}
