package com.example.spring_boot_project.dao;


import com.example.spring_boot_project.models.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    void addEmployee(Employee user);
    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);
}
