package com.capgemini.restaurant;

import com.capgemini.restaurant.Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;
    private LocalDateTime date;

    List<MenuItem> menuItems = new ArrayList<>();
    List


    @BeforeEach
    void setUp() {

        Address address = new Address("A Street", 123, "a", "1234AB", "Amsterdam", "NH", "Netherlands");

        Supplier supplier = new Supplier("CheeseTown", address, "+54", "12345678", "CH12BANK345678910", "mail.address@example.com");
        Allergy lactose = new Allergy("Lactose");
        Ingredient ingredient1 = new Ingredient("Kaas", "Gram", 100, 0.60, supplier, lactose);

        MenuItem menuItem = new MenuItem(1, "Menu1", "long description of menu",  new ArrayList<Ingredient>(), 10.00, "image link");
        menuItem.addIngredient(ingredient1);
        menuItems.add(menuItem);

        date = LocalDateTime.of(2018, 10, 20, 19, 30);
        order = new Order(5, menuItems, 48, "Ontvangen", date);
    }


    @Test
    void getOrderID() {
        assertEquals(order.getOrderId(), 5);
        assertNotEquals(order.getOrderId(), 3);
    }

    @Test
    void setOrderID() {
        order.setOrderId(5);
        assertEquals(order.getOrderId(), 5);
        assertNotEquals(order.getOrderId(), 4);
    }

    @Test
    void setMenuItems() {
        order.setMenuItems(menuItems);
        assertNotNull(order.getMenuItems(), "kaas");
    }


    @Test
    void getMenuItems() {
        assertNotNull(order.getMenuItems());
    }

    @Test
    void getTableNumber() {
        assertEquals(order.getTableNumber(), 48);
    }

    @Test
    void setTableNumber() {
        order.setTableNumber(5);
        assertEquals(order.getTableNumber(), 5);
        assertNotEquals(order.getOrderId(), 4);

    }

    @Test
    void getOrderStatus() {
        assertEquals(order.getOrderStatus(), "Ontvangen");
    }

    @Test
    void setOrderStatus() {
        order.setOrderStatus("OrderStatus");
        assertEquals("OrderStatus", order.getOrderStatus());


    }

    @Test
    void getDate() {

        LocalDateTime newDate = LocalDateTime.of(2018, 10 ,10, 17, 0);
        order.setTime(newDate);
        assertEquals(order.getTime(), newDate);
    }

}