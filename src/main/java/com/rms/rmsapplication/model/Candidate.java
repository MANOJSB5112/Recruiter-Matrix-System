package com.rms.rmsapplication.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class Candidate extends BaseModel {
    private String name;
    private String email;
    private String phoneNumber;
    private String currentCompany;
    private Long currentSalary;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidate")
    private List<Submission> jobApplication;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidate")
    private  List<Interview> jobInterviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "candidate")
    private List<JobOffer> jobOffers;


    public Candidate() {

    }
}


/*
  candidate-jobOffer ---1:M
  1 ->M
   1  <- 1
 */