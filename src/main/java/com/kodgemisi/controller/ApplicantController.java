package com.kodgemisi.controller;

import com.kodgemisi.model.ApplicantDTO;
import com.kodgemisi.service.ApplicantService;
import com.kodgemisi.service.JobService;
import com.kodgemisi.service.impl.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by ari on 21.03.2017.
 */
@Controller
public class ApplicantController {

    private final ApplicantService applicantService;
    private final JobService jobService;

    @Autowired
    StorageService storageService;

    List<String> files = new ArrayList<String>();


    @Autowired
    public ApplicantController(ApplicantService applicantService, JobService jobService) {
        this.applicantService = applicantService;
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
    public String formHandle(@Valid @ModelAttribute("jobApplicationForm") ApplicantDTO dto, BindingResult bindingResult,
                             @RequestParam("file") MultipartFile file, Model model){
        if(bindingResult.hasErrors())
            return "applicantForm";

        try {
            storageService.store(file);
            model.addAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
            files.add(file.getOriginalFilename());
        } catch (Exception e) {
            model.addAttribute("message", "FAIL to upload " + file.getOriginalFilename() + "!");
        }


        applicantService.assignApplicantWithJob(dto);
        return "redirect:/jobs";
    }

    @RequestMapping(value = "/applicant")
    public ModelAndView getAllApplicationForm(){
        return new ModelAndView("listApplicants","jobApplicationForm", applicantService.getAll());
    }

    @RequestMapping(value = "/applicant/{id}")
    public ModelAndView getFormById(@PathVariable("id") Long id) {
        if (applicantService.findOne(id) == null) {
            throw new NoSuchElementException(String.format("Applicant =%s not found ", id));
        } else {
            return new ModelAndView("viewApplicant", "jobApplicationForm", applicantService.findOne(id));

        }
    }
}
