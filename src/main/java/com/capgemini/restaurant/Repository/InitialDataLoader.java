package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialDataLoader {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private TableRepository tableRepository;

    @PostConstruct
    public void createUsers() {
        List<Person> persons = new ArrayList<>();

        persons.add(new Employee(8, "Mister", "Owner", "MisterOwner@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China"),
                Role.Owner, "owner", encryptPassword("ownerPassword")));
        persons.add(new Employee(9, "Mister", "Chef", "MisterChef@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China"),
                Role.Chef, "chef", encryptPassword("chefPassword")));
        persons.add(new Employee(10, "Mister", "Floormanager", "MisterFloormanager@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China"),
                Role.Floormanager, "floormanager", encryptPassword("floormanagerPassword")));

        for (Person person : persons) {
            employeeRepository.save((Employee) person);
        }

        guestRepository.save(new Guest(10, "Mister", "Guest", "MisterGuest@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China"),
                Role.Guest, "guest", encryptPassword("guestPassword")));

        tableRepository.save(new Table(1, TableType.ROUND));
        tableRepository.save(new Table(2, TableType.SQUARE));
    }

    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
