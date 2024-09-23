package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.UserCreationDto;

public interface SystemUserService {
    void createSystemUser(UserCreationDto userCreationDto);
    void deleteSystemUser(Long id);
}
