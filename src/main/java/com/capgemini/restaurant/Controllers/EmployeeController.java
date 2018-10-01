package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Employee;
import com.capgemini.restaurant.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public Collection<Employee> list() {
        return employeeRepository.findAll();
    }

    @GetMapping("/get/{employeeNR}")
    public Employee findByEmployeeNR(@PathVariable int employeeNR) {
        return employeeRepository.findByEmployeeNR(employeeNR);
    }
    @GetMapping("/get/{employeeName}")
    public Employee findByEmployeeName(@PathVariable String employeeName){
        return employeeRepository.findByEmployeeName(employeeName);
    }

    @PostMapping("/post")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        this.employeeRepository.save(newEmployee);
        return newEmployee;
    }

    @DeleteMapping("/delete/{employeeNR}")
    public void deleteByEmployeeNR(@PathVariable int employeeNR){
        this.employeeRepository.deleteByEmployeeNR(employeeNR);
    }

    @PutMapping("update/{employeeNR}")
    public Employee updateByEmployeeNR(@PathVariable int employeeNR, @RequestBody Employee update){
        return this.employeeRepository.updateEmployee(employeeNR, update);
    }
}

