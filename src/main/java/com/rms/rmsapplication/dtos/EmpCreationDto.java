package com.rms.rmsapplication.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpCreationDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String designation;
}
