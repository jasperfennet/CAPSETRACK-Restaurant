package MockData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InitializeDataTest {

    InitializeData id;
    @BeforeEach
    void setUp() {
         id = new InitializeData();
    }

    @Test
    void getGuests() {
        assertTrue(id.getBookings().size() == 100);
    }

    @Test
    void getBookings() {
        assertTrue(id.getGuests().size() == 100);
    }

    @Test
    void getTables() {
        assertTrue(id.getExtras().size() == 100);
    }

    @Test
    void getOrders() {
        assertTrue(id.getIngredients().size() == 100);
    }

    @Test
    void getMenuItems() {
        assertTrue(id.getMenuItems().size() == 100);
    }

    @Test
    void getIngredients() {
        assertTrue(id.getOrders().size() == 100);
    }

    @Test
    void getExtras() {
        assertTrue(id.getTables().size() == 100);
    }
}