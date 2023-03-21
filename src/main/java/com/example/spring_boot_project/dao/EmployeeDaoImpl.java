package com.example.spring_boot_project.dao;

import com.example.spring_boot_project.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext
    private final EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployeeById(long id) {
        entityManager.remove(this.getEmployeeById(id));
    }
}
