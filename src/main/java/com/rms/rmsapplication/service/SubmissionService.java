package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.FeedBackDto;
import com.rms.rmsapplication.dtos.SubmissionCreationDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface SubmissionService {

    void newSubmission(SubmissionCreationDto submissionCreationDto);
    void submissionFeedback(@RequestBody FeedBackDto feedBackDto);

}
