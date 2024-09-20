package com.rms.rmsapplication.controller;

import com.rms.rmsapplication.dtos.SubmissionCreationDto;
import com.rms.rmsapplication.service.SubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {
    SubmissionService submissionService;
    RecruiterController(SubmissionService submissionService)
    {
        this.submissionService=submissionService;
    }
    @PostMapping("/submission")
    public ResponseEntity<String> newSubmission(SubmissionCreationDto submissionCreationDto)
    {
        try{
            submissionService.newSubmission(submissionCreationDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("You have successfully Submitted Candidate,All the best");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating Submission: " + e.getMessage());
        }
    }
}
