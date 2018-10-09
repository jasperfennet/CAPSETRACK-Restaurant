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

    @Autowired
    private ExtraRepository extraRepository;

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
        List<Table> table = new ArrayList<>();

        LocalDateTime date = LocalDateTime.of(2018, 10, 20, 19, 00);

        Guest guest = new Guest(10, "Mister", "Lastname", "MisterGuest@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China", ""),
                Role.Guest, "guest", encryptPassword("guestPassword"), "+316", "123456789",true);

        for(int i = 0; i < 5; i++){
            Booking booking = new Booking();
            booking.setAmountOfPersons(i+1);
            guest.setFirstName("Guest" + i);
            booking.setGuest(guestRepository.save(guest));
            booking.setDate(date);

//            table.clear();
//            table.add(tableRepository.save(new Table(i+10, TableType.ROUND)));
//            table.add(tableRepository.save(new Table(i+20, TableType.SQUARE)));
//            booking.setTable(table);

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
