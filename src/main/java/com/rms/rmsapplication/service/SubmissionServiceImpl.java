package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.FeedBackDto;
import com.rms.rmsapplication.model.Submission;
import com.rms.rmsapplication.repos.SubmissionRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class SubmissionServiceImpl implements SubmissionService{

    SubmissionRepo submissionRepo;

    SubmissionServiceImpl(SubmissionRepo submissionRepo)
    {
        this.submissionRepo=submissionRepo;
    }
    @Override
    public void submissionFeedback(FeedBackDto feedBackDto) {
        Optional<Submission> sub=submissionRepo.findById(feedBackDto.getId());
        if(sub.isPresent())
        {
            Submission submission=sub.get();
            submission.setFeedback(feedBackDto.getFeedback());

        }
    }
}
