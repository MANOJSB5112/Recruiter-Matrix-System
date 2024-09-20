package com.rms.rmsapplication.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class JobOfferDto {
    private String details;
    private Long submissionId;
    private Double payRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
