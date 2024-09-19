package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
public class Address extends BaseModel {
    private String street;
    private String city;
    private String zipcode;
    private String country;

    public Address() {

    }
}