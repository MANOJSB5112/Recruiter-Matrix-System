package com.rms.rmsapplication.model;

import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class JobOffer extends BaseModel {
    private  String description;

    @ManyToOne
    private  Candidate candidate;

    @ManyToOne
    private  Recruiter recruiter;

    @ManyToOne
    private  Job job;

    private  Double payRate;
    private  LocalDateTime startDate;
    private  LocalDateTime endDate;
}

/*
   JobOffer-Candidate  -M:1
    1 -> 1
     M  <- 1
 */