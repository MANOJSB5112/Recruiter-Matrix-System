package com.rms.rmsapplication.model;

import jakarta.persistence.OneToMany;

import java.util.List;

public class Manager extends BaseModel {
    private Long empId;

    @OneToMany(mappedBy = "manager")
    private List<Team> teams;
}