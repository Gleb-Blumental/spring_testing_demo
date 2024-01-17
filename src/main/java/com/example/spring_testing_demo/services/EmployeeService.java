package com.example.spring_testing_demo.services;


import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.repositories.EmployeeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepositories repositories;

    // Get all employees
    public Iterable<Employee> getAllEmployees(){
        return repositories.findAll();
    }

    // Get one Employee by Id
    public Optional<Employee> getOneEmployeeById(Long id){
        return repositories.findById(id);
    }

    // Create an employee
    public Employee createEmployee(Employee employee){
        return repositories.save(employee);
    }

    // Update an employee
    public Employee updateEmployee(Long id, Employee employee){
        employee.setId(id);
        return repositories.save(employee);
    }

    // Delete employee
    public boolean deleteEmployeeById(Long id){

        if(repositories.existsById(id)) {
            repositories.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Employee> findById(Long id) {
        return repositories.findById(id);
    }


}
