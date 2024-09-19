package com.rms.rmsapplication.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

public class Candidate extends BaseModel {
    private String name;
    private String email;
    private String phoneNumber;
    private String currentCompany;
    private Long currentSalary;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidate")
    private List<Submission> submissions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidate")
    private  List<Interview> interviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidate")
    private List<JobOffer> jobOffers;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;
}


/*
  candidate-jobOffer ---1:M
  1 ->M
   1  <- 1
 */