package com.rms.rmsapplication.exceptions;

public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException(String message)
    {
        super(message);
    }
}
