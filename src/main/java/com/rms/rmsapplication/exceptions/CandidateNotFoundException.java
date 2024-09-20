package com.rms.rmsapplication.exceptions;

public class CandidateNotFoundException extends RuntimeException{

    public CandidateNotFoundException(String message)
    {
        super(message);
    }
}
