package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.UserCreationDto;
import com.rms.rmsapplication.exceptions.EmployeeNotFoundException;
import com.rms.rmsapplication.exceptions.SystemUserNotFoundException;
import com.rms.rmsapplication.model.Employee;
import com.rms.rmsapplication.model.Roles;
import com.rms.rmsapplication.model.User;
import com.rms.rmsapplication.repos.EmployeeRepo;
import com.rms.rmsapplication.repos.RolesRepo;
import com.rms.rmsapplication.repos.UserRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SystemUserServiceImpl implements SystemUserService{
    EmployeeRepo employeeRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    RolesRepo rolesRepo;
    UserRepo userRepo;


      SystemUserServiceImpl(EmployeeRepo employeeRepo,BCryptPasswordEncoder bCryptPasswordEncoder,RolesRepo rolesRepo,
                             UserRepo userRepo)
      {
          this.employeeRepo=employeeRepo;
          this.bCryptPasswordEncoder=bCryptPasswordEncoder;
          this.userRepo=userRepo;
      }
    @Override
    public void createSystemUser(UserCreationDto userCreationDto) {
        Optional<Employee> employee=employeeRepo.findById(userCreationDto.getEmpId());
        if(employee.isEmpty())
        {
            throw new EmployeeNotFoundException("Employee not found with the id"+userCreationDto.getEmpId());
        }
        String password= userCreationDto.getPassword();
        List<Roles> roles = rolesRepo.findAllById(userCreationDto.getRoleIds());
        String hashedPassword=bCryptPasswordEncoder.encode(password);
        User user=User.builder()
                .employee(employee.get())
                .name(userCreationDto.getName())
                .email(userCreationDto.getEmail())
                .hashedPassword(hashedPassword)
                .roles(roles)
                .build();
        userRepo.save(user);
    }

    @Override
    public void deleteSystemUser(Long id) {
        Optional<User> u=userRepo.findById(id);
        if(u.isEmpty() || u.get().getIsDeleted())
        {
            throw new SystemUserNotFoundException("System user not found with the id"+id);
        }
        User user=u.get();
        user.setIsDeleted(true);
        userRepo.save(user);
    }
}
