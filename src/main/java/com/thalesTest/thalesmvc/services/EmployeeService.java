package com.thalesTest.thalesmvc.services;

import com.thalesTest.thalesmvc.models.AllEmployees;
import com.thalesTest.thalesmvc.models.Employee;
import com.thalesTest.thalesmvc.models.EmployeeById;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final RestTemplate restTemplate;

    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Employee getEmployeeById(int id) {
        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;
        EmployeeById response = restTemplate.getForObject(url, EmployeeById.class);

        if (response != null && "success".equals(response.getStatus())) {
            return response.getData();
        } else {
            // Handle error case, e.g., throw an exception or return null
            return null;
        }
    }

    public AllEmployees getAllEmployees() {
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        return restTemplate.getForObject(url, AllEmployees.class);

    }

    public void calculateAnnualSalary(Employee employee) {
        int annualSalary = employee.getEmployee_salary() * 12;
        employee.setAnnualSalary(annualSalary);
    }

    public void calculateAnnualSalaries(List<Employee> employees) {
        for (Employee employee : employees) {
            calculateAnnualSalary(employee);
        }
    }
}
