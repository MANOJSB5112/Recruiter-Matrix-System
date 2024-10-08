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
public class Job extends BaseModel {
    private String Title;
    private String description;
    @ManyToOne
    private Company client;
    private Double billRate;
    private String contractDuration;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "job")
    private  List<Submission> submissions;

    private String feedBack;
    Boolean isActive;
}
