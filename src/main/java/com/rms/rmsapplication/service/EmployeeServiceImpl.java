package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.EmployeeUpdateDto;
import com.rms.rmsapplication.exceptions.EmployeeNotFoundException;
import com.rms.rmsapplication.exceptions.TeamNotFoundException;
import com.rms.rmsapplication.model.Employee;
import com.rms.rmsapplication.model.Team;
import com.rms.rmsapplication.repos.EmployeeRepo;
import com.rms.rmsapplication.repos.TeamRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Primary
@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepo employeeRepo;
    TeamRepo teamRepo;

    EmployeeServiceImpl(EmployeeRepo employeeRepo,TeamRepo teamRepo)
    {
        this.employeeRepo=employeeRepo;
        this.teamRepo=teamRepo;
    }
    @Override
    public boolean newEmployee(String name, String email, String phoneNumber, String designation) {
        Employee employee= Employee.builder().build();
        employee.setName(name);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setDesignation(designation);
        employeeRepo.save(employee);
        return true;
    }

    @Override
    public void updateEmployee(Long id, EmployeeUpdateDto employeeUpdateDto) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found with the id " + id);
        } else {
            Employee employee = employeeOptional.get();
            if (employeeUpdateDto.getName() != null) employee.setName(employeeUpdateDto.getName());
            if (employeeUpdateDto.getEmail() != null) employee.setEmail(employeeUpdateDto.getEmail());
            if (employeeUpdateDto.getDesignation() != null) employee.setDesignation(employeeUpdateDto.getDesignation());
            if (employeeUpdateDto.getPhoneNumber() != null) employee.setPhoneNumber(employeeUpdateDto.getPhoneNumber());
            if (employeeUpdateDto.getManagerId() != null) {
                Optional<Employee> managerOptional = employeeRepo.findById(employeeUpdateDto.getManagerId());
                if (managerOptional.isEmpty()) {
                    throw new EmployeeNotFoundException("Manager not found with the id " + employeeUpdateDto.getManagerId());
                }
                employee.setManager(managerOptional.get());
            }
            if (employeeUpdateDto.getTeamId() != null) {
                Optional<Team> teamOptional = teamRepo.findById(employeeUpdateDto.getTeamId());
                if (teamOptional.isEmpty()) {
                    throw new TeamNotFoundException("Team not found with the id " + employeeUpdateDto.getTeamId());
                }
                employee.setTeam(teamOptional.get());
            }
            employeeRepo.save(employee);
        }
    }

}
