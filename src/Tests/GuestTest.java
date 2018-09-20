package Tests;

import Models.Guest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuestTest {
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;

    @BeforeEach
    void setUp() {
        guest1 = new Guest("Pietje1", "Puk1");
        guest2 = new Guest("Pietje2", "Puk2", "pietje2.puk2@test.com");
        guest3 = new Guest("Pietje3", "Puk3", "pietje3.puk3@test.com",
                "Address 3", "3333 AB","City");
    }

    @Test
    void getFirstName() {
        assertEquals("Pietje1", guest1.getFirstName());
        assertEquals("Pietje2", guest2.getFirstName());
        assertEquals("Pietje3", guest3.getFirstName());
    }

    @Test
    void setFirstName() {
        guest1.setFirstName("Jantje1");
        guest2.setFirstName("Jantje2");
        guest3.setFirstName("Jantje3");
        assertEquals("Jantje1", guest1.getFirstName());
        assertEquals("Jantje2", guest2.getFirstName());
        assertEquals("Jantje3", guest3.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Puk1", guest1.getLastName());
        assertEquals("Puk2", guest2.getLastName());
        assertEquals("Puk3", guest3.getLastName());
    }

    @Test
    void setLastName() {
        guest1.setLastName("Tuk1");
        guest2.setLastName("Tuk2");
        guest3.setLastName("Tuk3");
        assertEquals("Tuk1", guest1.getLastName());
        assertEquals("Tuk2", guest2.getLastName());
        assertEquals("Tuk3", guest3.getLastName());
    }

    @Test
    void getEmailAddress() {
        assertEquals("pietje2.puk2@test.com", guest2.getEmailAddress());
        assertEquals("pietje3.puk3@test.com", guest3.getEmailAddress());
    }

    @Test
    void setEmailAddress() {
        guest2.setEmailAddress("jantje2.tuk2@test.com");
        guest3.setEmailAddress("jantje3.tuk3@test.com");
        assertEquals("jantje2.tuk2@test.com", guest2.getEmailAddress());
        assertEquals("jantje3.tuk3@test.com", guest3.getEmailAddress());
    }

    @Test
    void getAddress() {
        assertEquals("Address 3", guest3.getAddress());
    }

    @Test
    void setAddress() {
        guest3.setAddress("Address 400");
        assertEquals("Address400", guest3.getAddress());
    }

    @Test
    void getPostCode() {
        assertEquals("3333 AB", guest3.getPostCode());
    }

    @Test
    void setPostCode() {
        guest3.setPostCode("4444 CD");
        assertEquals("4444 CD", guest3.getPostCode());
    }

    @Test
    void getCity() {
        assertEquals("City", guest3.getCity());
    }

    @Test
    void setCity() {
        guest3.setCity("Metropole");
        assertEquals("Metropole", guest3.getCity());
    }

    @Test
    void getGuestID() {
        assertEquals(1, guest1.getGuestID());
        assertEquals(2, guest2.getGuestID());
        assertEquals(3, guest3.getGuestID());
    }
}