package Tests;

import Models.Booking;
import Models.Extra;
import Models.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingTest {

    private Booking booking;
    @BeforeEach
    void setUp() {
        booking = new Booking(new Guest(),1,new Date(), 4, new ArrayList<Extra>(), new ArrayList<Order>());
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
    void getOrders() {
        assertNotNull(booking.getOrders());
    }

    @Test
    void addExtra() {
        booking.getExtras().add(new Extra("name", 10.0));
        assertTrue(booking.getExtras().size() == 1);
    }

    @Test
    void removeExtra() {
        booking.getExtras().add(new Extra("name", 10.0));
        assertTrue(booking.getExtras().size() == 1);
        booking.getExtras().remove(0);
        assertTrue(booking.getExtras().size() == 0);
    }

    @Test
    void addOrder() {
        booking.getOrders().add(new Order());
        assertTrue(booking.getOrders().size() == 1);
    }

    @Test
    void removeOrder() {
        booking.getOrders().add(new Order());
        assertTrue(booking.getOrders().size() == 1);
        booking.getOrders().remove(0);
        assertTrue(booking.getOrders().size() == 0);
    }
}