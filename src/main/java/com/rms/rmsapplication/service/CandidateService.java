package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.CandidateCreationDto;

public interface CandidateService {
    void newCandidate(CandidateCreationDto candidateCreationDto);
}
