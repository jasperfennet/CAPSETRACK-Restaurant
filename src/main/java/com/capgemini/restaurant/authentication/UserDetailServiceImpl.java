package com.capgemini.restaurant.authentication;

import com.capgemini.restaurant.Models.Employee;
import com.capgemini.restaurant.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //zowel guest als employee gemaakt worden
    @Override
    public User loadUserByUsername(String username) {
        Employee employee = employeeRepository.findByEmployeeName(username);
        return mapPersonToUser(employee);
    }
//    Arrays.asList(new SimpleGrantedAuthority()) voegt rollen toe.

    private User mapPersonToUser(Employee employee){
        return new User(employee.getUserName(), employee.getPassword(), Arrays.asList(new SimpleGrantedAuthority(employee.getRole())));
    }
}
