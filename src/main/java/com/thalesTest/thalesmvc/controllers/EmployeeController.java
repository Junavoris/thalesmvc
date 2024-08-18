package com.thalesTest.thalesmvc.controllers;

import com.thalesTest.thalesmvc.models.AllEmployees;
import com.thalesTest.thalesmvc.models.Employee;
import com.thalesTest.thalesmvc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        employeeService.calculateAnnualSalary(employee);
        return employee;  // Returns Employee object as JSON
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        AllEmployees employees = employeeService.getAllEmployees();
        employeeService.calculateAnnualSalaries(employees.getData());
        return employees.getData();
    }



}
