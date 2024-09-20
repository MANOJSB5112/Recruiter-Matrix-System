package com.rms.rmsapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruiterJobOfferDto {
    private Long submissionId;
    private Long jobOfferId;
    private String candidateName;
    private String jobTitle;
    private String clientName;
    private String recruiterName;
    private String offerStatus;
}
