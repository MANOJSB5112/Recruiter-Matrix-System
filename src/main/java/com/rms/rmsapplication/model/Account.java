package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
public class Account extends BaseModel {
    private Long empId;
    private String username;
    private String password;
}