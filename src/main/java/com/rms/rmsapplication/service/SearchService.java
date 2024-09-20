package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.InterviewDto;
import com.rms.rmsapplication.dtos.RecruiterJobOfferDto;
import com.rms.rmsapplication.dtos.SubmissionDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SearchService {
    List<SubmissionDto> getAllSubmissionByRecruiter(@PathVariable Long id);

    List<InterviewDto> getAllInterviewsByReruiter(@PathVariable Long id);
    List<RecruiterJobOfferDto> getAllJobOffersByRecruiter(@PathVariable Long id);
}
