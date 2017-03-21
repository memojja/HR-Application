package com.kodgemisi.service;

import com.kodgemisi.model.JobApplicationForm;

import java.util.List;

/**
 * Created by ari on 21.03.2017.
 */
public interface JobApplicationFormService {
    JobApplicationForm create(JobApplicationForm jobApplicationForm);
    List<JobApplicationForm> getAll();
    JobApplicationForm findOne(Long id);
}
