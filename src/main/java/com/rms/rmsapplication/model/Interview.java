package com.rms.rmsapplication.model;

import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class Interview extends BaseModel {
    private  String description;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private Recruiter recruiter;

    @ManyToOne
    private  Job job;

    private  LocalDateTime interviewDate;  // Handles both date and time
    private  String interviewer;
}