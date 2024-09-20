package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.FeedBackDto;
import com.rms.rmsapplication.dtos.InterviewRequestDto;
import com.rms.rmsapplication.model.Interview;
import com.rms.rmsapplication.model.Submission;
import com.rms.rmsapplication.repos.InterviewRepo;
import com.rms.rmsapplication.repos.SubmissionRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class InterviewServiceImpl implements InterviewService{

    SubmissionRepo submissionRepo;
    InterviewRepo interviewRepo;

    InterviewServiceImpl(SubmissionRepo submissionRepo,InterviewRepo interviewRepo)
    {
        this.submissionRepo=submissionRepo;
        this.interviewRepo=interviewRepo;
    }
    @Override
    public void interviewRequest(InterviewRequestDto interviewRequestDto) {
        Interview interview=new Interview();
        interview.setDescription(interviewRequestDto.getDescription());
        Optional<Submission> sub=submissionRepo.findById(interviewRequestDto.getSubmissionId());
        sub.ifPresent(interview::setSubmission);
        interview.setInterviewer(interviewRequestDto.getInterviewer());
        interview.setInterviewMode(interviewRequestDto.getInterviewMode());
        interview.setInterviewDate(interviewRequestDto.getInterviewDate());

    }

    @Override
    public void interviewFeedback(FeedBackDto feedBackDto) {
        Optional<Interview> interview=interviewRepo.findById(feedBackDto.getId());
        interview.ifPresent(value -> value.setFeedback(feedBackDto.getFeedback()));
    }
}
