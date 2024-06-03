package com.webapplication.employeeProject.service;

import java.util.UUID;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapplication.employeeProject.dao.EmployeeDao;
import com.webapplication.employeeProject.model.Employee;

@Component
public class EmployeeService {

    @Autowired 
    EmployeeDao employeeDao;

    public Employee saveEmployee(Employee employee){
        employee.setJoindate(new Timestamp(System.currentTimeMillis()));
        return employeeDao.save(employee);
    }

    public Optional<Employee> getEmployee(UUID id){
        return employeeDao.findById(id);
    }

    public List<Employee> getAllEmployee(){
        return employeeDao.findAll();
    }

    public Employee updateEmployee(UUID id,Employee employee){
        employee.setId(id);
        Optional<Employee> tempEmployee=getEmployee(id);
        employee.setJoindate(tempEmployee.get().getJoindate());
        System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getSalary()+" "+employee.getJoindate());
        return employeeDao.save(employee);
    }

    public void deleteEmployee(UUID id){
        employeeDao.deleteById(id);
    }
}
