package com.cjchika.crudapi.crudapidemo.rest;

import com.cjchika.crudapi.crudapidemo.dao.EmployeeDAO;
import com.cjchika.crudapi.crudapidemo.entity.Employee;
import com.cjchika.crudapi.crudapidemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    // INJECT EMPLOYEE SERVICE (USING CONSTRUCTOR INJECTION)
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // EXPOSE "/EMPLOYEES" AND RETURN A LIST OF EMPLOYEE
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
       return employeeService.getAll();
    }

    // ADD MAPPING FOR GET /EMPLOYEES/{EMPLOYEEID}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }

        return theEmployee;
    }

    // ADD MAPPING FOR CREATING NEW EMPLOYEE
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // JUST IN CASE THEY PASS AN ID IN THE JSON BODY - SET ID TO 0
        // THIS IS TO FORCE A SAVE OF NEW - INSTEAD OF UPDATE

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // ADD MAPPING FOR PUT /EMPLOYEES - UPDATING EXISTING EMPLOYEE
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // ADD MAPPING TO REMOVE AN EMPLOYEE
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        // THROW EXCEPTION IF NULL

        if(tempEmployee == null){
            throw new RuntimeException("Employee not found " + employeeId );
        }

        employeeService.deleteById(employeeId);
        return "Employee deleted " + employeeId;
    }
}












