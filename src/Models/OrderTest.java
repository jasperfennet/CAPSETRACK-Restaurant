package Models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class OrderTest {

    private Order order;
    @BeforeEach
    void setUp() {

        order = new Order(5, 2,15,"bezet", new Date());
    }

        @Test
    void getorderID() {

        assertEquals(order.getOrderId(),5);
        assertNotEquals(order.getOrderId(),3);
        }

    }

