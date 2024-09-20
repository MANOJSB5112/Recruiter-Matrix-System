package com.rms.rmsapplication.controller;

import com.rms.rmsapplication.dtos.FeedBackDto;
import com.rms.rmsapplication.dtos.InterviewRequestDto;
import com.rms.rmsapplication.dtos.JobCreationDto;
import com.rms.rmsapplication.dtos.JobOfferDto;
import com.rms.rmsapplication.service.InterviewService;
import com.rms.rmsapplication.service.JobOfferService;
import com.rms.rmsapplication.service.JobService;
import com.rms.rmsapplication.service.SubmissionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    JobService jobService;
    InterviewService interviewService;
    SubmissionService submissionService;
    JobOfferService jobOfferService;

    @PostMapping("/jobs")
    public void newJob(@RequestBody JobCreationDto jobCreationDto)
    {
        jobService.newJob(jobCreationDto);
    }

    @PostMapping("/interview")
    public void interviewRequest(InterviewRequestDto interviewRequestDto)
    {
        interviewService.interviewRequest(interviewRequestDto);
    }

    @PostMapping("/jobOffer")
    public void jobOffer(JobOfferDto jobOfferDto)
    {
        jobOfferService.newJobOffer(jobOfferDto);
    }

    @PatchMapping("/submissionFeedback")
    public void submissionFeedback(@RequestBody FeedBackDto feedBackDto)
    {
        submissionService.submissionFeedback(feedBackDto);
    }
    @PatchMapping("/interviewFeedback")
    public void interviewFeedback(@RequestBody FeedBackDto feedBackDto)
    {
        interviewService.interviewFeedback(feedBackDto);
    }
}
