package com.kodgemisi.service;

import com.kodgemisi.model.Job;

import java.util.List;

/**
 * Created by ari on 21.03.2017.
 */
public interface JobService {

    Job create(Job job);
    Job update(Job job);
    Job findOne(Long id);
    List getAll();
    void delete(Long id);
    void deleteAll();
    boolean existsJob(Long id);

}
