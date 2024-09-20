package com.rms.rmsapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterviewDto {
    private Long submissionId;
    private Long interviewId;
    private String candidateName;
    private String jobTitle;
    private String clientName;
    private String recruiterName;
    private String feedback;
}
