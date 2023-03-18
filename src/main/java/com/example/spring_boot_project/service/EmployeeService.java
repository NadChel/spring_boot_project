package com.example.spring_boot_project.service;

import com.example.spring_boot_project.models.Employee;
import org.springframework.ui.Model;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Model setAddEmployeeModel(Model model);
    void addEmployee(Employee user);
    Model setUpdateEmployeeModel(Model mode, long id);

    void deleteEmployeeById(long id);
}
