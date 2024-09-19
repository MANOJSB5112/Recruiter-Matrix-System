package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseModel {
    private String name;
    private String email;
    private String phoneNumber;
    private String designation;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;
    @ManyToOne
    private Team team;
    private boolean currentEmployee;
}