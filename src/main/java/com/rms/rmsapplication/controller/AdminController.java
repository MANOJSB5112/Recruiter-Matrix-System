package com.rms.rmsapplication.controller;


import com.rms.rmsapplication.dtos.EmpCreationDto;
import com.rms.rmsapplication.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    EmployeeService employeeService;

    AdminController (EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }

    @PostMapping("/employee")
    public ResponseEntity<String> createEmployee(EmpCreationDto empCreationDto)
    {
        String name=empCreationDto.getName();
        String email=empCreationDto.getEmail();
        String phoneNumber=empCreationDto.getPhoneNumber();
        String designation=empCreationDto.getDesignation();
        employeeService.createEmployee(name,email,phoneNumber,designation);
        String message="User Created Successful";
        return ResponseEntity.ok(message);
    }

    @PostMapping("/users")
    public void createUser()
    {

    }

    @DeleteMapping("/employee/{id}")
    public void removeUser()
    {

    }

    @PatchMapping("/employee/{id}")
    public void updateEmployeeDetails()
    {

    }

    @PatchMapping("/users/{id}")
    public void updateUserDetails()
    {

    }



}
