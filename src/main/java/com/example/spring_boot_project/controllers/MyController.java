package com.example.spring_boot_project.controllers;

import com.example.spring_boot_project.models.Employee;
import com.example.spring_boot_project.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    private final EmployeeService employeeService;

    public MyController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        System.out.println("Handler");
        List<Employee> empList = employeeService.getAllEmployees();
        System.out.println("empList from handler: " + empList);
        return empList;
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable long id) {

        employeeService.deleteEmployeeById(id);
        return String.format("Employee with id %d was removed from the database", id);
    }
}
