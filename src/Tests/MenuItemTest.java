package Tests;

import Models.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    private MenuItem menuItem;
    private ArrayList<Ingredient> ingredients;

    @BeforeEach
    public void setUp() throws Exception{
        ingredients = new ArrayList<Ingredient>();
    }
    @Test
    void getImage() {

    }

    @Test
    void setImage() {
        String pathToTest = "src\\Images\\test.jpg";
        assertNotNull(menuItem.setImage(pathToTest));
    }

    @Test
    void getMenuDescription() {
    }

    @Test
    void setMenuDescription() {
    }

    @Test
    void getIngredientList() {
    }

    @Test
    void setIngredientList() {
    }

    @Test
    void addIngredient() {
    }
}