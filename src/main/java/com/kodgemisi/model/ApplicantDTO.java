package com.kodgemisi.model;

import com.sun.istack.internal.NotNull;
import org.aspectj.weaver.ast.Not;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by ari on 22.03.2017.
 */
public class ApplicantDTO {


    @NotEmpty
    private String jobId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String adress;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
