package com.rms.rmsapplication.model;

import jakarta.persistence.*;

import java.util.List;

public class Recruiter extends BaseModel {
    private String name;
    private String phoneNumber;
    private String email;
    private Long empId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Account account;

    @Enumerated(EnumType.STRING)
    private Designation designation;

    @ManyToOne
    private Team team;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recruiter")
    private List<Submission> submissions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recruiter")
    private List<Interview> interviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recruiter")
    private List<JobOffer> jobOffers;
}