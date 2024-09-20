package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.JobOfferDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class JobOfferServiceImpl implements JobOfferService{

    @Override
    public void newJobOffer(JobOfferDto jobOfferDto) {

    }
}
