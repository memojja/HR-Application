package com.kodgemisi.service;

import com.kodgemisi.model.Applicant;
import com.kodgemisi.model.ApplicantDTO;

import java.util.List;

/**
 * Created by ari on 21.03.2017.
 */
public interface ApplicantService {
    Applicant create(Applicant jobApplicationForm);
    List<Applicant> getAll();
    Applicant findOne(Long id);
    void assignApplicantWithJob(ApplicantDTO dto);
}
