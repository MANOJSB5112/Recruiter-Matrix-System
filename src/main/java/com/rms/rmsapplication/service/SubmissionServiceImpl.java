package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.FeedBackDto;
import com.rms.rmsapplication.exceptions.SubmissionNotFoundException;
import com.rms.rmsapplication.model.Submission;
import com.rms.rmsapplication.repos.SubmissionRepo;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepo submissionRepo;


    public SubmissionServiceImpl(SubmissionRepo submissionRepo) {
        this.submissionRepo = submissionRepo;
    }

    @Override
    @Transactional
    public void submissionFeedback(FeedBackDto feedBackDto) {
        Optional<Submission> optionalSubmission = submissionRepo.findById(feedBackDto.getId());

        if (optionalSubmission.isPresent()) {
            Submission submission = optionalSubmission.get();
            submission.setFeedback(feedBackDto.getFeedback());
            submissionRepo.save(submission);
        } else {
            throw new SubmissionNotFoundException("Submission not found with ID: " + feedBackDto.getId());
        }
    }
}
