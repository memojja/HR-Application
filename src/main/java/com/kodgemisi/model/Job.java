package com.kodgemisi.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
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

    @NotEmpty(message = "aaaa")
    @Column(name = "title",nullable = false)
    private String title;
    @NotEmpty(message = "aaaa")
    @Column(name = "description",nullable = false)
    private String description;


    @NotNull(message = "aaa")
    @Min(1)
    @Column(name = "numberOfPeopleToHire",nullable = false)
    private int numberOfPeopleToHire;

    @NotNull(message = "aa")
    @Column(name = "las_application_date")
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private Date lasApplicationDate;

    @OneToMany(mappedBy ="job",cascade = CascadeType.REMOVE)
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return lasApplicationDate;
    }

    public void setLasApplicationDate(Date lasApplicationDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        this.lasApplicationDate = lasApplicationDate;
    }
}
