package com.rms.rmsapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String designation;
    private Long managerId;
    private Long teamId;
    private boolean currentEmployee;
}