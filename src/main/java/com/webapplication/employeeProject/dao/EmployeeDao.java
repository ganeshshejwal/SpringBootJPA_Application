package com.webapplication.employeeProject.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.webapplication.employeeProject.model.Employee;

@Component
public interface EmployeeDao extends JpaRepository<Employee,UUID>{
    
}
