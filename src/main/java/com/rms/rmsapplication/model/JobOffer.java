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
@NoArgsConstructor
@AllArgsConstructor
public class JobOffer extends BaseModel {
    private String details;

    @ManyToOne
    @JoinColumn(name = "submission_id")
    private Submission submission;

    private Double payRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
