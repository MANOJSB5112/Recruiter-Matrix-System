package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Interview extends BaseModel {
    private String description;

    @ManyToOne
    @JoinColumn(name = "submission_id")
    private Submission submission;

    private LocalDateTime interviewDate;
    private String interviewer;
    private String interviewMode;
    private String feedback;

}