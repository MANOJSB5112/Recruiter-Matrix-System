package com.rms.rmsapplication.exceptions;

public class SystemUserNotFoundException extends RuntimeException{

    public SystemUserNotFoundException(String message)
    {
        super(message);
    }
}
