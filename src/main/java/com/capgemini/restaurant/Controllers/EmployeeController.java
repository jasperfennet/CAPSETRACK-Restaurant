package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Employee;
import com.capgemini.restaurant.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Secured("ROLE_Owner")
    @GetMapping("/list")
    public Iterable<Employee> list() {
        return employeeRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Employee findByEmployeeNR(@PathVariable int id) {
        return employeeRepository.findById(id).get();
    }

    @PostMapping("/post")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
       return employeeRepository.save(newEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByEmployeeNR(@PathVariable int id){ employeeRepository.deleteById(id);
    }

    @PutMapping("update/{id}")
    public Employee updateByEmployeeNR(@PathVariable int id, @RequestBody Employee update){
        Optional<Employee> currentEmployee = employeeRepository.findById(id);
        if(!currentEmployee.isPresent()) {
            throw new RuntimeException();
        }
        return employeeRepository.save(update);
    }
}

