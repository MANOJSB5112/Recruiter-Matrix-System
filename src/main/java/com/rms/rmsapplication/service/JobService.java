package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.JobCreationDto;
import com.rms.rmsapplication.dtos.JobOfferDto;

public interface JobService {
    void newJob(JobCreationDto jobCreationDto);


}
