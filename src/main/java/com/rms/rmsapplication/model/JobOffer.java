package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
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