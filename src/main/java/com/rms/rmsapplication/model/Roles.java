package com.rms.rmsapplication.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Roles extends BaseModel{
    String name;
}
