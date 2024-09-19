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