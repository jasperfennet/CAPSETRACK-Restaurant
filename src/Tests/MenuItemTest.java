package Tests;

import Models.Address;
import Models.MenuItem;
import Models.Ingredient;
import Models.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

    private MenuItem menuItem;
    private ArrayList<Ingredient> ingredients;
    private Supplier supplier;
    private Address address;
    private Ingredient ingr1, ingr2;
    private String pathToImage;

    @BeforeEach
    public void setUp() throws Exception {
        address = new Address("Streetname", 155, "", "541000", "Wuhan");
        supplier = new Supplier("MeatDelivery", address, "0612345678", "NL12BANK1234567810");

        ingr1 = new Ingredient("Carrot", "grams", 1000, 0.50d, supplier, "none");
        ingr2 = new Ingredient("Milk", "liters", 10, 1.00d, supplier, "lactose");

        ingredients = new ArrayList<Ingredient>();
        ingredients.add(ingr1);
        ingredients.add(ingr2);

        menuItem = new MenuItem(ingredients, "kindermenu");

        pathToImage = "src\\Images\\test.jpg";
    }

    @Test
    void getImage() {
        BufferedImage img = menuItem.setImage(pathToImage);
        assertEquals(img, menuItem.getImage());

    }

    @Test
    void setImage() {
        assertNotNull(menuItem.setImage(pathToImage));
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