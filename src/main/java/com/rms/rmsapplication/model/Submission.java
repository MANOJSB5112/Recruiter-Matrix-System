package com.rms.rmsapplication.model;

import jakarta.persistence.ManyToOne;

public class Submission extends BaseModel {
    private  String description;

    @ManyToOne
    private Job job;

    @ManyToOne
    private Recruiter recruiter;

    @ManyToOne
    private Candidate candidate;
}