package com.rms.rmsapplication.model;

import jakarta.persistence.*;
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
    @Enumerated(EnumType.ORDINAL)
    private OfferStatus offerStatus;
}
