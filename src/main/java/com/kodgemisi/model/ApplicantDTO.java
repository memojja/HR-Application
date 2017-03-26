package com.kodgemisi.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Created by ari on 22.03.2017.
 */
public class ApplicantDTO {


    @NotEmpty
    private String jobId;
    @NotEmpty
    private String name;
    @NotEmpty
    @Pattern(regexp=".+@.+\\..+",message = "Ornek : memojja1907@gmail.com")
    private String email;

    @NotEmpty
    @Pattern(regexp="(^$|[0-9]{10})",message = "Ornek : 5346233828")
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
