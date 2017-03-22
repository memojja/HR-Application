package com.kodgemisi.service.impl;

import com.kodgemisi.dao.JobApplicationFormDao;
import com.kodgemisi.dao.JobDao;
import com.kodgemisi.model.Job;
import com.kodgemisi.model.JobApplicationForm;
import com.kodgemisi.service.JobApplicationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ari on 21.03.2017.
 */

@Service
public class JobApplicationFormImpl implements JobApplicationFormService {


    private final JobApplicationFormDao jobApplicationFormDao;
    private final JobDao jobDao;

    @Autowired
    public JobApplicationFormImpl(JobApplicationFormDao jobApplicationFormDao, JobDao jobDao) {
        this.jobApplicationFormDao = jobApplicationFormDao;
        this.jobDao = jobDao;
    }

    @Override
    public JobApplicationForm create(JobApplicationForm jobApplicationForm) {
        return jobApplicationFormDao.save(jobApplicationForm);
    }

    @Override
    public List<JobApplicationForm> getAll() {
        return (List)jobApplicationFormDao.findAll();
    }

    @Override
    public JobApplicationForm findOne(Long id) {
        return jobApplicationFormDao.findOne(id);
    }


    @Override
    public void assignJobApplicationForm(Long jobId, Long jobApplicationId) {

        Job job = jobDao.findOne(jobId);
        JobApplicationForm jobApplicationForm = jobApplicationFormDao.findOne(jobApplicationId);

        job.getApplicationForms().add(jobApplicationForm);
        jobApplicationForm.setJob(job);

        jobApplicationFormDao.save(jobApplicationForm);

    }

}
