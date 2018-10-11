package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Exceptions.UserNotFoundException;
import com.capgemini.restaurant.Models.Booking;
import com.capgemini.restaurant.Models.Table;
import com.capgemini.restaurant.Models.TableStatus;
import com.capgemini.restaurant.Repository.BookingRepository;
import com.capgemini.restaurant.Repository.TableRepository;
import com.capgemini.restaurant.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Secured({"ROLE_Owner","ROLE_Restaurant","ROLE_Floormanager"})
    @GetMapping("/list")
    public Iterable<Booking> list() {
        return bookingRepository.findAll();
    }

    @Secured({"ROLE_Restaurant","ROLE_Floormanager","ROLE_Owner"})
    @GetMapping("/get/{id}")
    public Booking findByBookingNR(@PathVariable int id) {
        Optional<Booking> currentBooking = bookingRepository.findById(id);
        if(!currentBooking.isPresent()) {
            throw new UserNotFoundException("Booking ID does not exist");
        }
        return bookingRepository.findById(id).get();
    }

    @PostMapping("/guest/post")
    public Booking addBookingGuest(@RequestBody Booking newBooking) {
        newBooking.getGuest().setPassword(passwordEncoder.encode(newBooking.getGuest().getPassword()));
        newBooking.setGuest(guestRepository.save(newBooking.getGuest()));
        return bookingRepository.save(newBooking);
    }

    @PostMapping("/employee/post")
    public Booking addBookingEmployee(@RequestBody Booking newBooking) {
        List<Table> addedTables = new ArrayList<>();
        for (Table table : newBooking.getTable()) {
            Optional <Table> findTable = tableRepository.findById(table.getId());
            if(!findTable.isPresent())
                throw new UserNotFoundException("Table ID not found");
            findTable.get().setStatus(TableStatus.RESERVED);
            addedTables.add(findTable.get());
        }
        newBooking.setTable(addedTables);
        return bookingRepository.save(newBooking);
    }

    @Secured({"ROLE_Restaurant","ROLE_Floormanager","ROLE_Owner"})
    @DeleteMapping("/delete/{id}")
    public void deleteByBookingNR(@PathVariable int id){
        Optional<Booking> currentBooking = bookingRepository.findById(id);
        if(!currentBooking.isPresent()) {
            throw new UserNotFoundException("Booking ID not found.");
        }
        bookingRepository.deleteById(id);
    }

    @Secured({"ROLE_Restaurant","ROLE_Floormanager", "ROLE_Guest","ROLE_Owner"})
    @PutMapping("update/{id}")
    public Booking updateByBookingNR(@PathVariable int id, @RequestBody Booking update){
        Optional<Booking> currentBooking = bookingRepository.findById(id);
        if(!currentBooking.isPresent()) {
            throw new UserNotFoundException("Booking ID not found.");
        }
        currentBooking.get().setAmountOfPersons(update.getAmountOfPersons());
        currentBooking.get().setDate(update.getDate());

        List<Table> addedTables = new ArrayList<>();
        for (Table table : update.getTable()) {
            Optional <Table> findTable = tableRepository.findById(table.getId());
            if(!findTable.isPresent())
                throw new UserNotFoundException("Table ID not found");
            findTable.get().setStatus(TableStatus.RESERVED);
            addedTables.add(findTable.get());
        }

        currentBooking.get().setTable(addedTables);
        return bookingRepository.save(currentBooking.get());
    }
}

