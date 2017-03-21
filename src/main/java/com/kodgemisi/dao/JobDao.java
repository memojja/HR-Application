package com.kodgemisi.dao;

import com.kodgemisi.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ari on 21.03.2017.
 */
@Repository
public interface JobDao extends CrudRepository<Job,Long> {
}
