package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Submission extends BaseModel {
    private  String description;

    @ManyToOne
    private Job job;

    @ManyToOne
    private Employee recruiter;

    @ManyToOne
    private Candidate candidate;
}