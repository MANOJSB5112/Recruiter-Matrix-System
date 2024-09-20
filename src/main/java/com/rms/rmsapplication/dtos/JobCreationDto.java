package com.rms.rmsapplication.dtos;

import com.rms.rmsapplication.model.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobCreationDto {
    private String Title;
    private String description;
    private Company client;
    private Double billRate;
    private String contractDuration;
    private String street;
    private String city;
    private String zipcode;
    private String country;
}
