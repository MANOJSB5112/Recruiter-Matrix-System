package com.rms.rmsapplication.model;


import java.util.List;

public class Candidate extends BaseModel {
    String name;
    String email;
    String phoneNumber;
    String currentCompany;
    Long currentSalary;
    List<Submission> submissions;
    List<Interview> interview;
    List<Offer> offer;
    Address address;
}
