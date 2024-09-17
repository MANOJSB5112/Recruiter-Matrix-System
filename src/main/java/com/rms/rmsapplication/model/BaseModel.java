package com.rms.rmsapplication.model;

import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class BaseModel {
    Long id;
    Date createdAt;
    Date lastModifiedAt;

}
