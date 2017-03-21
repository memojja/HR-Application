package com.kodgemisi.service.impl;

import com.kodgemisi.dao.JobApplicationFormDao;
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

    @Autowired
    public JobApplicationFormImpl(JobApplicationFormDao jobApplicationFormDao) {
        this.jobApplicationFormDao = jobApplicationFormDao;
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

}
