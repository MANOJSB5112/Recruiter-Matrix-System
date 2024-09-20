package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.FeedBackDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface SubmissionService {
    void submissionFeedback(@RequestBody FeedBackDto feedBackDto);
}
