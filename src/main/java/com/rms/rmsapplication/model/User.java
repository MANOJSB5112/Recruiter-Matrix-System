package com.rms.rmsapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String hashedPassword;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
