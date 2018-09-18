package Tests;


import Models.Booking;
import Models.Extra;
import Models.Guest;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookingTest {

    private Booking booking;
    @BeforeEach
    void setUp() {

        booking = new Booking(new Guest(),1,new Date(),3, new Extra("chair", 0), new Bestelling());
    }

    @Test
    void getGuest() {
        assertNotNull(booking.getGuest());
    }

    @Test
    void getId() {
        assertNotNull(booking.getId());
    }

    @Test
    void getDate() {
        assertNotNull(booking.getDate());
    }

    @Test
    void getAmountOfPersons() {
        assertNotNull(booking.getAmountOfPersons());
    }

    @Test
    void getExtra() {
        assertNotNull(booking.getExtra());
    }
}