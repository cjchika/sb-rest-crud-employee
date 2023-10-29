package com.cjchika.crudapi.crudapidemo.dao;

import com.cjchika.crudapi.crudapidemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{

    // DEFINE FIELD FOR ENTITY MANAGER
    private EntityManager entityManager;

    // SETUP CONSTRUCTOR INJECTION
    @Autowired
    public EmployeeDAOImp(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> getAll() {
        // CREATE A QUERY
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // EXECUTE QUERY AND GET RESULT LIST
        List<Employee> employees = theQuery.getResultList();

        // RETURN THE RESULTS
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // GET EMPLOYEE
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // RETURN EMPLOYEE
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // SAVE EMPLOYEE
        Employee dbEmployee = entityManager.merge(theEmployee);

        // RETURN EMPLOYEE
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // FIND EMPLOYEE BY ID
        Employee theEmployee = entityManager.find(Employee.class, theId);

        entityManager.remove(theEmployee);
    }
}















