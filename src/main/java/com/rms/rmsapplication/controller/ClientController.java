package com.rms.rmsapplication.controller;

import com.rms.rmsapplication.dtos.FeedBackDto;
import com.rms.rmsapplication.dtos.InterviewRequestDto;
import com.rms.rmsapplication.dtos.JobCreationDto;
import com.rms.rmsapplication.dtos.JobOfferDto;
import com.rms.rmsapplication.service.InterviewService;
import com.rms.rmsapplication.service.JobOfferService;
import com.rms.rmsapplication.service.JobService;
import com.rms.rmsapplication.service.SubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final JobService jobService;

    private final InterviewService interviewService;

    private final SubmissionService submissionService;

    private final JobOfferService jobOfferService;

    ClientController(JobService jobService,InterviewService interviewService,SubmissionService submissionService,
                      JobOfferService jobOfferService)
    {
        this.jobService=jobService;
        this.interviewService=interviewService;
        this.submissionService=submissionService;
        this.jobOfferService=jobOfferService;
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> newJob(@RequestBody JobCreationDto jobCreationDto) {
        try {
            jobService.newJob(jobCreationDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Job created successfully.");
        } catch (Exception e) {
            // Log the exception (optional)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating job: " + e.getMessage());
        }
    }

    @PostMapping("/interview")
    public ResponseEntity<String> interviewRequest(@RequestBody InterviewRequestDto interviewRequestDto) {
        try {
            interviewService.interviewRequest(interviewRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Interview request created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating interview request: " + e.getMessage());
        }
    }

    @PostMapping("/jobOffer")
    public ResponseEntity<String> jobOffer(@RequestBody JobOfferDto jobOfferDto) {
        try {
            jobOfferService.newJobOffer(jobOfferDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Job offer created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating job offer: " + e.getMessage());
        }
    }

    @PatchMapping("/submissionFeedback")
    public ResponseEntity<String> submissionFeedback(@RequestBody FeedBackDto feedBackDto) {
        try {
            submissionService.submissionFeedback(feedBackDto);
            return ResponseEntity.ok("Submission feedback processed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing submission feedback: " + e.getMessage());
        }
    }

    @PatchMapping("/interviewFeedback")
    public ResponseEntity<String> interviewFeedback(@RequestBody FeedBackDto feedBackDto) {
        try {
            interviewService.interviewFeedback(feedBackDto);
            return ResponseEntity.ok("Interview feedback processed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing interview feedback: " + e.getMessage());
        }
    }
}

