package com.rms.rmsapplication.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
public class Recruiter extends BaseModel {
    private String name;
    private String phoneNumber;
    private String email;
    private Long empId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Account account;

    @Enumerated(EnumType.ORDINAL)
    private Designation designation;

    @ManyToOne
    private Team team;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recruiter")
    private List<Submission> submissions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recruiter")
    private List<Interview> interviews;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "recruiter")
    private List<JobOffer> jobOffers;
}