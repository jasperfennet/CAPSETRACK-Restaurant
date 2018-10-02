package MockData;
import Models.*;
import java.util.ArrayList;
import java.time.*;
import java.util.Random;

public class InitializeData {
    private ArrayList<Guest> guests = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Table> tables = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private ArrayList<Extra> extras = new ArrayList<>();
    private LocalDateTime dateTime = LocalDateTime.of(2018, 10, 20, 20, 0);
    public InitializeData() {
        for (int i = 0; i < 100; i++) {
            Address address = new Address(
                    "" + ('a' + i) + ('b' + i) + "street",
                    i,
                    "",
                    "" + ('a' + i) + ('b' + i) + ('c' + i),
                    "" + 'a' + ('b' + i) + "city",
                    "" + ('c' + i) + "land");
            guests.add(new Guest("" + 'a' + i,
                    "" + 'b' + i,
                    "" + ('a' + i) + "@" + ('b' + i) + ".com",
                    address));
            if(i < 50) {
                tables.add(new Table(i, TableType.ROUND));
            }else{
                tables.add(new Table(i, TableType.SQUARE));
            }
            extras.add(new Extra(""+i, i*(new Random().nextInt(5))));
            ArrayList<Extra> tempExtras = new ArrayList<>();tempExtras.add(extras.get(i));
            Address address2 = new Address(
                    "" + ('d' + i) + ('e' + i) + "street",
                    i,
                    "",
                    "" + ('x' + i) + ('y' + i) + ('z' + i),
                    "" + 'a' + ('b' + i) + "city",
                    "" + ('c' + i) + "land");
            Supplier supplier = new Supplier("" + ('a' + i),
                    address2,
                    ""+i + "" + (i+1) + "" + (i+2),
                    ""+ i + "" + (i+1) + "" + (i+2));
            ingredients.add(new Ingredient(""+('a' + i),"gram", i,i, supplier, "" + ('c' + i)));
            menuItems.add(new MenuItem("abcdefg", "hijklmnopqrstuvwxyz", ingredients));
            orders.add(new Order(i,menuItems,i,"in progress", dateTime));
            bookings.add(new Booking(guests.get(i),i,dateTime,new Random().nextInt(6),tempExtras, orders, tables));
        }
    }
    public ArrayList<Guest> getGuests() {
        return guests;
    }
    public ArrayList<Booking> getBookings() {
        return bookings;
    }
    public ArrayList<Table> getTables() {
        return tables;
    }
    public ArrayList<Order> getOrders() {
        return orders;
    }
    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    public ArrayList<Extra> getExtras() {
        return extras;
    }
}