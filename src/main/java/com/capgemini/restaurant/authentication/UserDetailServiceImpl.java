package com.capgemini.restaurant.authentication;

import com.capgemini.restaurant.Exceptions.UserNotFoundException;
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

    private User mapPersonToUser(Employee employee){
        return new User(employee.getUserName(), employee.getPassword(), Arrays.asList(new SimpleGrantedAuthority(employee.getRole().toString())));
    }
    private User mapPersonToUser(Guest guest){
        return new User(guest.getUserName(), guest.getPassword(), Arrays.asList(new SimpleGrantedAuthority(guest.getRole().toString())));
    }
//    private User mapPersonToUser(Guest guest){
//        return new User(guest.getUserName(), guest.getPassword(), Arrays.asList(new SimpleGrantedAuthority(guest.getRole().toString())));
//    }

}
