package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Guest;
import com.capgemini.restaurant.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/list")
    public Iterable<Guest> list() {
        return guestRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Guest findByGuestNR(@PathVariable int id) {
        return guestRepository.findById(id).get();
    }

    @PostMapping("/post")
    public Guest addGuest(@RequestBody Guest newGuest) {
       return guestRepository.save(newGuest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByGuestNR(@PathVariable int id){ guestRepository.deleteById(id);
    }

    @PutMapping("update/{id}")
    public Guest updateByGuestNR(@PathVariable int id, @RequestBody Guest update){
        Optional<Guest> currentGuest = guestRepository.findById(id);
        if(!currentGuest.isPresent()) {
            throw new RuntimeException();
        }
        return guestRepository.save(update);
    }
}

