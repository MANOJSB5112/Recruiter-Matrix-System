package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.JobOfferDto;
import com.rms.rmsapplication.exceptions.SubmissionNotFoundException;
import com.rms.rmsapplication.model.JobOffer;
import com.rms.rmsapplication.model.OfferStatus;
import com.rms.rmsapplication.model.Submission;
import com.rms.rmsapplication.repos.JobOfferRepo;
import com.rms.rmsapplication.repos.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class JobOfferServiceImpl implements JobOfferService{

    SubmissionRepo submissionRepo;
    JobOfferRepo jobOfferRepo;

    @Autowired
    JobOfferServiceImpl(SubmissionRepo submissionRepo,JobOfferRepo jobOfferRepo)
    {
        this.submissionRepo=submissionRepo;
        this.jobOfferRepo=jobOfferRepo;
    }

    @Override
    public void newJobOffer(JobOfferDto jobOfferDto) {
        Optional<Submission> submission=submissionRepo.findById(jobOfferDto.getSubmissionId());
        if(submission.isPresent())
        {
            JobOffer jobOffer= JobOffer.builder()
                    .details(jobOfferDto.getDetails())
                    .submission(submission.get())
                    .payRate(jobOfferDto.getPayRate())
                    .startDate(jobOfferDto.getStartDate())
                    .endDate(jobOfferDto.getEndDate())
                    .offerStatus(OfferStatus.OFFERED)
                    .build();
            jobOfferRepo.save(jobOffer);
        }else {
            throw new SubmissionNotFoundException("Submission not found with ID: " + jobOfferDto.getSubmissionId());
        }
    }
}
