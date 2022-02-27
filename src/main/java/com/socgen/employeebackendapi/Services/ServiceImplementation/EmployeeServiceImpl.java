package com.socgen.employeebackendapi.Services.ServiceImplementation;

import java.util.List;

import com.socgen.employeebackendapi.Models.Employee;
import com.socgen.employeebackendapi.Repositories.EmployeeRepository;
import com.socgen.employeebackendapi.Services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByEmpId(Long empId) {
        return employeeRepository.findByEmpId(empId);
    }

    public Employee getEmployeeByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public Employee postEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long empId, Employee employee) {
        Employee currentEmployee = employeeRepository.findByEmpId(empId);

        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        currentEmployee.setEmailId(employee.getEmailId());
        currentEmployee.setDesignation(employee.getDesignation());
        currentEmployee.setDepartment(employee.getDepartment());
        currentEmployee.setPhoneNumber(employee.getPhoneNumber());
        currentEmployee.setAge(employee.getAge());

        return employeeRepository.save(currentEmployee);
    }

    @Override
    public void deleteEmployeeById(Long empId) {
        employeeRepository.deleteById(empId);
    }

}
