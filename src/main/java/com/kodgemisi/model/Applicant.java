package com.kodgemisi.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by ari on 21.03.2017.
 */
@Entity
@Table(name = "jobApplicationForm")
public class Applicant {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id")
    private Long id;
    @NotEmpty
    @Column(name = "name")
    private String name;
    @NotEmpty
    @Column(name = "email")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    private String email;

    @NotEmpty
    @Column(name = "phoneNumber")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Please provide a valid phone number")
    private String phoneNumber;
    @NotEmpty
    @Column(name = "adress")
    private String adress;


    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }


}
