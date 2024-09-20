package com.rms.rmsapplication.service;

import com.rms.rmsapplication.model.Interview;
import com.rms.rmsapplication.model.JobOffer;
import com.rms.rmsapplication.model.Submission;
import com.rms.rmsapplication.repos.InterviewRepo;
import com.rms.rmsapplication.repos.JobOfferRepo;
import com.rms.rmsapplication.repos.SubmissionRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SearchServiceImpl implements SearchService{

    SubmissionRepo submissionRepo;
    InterviewRepo interviewRepo;

    JobOfferRepo jobOfferRepo;

    SearchServiceImpl(SubmissionRepo submissionRepo,InterviewRepo interviewRepo,JobOfferRepo jobOfferRepo)
    {
        this.submissionRepo=submissionRepo;
        this.interviewRepo=interviewRepo;
        this.jobOfferRepo=jobOfferRepo;
    }
    @Override
    public void getAllSubmissionByRecruiter(Long id) {
        List<Submission> submissions=submissionRepo.findSubmissionByRecruiterId(id);

    }

    @Override
    public void getAllInterviewsByReruiter(Long id) {
        List<Interview> interviews=interviewRepo.findInterviewsByRecruiterId(id);

    }

    @Override
    public void getAllJobOffersByRecruiter(Long id) {
        List<JobOffer> jobOffers=jobOfferRepo.findJobOffersByRecruiterId(id);

    }
}
