package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Employee;
import com.capgemini.restaurant.Models.Person;
import com.capgemini.restaurant.Models.Role;
import com.capgemini.restaurant.Repository.EmployeeRepository;
import com.capgemini.restaurant.authentication.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


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
       newEmployee.setPassword(passwordEncoder.encode(newEmployee.getPassword()));
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

