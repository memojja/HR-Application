package com.kodgemisi.controller;

import com.kodgemisi.model.ApplicantDTO;
import com.kodgemisi.service.ApplicantService;
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
public class ApplicantController {

    private final ApplicantService jobApplicationFormService;
    private final JobService jobService;


    @Autowired
    public ApplicantController(ApplicantService jobApplicationFormService, JobService jobService) {
        this.jobApplicationFormService = jobApplicationFormService;
        this.jobService = jobService;
    }

    @RequestMapping(value = "/applicant/new",method = RequestMethod.GET)
    public String createForm(@RequestParam(value="id") String id,Model model){

        ApplicantDTO dto =new ApplicantDTO();
        dto.setJobId(id);
        model.addAttribute("jobId",dto.getJobId());
        model.addAttribute("jobApplicationForm",dto);
        return "applicantForm";
    }


    @RequestMapping(value = "/applicant/new",method = RequestMethod.POST)
    public String formHandle(@ModelAttribute("jobApplicationForm") ApplicantDTO dto){
        jobApplicationFormService.assignApplicantWithJob(dto);
        return "redirect:/jobs";
    }

    @RequestMapping(value = "/applicant")
    public ModelAndView getAllApplicationForm(){
        return new ModelAndView("listApplicants","jobApplicationForm",jobApplicationFormService.getAll());
    }

    @RequestMapping(value = "/applicant/{id}")
    public ModelAndView getFormById(@PathVariable("id") Long id){
        return new ModelAndView("viewApplicant","jobApplicationForm",jobApplicationFormService.findOne(id));

    }



}
