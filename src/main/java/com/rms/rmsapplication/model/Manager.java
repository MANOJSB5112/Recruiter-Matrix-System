package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
@Entity
public class Manager extends BaseModel {
    private Long empId;

    @OneToMany(mappedBy = "manager")
    private List<Team> teams;
}