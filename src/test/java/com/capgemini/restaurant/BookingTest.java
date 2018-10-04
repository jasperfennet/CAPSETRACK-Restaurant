package com.capgemini.restaurant;

import com.capgemini.restaurant.Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    private Booking booking;
    private MenuItem menuItem;
    private Guest guest;
    private int bookingId, amountOfPersons;
    private Table table;
    private List<Table> tableList;
    private LocalDateTime date;
    private List<Supplier> suppliers = new ArrayList<>();
    private List<Allergy> allergies = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();


    @BeforeEach
    void setUp() {
        Address address = new Address("A Street", 123, "a", "1234AB", "Amsterdam", "NH" , "Netherlands");
        suppliers.add(new Supplier("CheeseTown", address, "+54", "12345678", "mail.address@example.com", "CH12BANK345678910"));
        allergies.add(new Allergy("Lactose"));
        ingredients.add(new Ingredient("Kaas", "Gram", 100, 0.60, suppliers, allergies));
        tableList = new ArrayList<>();
        table = new Table(4, TableType.SQUARE);
        tableList.add(table);

        guest = new Guest(1,"Pietje3", "Puk3", "pietje3.puk3@test.com", address, Role.Guest, "greatusername", "greatpassword", "+31", "12345678", true);

        bookingId = 1;
        amountOfPersons = 4;

        date = LocalDateTime.of(2018, 10, 22, 19, 30);

        menuItem = new MenuItem(1, "Menu 1", "long description of menu", ingredients,
                10.00, "link");

        booking =
                new Booking(guest,
                        bookingId,
                        date,
                        amountOfPersons,
                        new ArrayList<Extra>(),
                        new ArrayList<Order>(),
                        tableList
                );
    }

    @Test
    void getGuest() {
        assertNotNull(booking.getGuest());
        assertEquals(guest, booking.getGuest());
    }

    @Test
    void setGuest() {

        Guest newGuest = new Guest(1,"Anja", "de Vries", "pietje3.puk3@test.com", new Address(), Role.Guest, "greatusername", "greatpassword", "+31", "12345678", true);

        booking.setGuest(newGuest);
        assertEquals(newGuest, booking.getGuest());
        assertNotEquals(guest, newGuest);
    }

    @Test
    void getId() {
        assertEquals(bookingId, booking.getId());
    }

    @Test
    void setId() {
        int newBookingId = 99;
        booking.setId(newBookingId);

        assertEquals(newBookingId, booking.getId());
        assertNotEquals(bookingId, newBookingId);
    }

    @Test
    void getDate() {
        assertNotNull(booking.getDate());
        assertEquals(date, booking.getDate());
    }

    @Test
    void setDate() {
        LocalDateTime newDate = LocalDateTime.of(2018, 10, 27, 20, 30);
        booking.setDate(newDate);

        assertEquals(newDate, booking.getDate());
        assertNotEquals(date, newDate);
    }

    @Test
    void getAmountOfPersons() {
        assertEquals(amountOfPersons, booking.getAmountOfPersons());
    }

    @Test
    void setAmountOfPersons() {
        int newAmountOfPersons = 6;
        booking.setAmountOfPersons(newAmountOfPersons);

        assertEquals(newAmountOfPersons, booking.getAmountOfPersons());
        assertNotEquals(amountOfPersons, newAmountOfPersons);

    }

    @Test
    void getOrders() {
        assertNotNull(booking.getOrders());
    }

    @Test
    void getExtras() {
        assertNotNull(booking.getExtras());
    }

    @Test
    void addExtra() {
        int currentExtrasSize = booking.getExtras().size();
        booking.addExtra(new Extra("name", 10.0));
        assertEquals(currentExtrasSize+1, booking.getExtras().size());
    }

    @Test
    void removeExtra() {
        Extra newExtra = new Extra("extra", 100.0);
        booking.addExtra(newExtra);
        int extrasSize = booking.getExtras().size();
        booking.removeExtra(newExtra);
        assertEquals(extrasSize-1, booking.getExtras().size());
    }

    @Test
    void addOrder() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(this.menuItem);
        int orderSize = booking.getOrders().size();
        booking.addOrder(new Order(1, menuItems, 12, "Ontvangen", date));
        assertEquals(orderSize+1, booking.getOrders().size());
    }

    @Test
    void removeOrder() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(this.menuItem);
        Order newOrder = new Order(1, menuItems, 12, "Ontvangen", date);
        booking.addOrder(newOrder);
        int orderSize = booking.getOrders().size();
        booking.removeOrder(newOrder);
        assertEquals(orderSize-1, booking.getOrders().size());
    }

    @Test
    void getTable() {
        assertNotNull(booking.getTable());
        assertEquals(tableList, booking.getTable());
    }

    @Test
    void setTable() {
        Table newTable = new Table(8, TableType.ROUND);
        tableList.add(newTable);
        booking.setTable(tableList);

        assertEquals(tableList, booking.getTable());
    }
}