package com.rms.rmsapplication.controller;

import com.rms.rmsapplication.dtos.CandidateCreationDto;
import com.rms.rmsapplication.dtos.SubmissionCreationDto;
import com.rms.rmsapplication.service.CandidateService;
import com.rms.rmsapplication.service.SubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {
    private final SubmissionService submissionService;
    private final CandidateService candidateService;

    RecruiterController(SubmissionService submissionService,
                        CandidateService candidateService)
    {
        this.submissionService=submissionService;
        this.candidateService = candidateService;
    }
    @PostMapping("/submissions")
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
    @PostMapping("/candidate")
    public ResponseEntity<String> newCandidate(CandidateCreationDto candidateCreationDto)
    {
        try{
            candidateService.newCandidate(candidateCreationDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("You have successfully created new Candidate");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating Candidate: " + e.getMessage());
        }
    }

    @GetMapping("/submissions/{id}/all")
    public void getAllSubmissionByRecruiter(@PathVariable Long id)
    {

    }
    @GetMapping("/interviews/{id}/all")
    public void getAllInterviewsByRecruiter(@PathVariable Long id)
    {

    }
    @GetMapping("/joboffers/{id}/all")
    public void getAllJobOffersByRecruiter(@PathVariable Long id)
    {

    }

}
