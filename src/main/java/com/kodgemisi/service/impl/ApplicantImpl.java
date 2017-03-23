package com.kodgemisi.service.impl;

import com.kodgemisi.dao.ApplicantDao;
import com.kodgemisi.dao.JobDao;
import com.kodgemisi.model.Job;
import com.kodgemisi.model.Applicant;
import com.kodgemisi.model.ApplicantDTO;
import com.kodgemisi.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ari on 21.03.2017.
 */

@Service
public class ApplicantImpl implements ApplicantService {


    private final ApplicantDao applicantDao;
    private final JobDao jobDao;

    @Autowired
    public ApplicantImpl(ApplicantDao applicantDao, JobDao jobDao) {
        this.applicantDao = applicantDao;
        this.jobDao = jobDao;
    }

    @Override
    public Applicant create(Applicant jobApplicationForm) {
        return applicantDao.save(jobApplicationForm);
    }

    @Override
    public List<Applicant> getAll() {
        return (List) applicantDao.findAll();
    }

    @Override
    public Applicant findOne(Long id) {
        return applicantDao.findOne(id);
    }

    @Override
    public void assignApplicantWithJob(ApplicantDTO dto) {


        Applicant jobApplicationForm = new Applicant();
        jobApplicationForm.setAdress(dto.getAdress());
        jobApplicationForm.setEmail(dto.getEmail());
        jobApplicationForm.setName(dto.getName());
        jobApplicationForm.setPhoneNumber(dto.getPhoneNumber());


        Long jobId =Long.parseLong(dto.getJobId());
        Job job = jobDao.findOne(jobId);

        jobApplicationForm.setJob(job);
        job.getApplicationForms().add(jobApplicationForm);
        applicantDao.save(jobApplicationForm);

    }


}
