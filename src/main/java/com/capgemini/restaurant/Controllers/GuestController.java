package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Guest;
import com.capgemini.restaurant.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/list")
    public Collection<Guest> list() {
        return guestRepository.findAll();
    }

    @GetMapping("/get/{guestNR}")
    public Guest findByGuestNR(@PathVariable int guestNR) {
        return guestRepository.findByGuestNR(guestNR);
    }


    @PostMapping("/post")
    public Guest addGuest(@RequestBody Guest newGuest) {
        this.guestRepository.save(newGuest);
        return newGuest;
    }

    @DeleteMapping("/delete/{guestNR}")
    public void deleteByGuestNR(@PathVariable int guestNR){
        this.guestRepository.deleteByGuestNR(guestNR);
    }

    @PutMapping("update/{guestNR}")
    public Guest updateByGuestNR(@PathVariable int guestNR, @RequestBody Guest update){
        return this.guestRepository.updateGuest(guestNR, update);
    }
}

