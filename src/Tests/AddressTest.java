package Tests;

import Models.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {
    private Address address;

    @BeforeEach
    public void setUp() throws Exception {
        address = new Address("Streetname", 155, "", "541000", "Wuhan", "China");
    }

    @Test
    public void getStreetname() {
        assertEquals("Streetname", address.getStreetname());
    }

    @Test
    public void setStreetname() {
        address.setStreetname("Another Streetname");
        assertEquals("Another Streetname", address.getStreetname());
    }

    @Test
    public void getHouseNR() {
        assertEquals(155, address.getHouseNR());
    }

    @Test
    public void setHouseNR() {
        address.setHouseNR(123);
        assertEquals(123, address.getHouseNR());
    }

    @Test
    public void getAddition() {
        assertEquals("", address.getAddition());
    }

    @Test
    public void setAddition() {
        address.setAddition("AC");
        assertEquals("AC", address.getAddition());
    }

    @Test
    public void getCity() {
        assertEquals("Wuhan", address.getCity());
    }

    @Test
    public void setCity() {
        address.setCity("Peking");
        assertEquals("Peking", address.getCity());
    }

    @Test
    public void getZipcode() {
        assertEquals("541000", address.getZipcode());
    }

    @Test
    public void setZipcode() {
        address.setZipcode("123456");
        assertEquals("123456", address.getZipcode());
    }

    @Test
    void getCountry() {
        assertEquals("China", address.getCountry());
    }

    @Test
    void setCountry() {
        address.setCountry("Netherlands");
        assertEquals("Netherlands", address.getCountry());
    }
}
