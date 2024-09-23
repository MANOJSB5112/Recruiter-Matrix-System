package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.UserCreationDto;
import com.rms.rmsapplication.dtos.UserUpdateDto;

public interface SystemUserService {
    void createSystemUser(UserCreationDto userCreationDto);
    void deleteSystemUser(Long id);
   void updateSystemUser( Long id, UserUpdateDto userUpdateDto);
}
