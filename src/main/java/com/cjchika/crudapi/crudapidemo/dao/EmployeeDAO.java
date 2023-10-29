package com.cjchika.crudapi.crudapidemo.dao;

import com.cjchika.crudapi.crudapidemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
