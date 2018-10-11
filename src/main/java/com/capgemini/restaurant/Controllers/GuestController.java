package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Exceptions.UserNotFoundException;
import com.capgemini.restaurant.Models.Guest;
import com.capgemini.restaurant.Models.Guest;
import com.capgemini.restaurant.Repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/guest")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Secured({"ROLE_Owner", "ROLE_Restaurant","ROLE_Floormanager"})
    @GetMapping("/list")
    public Iterable<Guest> list() {
        return guestRepository.findAll();
    }

    @Secured({"ROLE_Owner", "ROLE_Restaurant","ROLE_Floormanager","ROLE_Guest"})
    @GetMapping("/get/{id}")
    public Guest findByGuestNR(@PathVariable int id) {
        return guestRepository.findById(id).get();
    }


    @PostMapping("/post")
    public Guest addGuest(@RequestBody Guest newGuest) {

        for(Guest guest : list()){
            if(guest.getUserName().equals(newGuest.getUserName()))
            {
                throw new UserNotFoundException("Username already exists");
            }
        }
        newGuest.setPassword(passwordEncoder.encode(newGuest.getPassword()));
        return guestRepository.save(newGuest);
    }

    @Secured({"ROLE_Owner", "ROLE_Floormanager"})
    @DeleteMapping("/delete/{id}")
    public void deleteByGuestNR(@PathVariable int id){ guestRepository.deleteById(id);
    }

    @Secured({"ROLE_Owner", "ROLE_Restaurant","ROLE_Floormanager","ROLE_Guest"})
    @PutMapping("update/{id}")
    public Guest updateByGuestNR(@PathVariable int id, @RequestBody Guest update){
        Optional<Guest> currentGuest = guestRepository.findById(id);
        if(!currentGuest.isPresent()) {
            throw new UserNotFoundException("Is Already Present");
        }
        return guestRepository.save(update);
    }
}

