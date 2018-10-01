package Tests;

import Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingTest {

    private Booking booking;
    private MenuItem menuItem;


    @BeforeEach
    void setUp() {
        Address address = new Address("A Street", 123, "a", "1234AB", "Amsterdam", "Netherlands");

        Supplier supplier = new Supplier("CheeseTown", address, "+5412345678", "CH12BANK345678910");
        Ingredient ingredient1 = new Ingredient("Kaas", "Gram", 100, 0.60, supplier, "Lactose");

        List<Table> tableList = new ArrayList<>();
        tableList.add(new Table(4, TableType.SQUARE));
     //   tableList.add(new SquareTable(2));

        menuItem = new MenuItem("Menu 1", new ArrayList<Ingredient>());
        menuItem.addIngredient(ingredient1);

        booking =
                new Booking(new Guest("Henk", "Smit", "henk.smit@email.com",
                        new Address("A Street", 123, "a", "1234AB", "Amsterdam", "Netherlands")),
                        1,
                        new Date(), 4,
                        new ArrayList<Extra>(),
                        new ArrayList<Order>(),
                        tableList
                );
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
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(this.menuItem);
        booking.getOrders().add(new Order(1, menuItems, 12, "Ontvangen", new Date()));
        assertTrue(booking.getOrders().size() == 1);
    }

    @Test
    void removeOrder() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(this.menuItem);
        booking.getOrders().add(new Order(1, menuItems, 12, "Ontvangen", new Date()));

        assertTrue(booking.getOrders().size() == 1);
        booking.getOrders().remove(0);
        assertTrue(booking.getOrders().size() == 0);
    }

}