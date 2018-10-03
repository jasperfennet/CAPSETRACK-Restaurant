package com.capgemini.restaurant;

import com.capgemini.restaurant.Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuestTest {
    private Guest guest1;
    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address("A Street", 123, "", "1234AB", "Amsterdam", "NH", "Netherlands");
        guest1 = new Guest("Pietje3", "Puk3", "pietje3.puk3@test.com", address, "+31", "12345678", true);
    }

    @Test
    void getFirstName() {
        assertEquals("Pietje3", guest1.getFirstName());
    }

    @Test
    void setFirstName() {
        guest1.setFirstName("Jantje3");
        assertEquals("Jantje3", guest1.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Puk3", guest1.getLastName());
    }

    @Test
    void setLastName() {
        guest1.setLastName("Tuk3");
        assertEquals("Tuk3", guest1.getLastName());
    }

    @Test
    void getEmailAddress() {
        assertEquals("pietje3.puk3@test.com", guest1.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        guest1.setEmailAddress("jantje3.tuk3@test.com");
        assertEquals("jantje3.tuk3@test.com", guest1.getEmailAddress());
    }

    @Test
    void getAddress() {
        assertEquals(this.address, guest1.getAddress());
    }

    @Test
    void setAddress() {
        Address newAdress = new Address("Another Street", 345, "a", "4567AB", "Utrecht", "UT", "Amsterdam");
        guest1.setAddress(newAdress);
        assertEquals(newAdress, guest1.getAddress());
    }

    @Test
    void getGuestID() {
        Guest newGuest1 = new Guest("a", "b", "c", address, "+31", "12345678", false);
        Guest newGuest2 = new Guest("d", "e", "f", address, "+31", "87654321", true);
        int newGuest1ID = newGuest1.getId();
        int newGuest2ID = newGuest2.getId();

        assertEquals(newGuest1ID+1, newGuest2ID);
    }
}