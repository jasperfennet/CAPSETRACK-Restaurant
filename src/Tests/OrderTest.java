package Tests;

import Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    List<MenuItem> menuItems = new ArrayList<>();

    @BeforeEach
    void setUp() {

        Address address = new Address("A Street", 123, "a", "1234AB", "Amsterdam", "Netherlands");

        Supplier supplier = new Supplier("CheeseTown", address, "+5412345678", "CH12BANK345678910");
        Ingredient ingredient1 = new Ingredient("Kaas", "Gram", 100, 0.60, supplier, "Lactose");

        MenuItem menuItem = new MenuItem("Menu1", new ArrayList<Ingredient>());
        menuItem.addIngredient(ingredient1);
        menuItems.add(menuItem);

        order = new Order(5, menuItems, 48, "Ontvangen", new Date());
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
        Date date = new Date();
        order.setTime(date);
        assertEquals(order.getTime(), date);
    }
}
