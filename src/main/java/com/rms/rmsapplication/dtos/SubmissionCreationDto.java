package com.rms.rmsapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmissionCreationDto {
    private String description;
    private Long jobId;
    private Long recruiterId;
    private Long candidateId;
}
