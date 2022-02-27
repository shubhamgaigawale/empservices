package com.socgen.employeebackendapi.Services;

import java.util.List;

import com.socgen.employeebackendapi.Models.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeByEmpId(Long empId);

    Employee getEmployeeByFirstName(String firstName);

    Employee postEmployee(Employee employee);

    Employee updateEmployee(Long empId, Employee employee);

    void deleteEmployeeById(Long empId);
    
}
