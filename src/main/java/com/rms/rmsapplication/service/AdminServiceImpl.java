package com.rms.rmsapplication.service;

import com.rms.rmsapplication.model.Employee;
import com.rms.rmsapplication.repos.EmployeeRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class AdminServiceImpl implements AdminService{
    EmployeeRepo employeeRepo;

    AdminServiceImpl(EmployeeRepo employeeRepo)
    {
        this.employeeRepo=employeeRepo;
    }
    @Override
    public boolean createEmployee(String name, String email, String phoneNumber, String designation) {
        Employee employee= Employee.builder().build();
        employee.setName(name);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setDesignation(designation);
        employeeRepo.save(employee);
        return true;
    }
}
