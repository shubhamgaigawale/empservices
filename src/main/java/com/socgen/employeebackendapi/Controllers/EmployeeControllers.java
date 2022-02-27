package com.socgen.employeebackendapi.Controllers;

import java.util.List;

import com.socgen.employeebackendapi.Models.Employee;
import com.socgen.employeebackendapi.Services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeControllers {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable Long empId){
        return employeeService.getEmployeeByEmpId(empId);
    }

    @PostMapping("/post")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.postEmployee(employee);
    }

    @PutMapping("/update/{empId}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable Long empId){
        Employee existingEmployee = employeeService.getEmployeeByEmpId(empId);
        if(existingEmployee != null){
            employeeService.updateEmployee(empId, employee);
            return "Employee has been updated";
        }else{
            return "Could not find employee with id " + empId;
        }
    }

    @DeleteMapping("/delete/{empId}")
    public String deleteEmployee(@PathVariable Long empId){
        if(empId != null){
            employeeService.deleteEmployeeById(empId);
            return "Employee had been deleted";
        }else{
            return "Something went wrong";
        }
    }
}
