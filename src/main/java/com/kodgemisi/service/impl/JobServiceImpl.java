package com.kodgemisi.service.impl;

import com.kodgemisi.dao.JobDao;
import com.kodgemisi.model.Job;
import com.kodgemisi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ari on 21.03.2017.
 */
@Service
public class JobServiceImpl implements JobService {

    private final JobDao jobDao;

    @Autowired
    public JobServiceImpl(JobDao jobDao) {
        this.jobDao = jobDao;
    }


    @Override
    public Job create(Job job) {
        return jobDao.save(job);
    }

    @Override
    public Job update(Job job) {

        Job updatedJob = jobDao.findOne(job.getId());

        updatedJob.setTitle(job.getTitle());
        updatedJob.setDescription(job.getDescription());
        updatedJob.setNumberOfPeopleToHire(job.getNumberOfPeopleToHire());

        return jobDao.save(updatedJob);
    }

    @Override
    public Job findOne(Long id) {
            return jobDao.findOne(id);
    }

    @Override
    public List getAll() {
        return (List) jobDao.findAll();
    }

    @Override
    public void delete(Long id) {
        jobDao.delete(id);
    }

    @Override
    public void deleteAll() {
        jobDao.deleteAll();
    }

    @Override
    public boolean exists(Long id) {
        return jobDao.exists(id);
    }
}
