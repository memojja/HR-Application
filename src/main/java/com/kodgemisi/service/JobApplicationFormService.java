package com.kodgemisi.service;

import com.kodgemisi.model.Job;
import com.kodgemisi.model.JobApplicationForm;
import com.kodgemisi.model.JobDTO;

import java.util.List;

/**
 * Created by ari on 21.03.2017.
 */
public interface JobApplicationFormService {
    JobApplicationForm create(JobApplicationForm jobApplicationForm);
    List<JobApplicationForm> getAll();
    JobApplicationForm findOne(Long id);
    //void assignJobApplicationForm(Long jobId, Long jobApplicationId);
    void assignJobApplicationForm(JobDTO dto);
}
