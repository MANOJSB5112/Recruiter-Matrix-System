package com.rms.rmsapplication.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class InterviewRequestDto {
    private String description;
    private Long submissionId;
    private LocalDateTime interviewDate;
    private String interviewer;
    private String interviewMode;
}
