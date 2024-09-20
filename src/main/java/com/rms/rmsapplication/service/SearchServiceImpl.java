package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.InterviewDto;
import com.rms.rmsapplication.dtos.RecruiterJobOfferDto;
import com.rms.rmsapplication.dtos.SubmissionDto;
import com.rms.rmsapplication.model.Interview;
import com.rms.rmsapplication.model.JobOffer;
import com.rms.rmsapplication.model.Submission;
import com.rms.rmsapplication.repos.InterviewRepo;
import com.rms.rmsapplication.repos.JobOfferRepo;
import com.rms.rmsapplication.repos.SubmissionRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class SearchServiceImpl implements SearchService{

    SubmissionRepo submissionRepo;
    InterviewRepo interviewRepo;

    JobOfferRepo jobOfferRepo;

    SearchServiceImpl(SubmissionRepo submissionRepo,InterviewRepo interviewRepo,JobOfferRepo jobOfferRepo)
    {
        this.submissionRepo=submissionRepo;
        this.interviewRepo=interviewRepo;
        this.jobOfferRepo=jobOfferRepo;
    }
    @Override
    public  List<SubmissionDto> getAllSubmissionByRecruiter(Long id) {
        List<Submission> submissions=submissionRepo.findSubmissionByRecruiterId(id);
        return submissions.stream()
                .map(this::convertSubmissionToDto)
                .collect(Collectors.toList());
    }
    private SubmissionDto convertSubmissionToDto(Submission submission) {
        SubmissionDto dto = new SubmissionDto();
        dto.setSubmissionId(submission.getId());
        dto.setFeedback(submission.getFeedback());
        dto.setCandidateName(submission.getCandidate().getName());
        dto.setJobTitle(submission.getJob().getTitle());
        dto.setRecruiterName(submission.getRecruiter().getName());
        return dto;
    }


    @Override
    public List<InterviewDto> getAllInterviewsByReruiter(Long id) {
        List<Interview> interviews=interviewRepo.findInterviewsByRecruiterId(id);
        return interviews.stream()
                .map(this::convertInterviewToDto)
                .collect(Collectors.toList());
    }
    private InterviewDto convertInterviewToDto(Interview interview) {
        InterviewDto dto = new InterviewDto();
        dto.setInterviewId(interview.getId());
        dto.setSubmissionId(interview.getSubmission().getId());
        dto.setFeedback(interview.getFeedback());
        dto.setCandidateName(interview.getSubmission().getCandidate().getName());
        dto.setJobTitle(interview.getSubmission().getJob().getTitle());
        dto.setRecruiterName(interview.getSubmission().getRecruiter().getName());
        return dto;
    }

    @Override
    public List<RecruiterJobOfferDto> getAllJobOffersByRecruiter(Long id) {
        List<JobOffer> jobOffers=jobOfferRepo.findJobOffersByRecruiterId(id);
        return jobOffers.stream()
                .map(this::convertJobOffersToDto)
                .collect(Collectors.toList());

    }
    private RecruiterJobOfferDto convertJobOffersToDto(JobOffer jobOffer) {
        RecruiterJobOfferDto dto = new RecruiterJobOfferDto();
        dto.setJobOfferId(jobOffer.getId());
        dto.setSubmissionId(jobOffer.getSubmission().getId());
        dto.setCandidateName(jobOffer.getSubmission().getCandidate().getName());
        dto.setJobTitle(jobOffer.getSubmission().getJob().getTitle());
        dto.setRecruiterName(jobOffer.getSubmission().getRecruiter().getName());
        dto.setOfferStatus((String.valueOf(jobOffer.getOfferStatus())));
        return dto;
    }
}
