package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class BookingRepository {

    private Map<Integer, Booking> bookings = new HashMap<>();

    @PostConstruct
    public void generateBooking() {
        List<Extra> extras = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        extras.add(new Extra("ChildSeat", 0.0));
        save(new Booking(
                new Guest("a","b","c@c",
                        new Address("a",1,"13","1234AB","amsterdam","NL")),
                1, new Date(), 3, extras, null));
    }

    public void save(Booking newBooking) {
        this.bookings.put(newBooking.getId(), newBooking);
    }

    public Collection<Booking> findAll() {
        return this.bookings.values();
    }

    public Booking findByBookingNR(int bookingNR) {
        return this.bookings.get(bookingNR);
    }

    public void deleteByBookingNR(int bookingNr) {
        this.bookings.remove(bookingNr);
    }

    public Booking updateBooking(int bookingNR, Booking update) {
        Booking booking = this.findByBookingNR(bookingNR);
        deleteByBookingNR(bookingNR);
        save(update);

        return update;
    }

}
