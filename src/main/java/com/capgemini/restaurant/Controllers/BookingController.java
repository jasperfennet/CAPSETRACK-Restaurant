package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Booking;
import com.capgemini.restaurant.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Secured({"ROLE_Owner","ROLE_Restaurant","ROLE_Floormanager"})
    @GetMapping("/list")
    public Iterable<Booking> list() {
        return bookingRepository.findAll();
    }

    @Secured({"ROLE_Restaurant","ROLE_Floormanager","ROLE_Owner"})
    @GetMapping("/get/{id}")
    public Booking findByBookingNR(@PathVariable int id) {
        return bookingRepository.findById(id).get();
    }


    @PostMapping("/post")
    public Booking addBooking(@RequestBody Booking newBooking) {
       return bookingRepository.save(newBooking);
    }

    @Secured({"ROLE_Restaurant","ROLE_Floormanager","ROLE_Owner"})
    @DeleteMapping("/delete/{id}")
    public void deleteByBookingNR(@PathVariable int id){ bookingRepository.deleteById(id);
    }

    @Secured({"ROLE_Restaurant","ROLE_Floormanager", "ROLE_Guest","ROLE_Owner"})
    @PutMapping("update/{id}")
    public Booking updateByBookingNR(@PathVariable int id, @RequestBody Booking update){
        Optional<Booking> currentBooking = bookingRepository.findById(id);
        if(!currentBooking.isPresent()) {
            throw new RuntimeException();
        }
        return bookingRepository.save(update);
    }
}

