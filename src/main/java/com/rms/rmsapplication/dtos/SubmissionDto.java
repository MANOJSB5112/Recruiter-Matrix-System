package com.rms.rmsapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmissionDto {
    private Long submissionId;
    private String candidateName;
    private String jobTitle;
    private String clientName;
    private String recruiterName;
    private String feedback;
}
