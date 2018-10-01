package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class GuestRepository {

    private Map<Integer, Guest> guests = new HashMap<>();

    @PostConstruct
    public void generateGuest() {
        save(new Guest("a","b","c@c",
                new Address("a",1,"13","1234AB","amsterdam","NL")));

    }

    public void save(Guest newGuest) {
        this.guests.put(newGuest.getGuestID(), newGuest);
    }

    public Collection<Guest> findAll() {
        return this.guests.values();
    }

    public Guest findByGuestNR(int guestNR) {
        return this.guests.get(guestNR);
    }

    public void deleteByGuestNR(int guestNr) {
        this.guests.remove(guestNr);
    }

    public Guest updateGuest(int guestNR, Guest update) {
        Guest guest = this.findByGuestNR(guestNR);
        deleteByGuestNR(guestNR);
        save(update);

        return update;
    }

}
