package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.FeedBackDto;
import com.rms.rmsapplication.dtos.InterviewRequestDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface InterviewService {
    void interviewRequest(InterviewRequestDto interviewRequestDto);
    void interviewFeedback(@RequestBody FeedBackDto feedBackDto);
}
