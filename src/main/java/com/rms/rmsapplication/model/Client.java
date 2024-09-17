package com.rms.rmsapplication.model;

import java.util.List;

public class Client extends BaseModel{
    String name;
    Address address;
    List<Job> jobs;
    List<Submission> submissions;
    List<Interview> interviews;
    List<Offer> offers;
}
