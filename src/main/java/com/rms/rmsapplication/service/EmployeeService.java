package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.EmployeeUpdateDto;

public interface EmployeeService {
   public boolean newEmployee(String name,String email,String phoneNumber, String Designation);
   void updateEmployee( Long id, EmployeeUpdateDto employeeUpdateDto);

}
