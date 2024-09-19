package com.rms.rmsapplication.controller;


import com.rms.rmsapplication.dtos.CreateEmpDto;
import com.rms.rmsapplication.service.AdminService;
import com.rms.rmsapplication.service.AdminServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    AdminService adminService;

    AdminController (AdminServiceImpl adminServiceImpl)
    {
        this.adminService=adminServiceImpl;
    }

    @PostMapping("/employee")
    public ResponseEntity<String> createEmployee(CreateEmpDto createEmpDto)
    {
        String name=createEmpDto.getName();
        String email=createEmpDto.getEmail();
        String phoneNumber=createEmpDto.getPhoneNumber();
        String designation=createEmpDto.getDesignation();
        adminService.createEmployee(name,email,phoneNumber,designation);
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
