package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class Interview extends BaseModel {
    private  String description;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private Employee recruiter;

    @ManyToOne
    private  Job job;

    private  LocalDateTime interviewDate;
    private  String interviewer;
    private String feedback;
    public Interview() {

    }
}