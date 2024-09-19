package com.rms.rmsapplication.model;

import jakarta.persistence.*;

import java.util.List;

public class Job extends BaseModel {
    private String description;

    @ManyToOne
    private  Client client;

    private Double billRate;
    private String contractDuration;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "job")
    private  List<Submission> submissions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "job")
    private  List<Interview> interviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "job")
    private  List<JobOffer> jobOffers;
}
