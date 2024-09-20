package com.rms.rmsapplication.controller;

import com.rms.rmsapplication.dtos.FeedBackDto;
import com.rms.rmsapplication.dtos.JobCreationDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @PostMapping("/jobs")
    public void newJob(@RequestBody JobCreationDto jobCreationDto)
    {

    }

    @PostMapping("/interview")
    public void interviewRequest()
    {

    }

    @PostMapping("/jobOffer")
    public void jobOffer()
    {

    }

    @PatchMapping("/submissionFeedback")
    public void submissionFeedback(@RequestBody FeedBackDto feedBackDto)
    {

    }
    @PatchMapping("/interviewFeedback")
    public void interviewFeedback(@RequestBody FeedBackDto feedBackDto)
    {

    }
}
