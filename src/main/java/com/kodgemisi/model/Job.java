package com.kodgemisi.model;

import javax.persistence.*;

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
}
