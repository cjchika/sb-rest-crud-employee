package com.cjchika.crudapi.crudapidemo.dao;

import com.cjchika.crudapi.crudapidemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // NO NEED TO WRITE ANY CODE - WORKS OUT OF THE BOX
}
