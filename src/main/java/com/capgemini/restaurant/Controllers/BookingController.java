package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Exceptions.UserNotFoundException;
import com.capgemini.restaurant.Models.Booking;
import com.capgemini.restaurant.Repository.BookingRepository;
import com.capgemini.restaurant.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

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

    @PostMapping("/post")
    public Booking addBooking(@RequestBody Booking newBooking) {
        newBooking.getGuest().setPassword(passwordEncoder.encode(newBooking.getGuest().getPassword()));
        newBooking.setGuest(guestRepository.save(newBooking.getGuest()));
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
            throw new UserNotFoundException("Is Already Present");
        }
        return bookingRepository.save(update);
    }
}

