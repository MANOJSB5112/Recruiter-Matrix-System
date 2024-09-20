package com.rms.rmsapplication.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface SearchService {
    void getAllSubmissionByRecruiter(@PathVariable Long id);

    void getAllInterviewsByReruiter(@PathVariable Long id);
    void getAllJobOffersByRecruiter(@PathVariable Long id);
}
