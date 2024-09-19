package com.rms.rmsapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseModel {
    private String name;
    private String email;
    private String user_name;
    private String password;
    private String phoneNumber;
    @ManyToMany(fetch = FetchType.LAZY)
    private  List<Roles> roles;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;
    @ManyToOne
    private Team team;

    private boolean currentEmployee;
}