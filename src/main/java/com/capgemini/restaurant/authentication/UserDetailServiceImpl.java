package com.capgemini.restaurant.authentication;

import com.capgemini.restaurant.Exceptions.UserNotFoundException;
import com.capgemini.restaurant.Models.Credentials;
import com.capgemini.restaurant.Models.Employee;
import com.capgemini.restaurant.Models.Guest;
import com.capgemini.restaurant.Repository.EmployeeRepository;
import com.capgemini.restaurant.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private GuestRepository guestRepository;

    //zowel guest als employee gemaakt worden
    @Override
    public User loadUserByUsername(String username) {

        for(Employee employee : employeeRepository.findAll()){
            if(employee.getUserName().equals(username)){
                return mapPersonToUser(employee);
            }
        }
        for(Guest guest : guestRepository.findAll()){
            if(guest.getUserName().equals(username)){
                return mapPersonToUser(guest);
            }
        }
        throw new UserNotFoundException("User not found");
    }
//    Arrays.asList(new SimpleGrantedAuthority()) voegt rollen toe.

    private User mapPersonToUser(Credentials credential){
        return new User(credential.getUserName(), credential.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_" + credential.getRole().toString())));
    }
}
