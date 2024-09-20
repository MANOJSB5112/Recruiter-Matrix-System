package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.FeedBackDto;
import com.rms.rmsapplication.dtos.SubmissionCreationDto;
import com.rms.rmsapplication.exceptions.CandidateNotFoundException;
import com.rms.rmsapplication.exceptions.JobNotFoundException;
import com.rms.rmsapplication.exceptions.RecruiterNotFoundException;
import com.rms.rmsapplication.exceptions.SubmissionNotFoundException;
import com.rms.rmsapplication.model.Candidate;
import com.rms.rmsapplication.model.Employee;
import com.rms.rmsapplication.model.Job;
import com.rms.rmsapplication.model.Submission;
import com.rms.rmsapplication.repos.CandidateRepo;
import com.rms.rmsapplication.repos.EmployeeRepo;
import com.rms.rmsapplication.repos.JobRepo;
import com.rms.rmsapplication.repos.SubmissionRepo;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepo submissionRepo;
    private final JobRepo jobRepo;
    private final CandidateRepo candidateRepo;
    private  final EmployeeRepo employeeRepo;


    public SubmissionServiceImpl(SubmissionRepo submissionRepo,JobRepo jobRepo,CandidateRepo candidateRepo,
                                   EmployeeRepo employeeRepo) {
        this.submissionRepo = submissionRepo;
        this.jobRepo=jobRepo;
        this.candidateRepo=candidateRepo;
        this.employeeRepo=employeeRepo;
    }

    @Override
    public void newSubmission(SubmissionCreationDto submissionCreationDto) {
        Optional<Job> job=jobRepo.findById(submissionCreationDto.getJobId());
        if(job.isEmpty() || !job.get().getIsActive())
        {
            throw  new JobNotFoundException("Job not found with the id "+submissionCreationDto.getJobId()+" job may be inactive");
        }
        Optional<Employee> recruiter=employeeRepo.findById(submissionCreationDto.getRecruiterId());
        if(recruiter.isEmpty())
        {
            throw new RecruiterNotFoundException("Recruiter not found with the id "+submissionCreationDto.getRecruiterId());
        }
        Optional<Candidate> candidate=candidateRepo.findById(submissionCreationDto.getCandidateId());
        if(candidate.isEmpty())
        {
            throw new CandidateNotFoundException("Candidate with the id "+submissionCreationDto.getCandidateId());
        }
        Submission submission=Submission.builder()
                .description(submissionCreationDto.getDescription())
                .candidate(candidate.get())
                .recruiter(recruiter.get())
                .job(job.get())
                .build();
        submissionRepo.save(submission);
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
