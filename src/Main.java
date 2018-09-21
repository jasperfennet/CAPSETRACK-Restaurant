import Models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Address address = new Address("Streetname", 155, "", "541000", "Wuhan");
    Supplier supplier = new Supplier("MeatDelivery", address, "0612345678", "NL12BANK1234567810");

    ArrayList<Ingredient> ingredients = new ArrayList<>();
    ingredients.add(
        new Ingredient("Strawberry's", "Kilo", 10, 20.00, supplier, "Strawberry Fever"));

    Guest fakeGuest = new Guest("Wu", "Tang");
    Guest fakeGuest2 = new Guest("Wu", "Tang");
    Date today = new Date();

    MenuItem menuItem = new MenuItem(ingredients, "Kindermenu");

    new Extra("KinderStoel", 0.00);
    new Order(1, MenuItem.menuItems, 123, "Gereserveerd", today);

    Booking a1 = new Booking(fakeGuest, 1, today, 10, Extra.extraItems, Order.orders);
    Booking a2 = new Booking(fakeGuest2, 2, today, 40, Extra.extraItems, Order.orders);
    Scanner scanner = new Scanner(System.in);
    boolean active = true;

    while (active) {
      System.out.println("*** - Molveno Lake Resort");
      System.out.println("*** - Restaurant application");
      System.out.println("*** - 1. Reservations");
      System.out.println("*** - 2. Exit\n");

      switch (scanner.nextInt()) {
        case 1:
          printReservationMenu();
          switch (scanner.nextInt()) {
            case 1:
              System.out.println("*** - Bookings");
              for (Booking booking : Booking.bookingList) {
                System.out.println(booking);
              }
              System.out.println("");
              break;
            case 2:
              continue;
            default:
              System.out.println("Wrong input try again.");
          }
          break;
        case 2:
          active = false;
          System.out.println("*** - Thanks for using our software");
          continue;
        default:
          System.out.println("Wrong input try again.");
      }
    }
  }

  private static void printReservationMenu() {
    System.out.println("*** - 1. Reservations");
    System.out.println("*** - 1.1 Show");
    System.out.println("*** - 1.2 Return\n");
  }
}
