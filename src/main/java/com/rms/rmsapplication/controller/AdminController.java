package com.rms.rmsapplication.controller;


import com.rms.rmsapplication.dtos.EmpCreationDto;
import com.rms.rmsapplication.dtos.EmployeeUpdateDto;
import com.rms.rmsapplication.dtos.UserCreationDto;
import com.rms.rmsapplication.dtos.UserUpdateDto;
import com.rms.rmsapplication.service.EmployeeService;
import com.rms.rmsapplication.service.SystemUserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    EmployeeService employeeService;
    SystemUserServiceImpl systemUserService;

    AdminController (EmployeeService employeeService,SystemUserServiceImpl systemUserService)
    {
        this.employeeService=employeeService;
        this.systemUserService=systemUserService;
    }

    @PostMapping("/employee")
    public ResponseEntity<String> createEmployee( @RequestBody EmpCreationDto empCreationDto)
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
    public ResponseEntity<String> createSystemUser( @RequestBody UserCreationDto userCreationDto)
    {
        try{
            systemUserService.createSystemUser(userCreationDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("System User Created Successfully");
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating System User: " + e.getMessage());
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteSystemUser(@PathVariable Long id)
    {
        try{
            systemUserService.deleteSystemUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("SystemUser deleted successfully");
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error deleting System User: " + e.getMessage());
        }
    }

    @PatchMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody EmployeeUpdateDto employeeUpdateDto)
    {

    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto)
    {

    }



}
