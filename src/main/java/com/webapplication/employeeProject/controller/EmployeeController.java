package com.webapplication.employeeProject.controller;

import java.util.UUID;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapplication.employeeProject.model.Employee;
import com.webapplication.employeeProject.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        Employee tempemployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(tempemployee,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable("id") UUID id){
        Optional<Employee> employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee.get(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") UUID id,@RequestBody Employee employee){
        Employee tempemployee = employeeService.updateEmployee(id,employee);
        return new ResponseEntity<>(tempemployee,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Data Deleted Sucessfully",HttpStatus.NO_CONTENT);
    }
}
