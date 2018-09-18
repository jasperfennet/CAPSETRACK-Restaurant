package Tests;

import Models.MenuItem;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {

    @Test
    public void checkIfImagePathIsNotNull(){
        MenuItem tester = new MenuItem();
        String pathToTest = "src\\Images\\test.jpg";
        assertNotNull(tester.setImage(pathToTest));
    }


}