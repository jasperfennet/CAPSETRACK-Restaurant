package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
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

    @Autowired
    private BookingRepository bookingRepository;

    @PostConstruct
    public void createUsers() {
        List<Person> persons = new ArrayList<>();

        persons.add(new Employee(8, "Mister", "Owner", "MisterOwner@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China","countryguy"),
                Role.Owner, "owner", encryptPassword("ownerPassword"), "+316","123456789"));
        persons.add(new Employee(9, "Mister", "Chef", "MisterChef@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China", "country"),
                Role.Chef, "chef", encryptPassword("chefPassword"), "+316","123456789"));
        persons.add(new Employee(10, "Mister", "Floormanager", "MisterFloormanager@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China", "country"),
                Role.Floormanager, "floormanager", encryptPassword("floormanagerPassword"), "+316","123456789"));

        for (Person person : persons) {
            employeeRepository.save((Employee) person);
        }

        guestRepository.save(new Guest(10, "Mister", "Guest", "MisterGuest@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China", ""),
                Role.Guest, "guest", encryptPassword("guestPassword"), "+316", "123456789",true));

        tableRepository.save(new Table(1, TableType.ROUND));
        tableRepository.save(new Table(2, TableType.SQUARE));
    }

    @PostConstruct
    public void createBookings(){

        List<Booking> bookings = new ArrayList<>();

        LocalDateTime date = LocalDateTime.of(2018, 10, 20, 19, 00);

        for(int i = 0; i < 5; i++){
            Booking booking = new Booking();
            booking.setAmountOfPersons(i+1);
            booking.setDate(date);
            bookings.add(booking);
        }

        for (Booking booking : bookings) {
            bookingRepository.save(booking);
        }
    }

    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
