package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Booking;
import com.capgemini.restaurant.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/list")
    public Collection<Booking> list() {
        return bookingRepository.findAll();
    }

    @GetMapping("/get/{bookingNR}")
    public Booking findByBookingNR(@PathVariable int bookingNR) {
        return bookingRepository.findByBookingNR(bookingNR);
    }


    @PostMapping("/post")
    public Booking addBooking(@RequestBody Booking newBooking) {
        this.bookingRepository.save(newBooking);
        return newBooking;
    }

    @DeleteMapping("/delete/{bookingNR}")
    public void deleteByBookingNR(@PathVariable int bookingNR){
        this.bookingRepository.deleteByBookingNR(bookingNR);
    }

    @PutMapping("update/{bookingNR}")
    public Booking updateByBookingNR(@PathVariable int bookingNR, @RequestBody Booking update){
        return this.bookingRepository.updateBooking(bookingNR, update);
    }
}

