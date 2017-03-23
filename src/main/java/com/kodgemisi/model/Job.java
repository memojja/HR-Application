package com.kodgemisi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ari on 21.03.2017.
 */

@Entity
@Table(name = "job")
public class Job {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "numberOfPeopleToHire")
    private int numberOfPeopleToHire;

    //@Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern="dd/MM/yyyy")
    //@Type(type = "date")
    @Column(name = "las_application_date")
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private Date lasApplicationDate;

    @OneToMany(mappedBy ="job",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Applicant> applicationForms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfPeopleToHire() {
        return numberOfPeopleToHire;
    }

    public void setNumberOfPeopleToHire(int numberOfPeopleToHire) {
        this.numberOfPeopleToHire = numberOfPeopleToHire;
    }


    public List<Applicant> getApplicationForms() {
        return applicationForms;
    }

    public void setApplicationForms(List<Applicant> applicationForms) {
        this.applicationForms = applicationForms;
    }

    public Date getLasApplicationDate() {
        return lasApplicationDate;
    }

    public void setLasApplicationDate(Date lasApplicationDate) {
        this.lasApplicationDate = lasApplicationDate;
    }
}
