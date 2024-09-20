package com.rms.rmsapplication.controller;

import com.rms.rmsapplication.dtos.*;
import com.rms.rmsapplication.service.CandidateService;
import com.rms.rmsapplication.service.SearchService;
import com.rms.rmsapplication.service.SubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {
    private final SubmissionService submissionService;
    private final CandidateService candidateService;
    private final SearchService searchService;

    RecruiterController(SubmissionService submissionService,
                        CandidateService candidateService, SearchService searchService)
    {
        this.submissionService=submissionService;
        this.candidateService = candidateService;
        this.searchService = searchService;
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
    public ResponseEntity<List<SubmissionDto>> getAllSubmissionByRecruiter(@PathVariable Long id)
    {
        List<SubmissionDto> submissions=searchService.getAllSubmissionByRecruiter(id);
        return  ResponseEntity.ok(submissions);
    }
    @GetMapping("/interviews/{id}/all")
    public ResponseEntity<List<InterviewDto>> getAllInterviewsByRecruiter(@PathVariable Long id)
    {
        List<InterviewDto> interviews=searchService.getAllInterviewsByReruiter(id);

        return ResponseEntity.ok(interviews);

    }
    @GetMapping("/joboffers/{id}/all")
    public ResponseEntity<List<RecruiterJobOfferDto>> getAllJobOffersByRecruiter(@PathVariable Long id)
    {
        List<RecruiterJobOfferDto> jobOffers=searchService.getAllJobOffersByRecruiter(id);

        return ResponseEntity.ok(jobOffers);

    }

}
