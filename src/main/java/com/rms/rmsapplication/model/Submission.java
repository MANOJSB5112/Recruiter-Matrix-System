package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class Submission extends BaseModel {
    private  String description;

    @ManyToOne
    private Job job;

    @ManyToOne
    private Recruiter recruiter;

    @ManyToOne
    private Candidate candidate;
}