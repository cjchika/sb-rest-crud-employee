package com.cjchika.crudapi.crudapidemo.service;

import com.cjchika.crudapi.crudapidemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
