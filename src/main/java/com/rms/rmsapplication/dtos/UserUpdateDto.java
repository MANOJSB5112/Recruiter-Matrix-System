package com.rms.rmsapplication.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserUpdateDto {
    private Long empId;
    private String name;
    private String email;
    private String password;
    private List<Long> roleIds;
}
