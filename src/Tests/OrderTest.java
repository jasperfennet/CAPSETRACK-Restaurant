package Tests;

import Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.time.*;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;
    private LocalDateTime date;
    private Supplier supplier;
    private Address address;

    List<MenuItem> menuItems = new ArrayList<>();


    @BeforeEach
    void setUp() {

        address = new Address("A Street", 123, "a", "1234AB", "Amsterdam", "Netherlands");

        supplier = new Supplier("CheeseTown", address, "+5412345678", "CH12BANK345678910");
        Ingredient ingredient1 = new Ingredient("Kaas", "Gram", 100, 0.60, supplier, "Lactose");

        MenuItem menuItem = new MenuItem("Menu1", "long description of menu",  new ArrayList<Ingredient>());
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
    void getMenuItems() {
        assertNotNull(order.getMenuItems());
    }

    @Test
    void setMenuItems() {
        order.setMenuItems(menuItems);
        assertNotNull(order.getMenuItems(), "kaas");
    }

    @Test
    void addMenuItem() {
        MenuItem newMenuItem = new MenuItem("to add", "long description of menu",  new ArrayList<Ingredient>());
        int currentSize = order.getMenuItems().size();
        order.addMenuItem(newMenuItem);
        assertEquals(currentSize+1, order.getMenuItems().size());

    }

    @Test
    void removeMenuItem() {
        MenuItem newMenuItem = new MenuItem("to add", "long description of menu",  new ArrayList<Ingredient>());
        int currentSize = order.getMenuItems().size();
        order.addMenuItem(newMenuItem);
        assertEquals(currentSize+1, order.getMenuItems().size());
        order.removeMenuItem(newMenuItem);
        assertEquals(currentSize, order.getMenuItems().size());
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