package com.example.spring_boot_project.dao;

import com.example.spring_boot_project.models.Employee;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final EntityManagerFactory entityManagerFactory;

    public EmployeeDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> empList = entityManagerFactory
                .createEntityManager()
                .createQuery("from Employee", Employee.class).getResultList();
        System.out.println("empList from DAO: " + empList);
        return empList;
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManagerFactory.createEntityManager().merge(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return entityManagerFactory.createEntityManager().getReference(Employee.class, id);
    }

    @Override
    public void deleteEmployeeById(long id) {
        entityManagerFactory.createEntityManager().remove(this.getEmployeeById(id));
    }
}
