package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class JobOffer extends BaseModel {
    private  String details;
    @ManyToOne
    private  Candidate candidate;
    @ManyToOne
    private  Employee recruiter;
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