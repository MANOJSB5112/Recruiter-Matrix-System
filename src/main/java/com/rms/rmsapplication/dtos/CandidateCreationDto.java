package com.rms.rmsapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateCreationDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String currentCompany;
    private Long currentSalary;
    private String street;
    private String city;
    private String zipcode;
    private String country;
}
