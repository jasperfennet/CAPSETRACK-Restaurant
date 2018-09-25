package Tests;
import Models.MenuItem;
import Models.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    List<MenuItem> menuItems= new ArrayList<>();

    @BeforeEach
    void setUp() {


        order = new Order(5,menuItems,48,"aanwezig",new Date());
    }



        @Test
    void getOrderID() {
        assertEquals(order.getOrderId(),5);
        assertNotEquals(order.getOrderId(),3);
        }
        @Test
        void setOrderID() {
            order.setOrderId(5);
        assertEquals(order.getOrderId(),5);
        assertNotEquals(order.getOrderId(), 4);
            }

//        @Test
//     void setMenuItems() {
//        order.setMenuItems(menuItems);
//        assertNotNull(order.getMenuItems(), "kaas");
//}
    @Test
    void getMenuItems() {
        assertNotNull(order.getMenuItems());
    }
        @Test
     void  getTableNumber (){
        assertEquals(order.getTableNumber(),48);
     }

     @Test
     void setTableNumber(){
        order.setTableNumber(5);
        assertEquals(order.getTableNumber(),5);
        assertNotEquals(order.getOrderId(),4);

     }
     @Test
    void getOrderStatus (){
        assertEquals(order.getOrderStatus(),"aanwezig");
     }
     @Test
     void setOrderStatus() {
         order.setOrderStatus("OrderStatus");
         assertNotNull(order.getOrderStatus(), "aanwezig");


     }
     @Test
    void getDate(){
        Date date = new Date();
        order.setTime(date);
        assertEquals(order.getTime(), date);
    }
    }

// 100% coverage