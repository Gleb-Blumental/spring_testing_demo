package com.example.spring_testing_demo.controllers;

import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Get all employees
    // GET: /api/employees
    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }


    // Get one employee by id
    // GET: /api/employees
    @GetMapping("/{id}")
    public Optional<Employee> getOneEmployeeById(@PathVariable Long id) {
        return service.getOneEmployeeById(id);
    }


    // Create one user
    // POST: /api/employees
    @PostMapping
    public Employee postEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    // Put one user
    // PUT: /api/employees/{id}
    @PutMapping("/{id}")
    public Employee putEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    // Get: /api/employees
    // DELETE: /api/employees/{id}
    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {

       return service.deleteEmployeeById(id);

    }
}