package MockData;

import Models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class InitializeData {

    private ArrayList<Guest> guests = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Table> tables = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private ArrayList<Extra> extras = new ArrayList<>();


    public InitializeData() {
        for (int i = 0; i < 100; i++) {
            guests.add(new Guest("" + 'a' + i,
                    "" + 'b' + i,
                    "" + ('a' + i) + "@" + ('b' + i) + ".com",
                    "" + ('a' + i) + ('b' + i) + "street",
                    "" + i,
                    "" + ('a' + i) + ('b' + i) + ('c' + i)));
            if(i < 50) {
                tables.add(new RoundTable());
            }else{
                tables.add(new SquareTable());
            }
            extras.add(new Extra(""+i, i*(new Random().nextInt(5))));
            ArrayList<Extra> tempExtras = new ArrayList<>();tempExtras.add(extras.get(i));
            Address address = new Address("" + 'a' + i,
                    i,
                    "" + ('a' + i) + "@" + ('b' + i) + ".com",
                    "" + ('a' + i) + ('b' + i) + "street",
                    "" + i);
            Supplier supplier = new Supplier("" + ('a' + i),
                    address,
                    ""+i + "" + (i+1) + "" + (i+2),
                    ""+ i + "" + (i+1) + "" + (i+2));
            ingredients.add(new Ingredient(""+('a' + i),"gram", i,i, supplier, "" + ('c' + i)));

            menuItems.add(new MenuItem(ingredients));
            orders.add(new Order(i,menuItems,i,"in progress", new Date()));
            bookings.add(new Booking(guests.get(i),i,new Date(),new Random().nextInt(6),tempExtras, orders));
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
