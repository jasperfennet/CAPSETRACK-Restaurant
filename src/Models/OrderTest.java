package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    List<String> menuItems= new ArrayList<>();

    @BeforeEach
    void setUp() {

        menuItems.add("Brood");
        menuItems.add("Kaas");
        menuItems.add("Boter");

        order = new Order(5,menuItems,48,"aanwezig",new Date());
    }
        @Test
    void getOrderID() {
        assertEquals(order.getOrderId(),5);
        assertNotEquals(order.getOrderId(),3);
        }

        @Test
     void getMenuItems() {
        assertNotNull(order.getMenuItems());
     }

        @Test
     void  getTableNumber (){
        assertEquals(order.getTableNumber(),48);
     }
     @Test
    void getOrderStatus (){
        assertEquals(order.getOrderStatus(),"aanwezig");
     }
     @Test
    void getDate(){
        Date date = new Date();
        order.setTime(date);
        assertEquals(order.getTime(), date);
    }
    }

