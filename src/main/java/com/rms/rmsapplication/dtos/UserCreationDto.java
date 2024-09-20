package com.rms.rmsapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationDto {
    private String name;
    private String email;
    private String hashedPassword;
}
