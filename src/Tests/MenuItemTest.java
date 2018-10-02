package Tests;

import Models.Address;
import Models.Ingredient;
import Models.MenuItem;
import Models.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class MenuItemTest {

    private MenuItem menuItem;
    private String menuName, menuDesription;
    private ArrayList<Ingredient> ingredients;
    private Supplier supplier;

    @BeforeEach
    public void setUp() throws Exception {
        Address address = new Address("Streetname", 155, "", "541000", "Wuhan", "China");
        supplier = new Supplier("MeatDelivery", address, "0612345678", "NL12BANK1234567810");

        Ingredient ingr1 = new Ingredient("Carrot", "grams", 1000, 0.50d, supplier, "none");
        Ingredient ingr2 = new Ingredient("Milk", "liters", 10, 1.00d, supplier, "lactose");

        ingredients = new ArrayList<Ingredient>();
        ingredients.add(ingr1);
        ingredients.add(ingr2);

        menuName = "New Menu!";
        menuDesription = "This is the description of a menu";
        menuItem = new MenuItem(menuName, menuDesription, ingredients);
    }

    @Test
    void getMenuDescription() {
        assertNotNull(menuItem.getMenuDescription());
        assertEquals(menuDesription, menuItem.getMenuDescription());
    }

    @Test
    void setMenuDescription() {
        String newDescription = "The new menu description";
        assertNotEquals(newDescription, menuDesription);
        menuItem.setMenuDescription(newDescription);
        assertEquals(newDescription, menuItem.getMenuDescription());
    }

    @Test
    void getIngredientList() {
        assertNotNull(menuItem.getIngredientList());
        assertEquals(ingredients, menuItem.getIngredientList());
    }

    @Test
    void setIngredientList() {
        List<Ingredient> newList = new ArrayList<>();
        Ingredient newIngredient = new Ingredient("Name","KG", 10000, 1.00d, supplier, "lactose");
        newList.add(newIngredient);
        assertNotEquals(newList, ingredients);
        menuItem.setIngredientList(newList);
        assertEquals(newList, menuItem.getIngredientList());
    }

    @Test
    void addIngredient() {
        Ingredient newIngredient = new Ingredient("To Add","KG", 10000, 1.00d, supplier, "lactose");
        int currentSize = menuItem.getIngredientList().size();
        menuItem.addIngredient(newIngredient);
        assertEquals(currentSize+1, menuItem.getIngredientList().size());
    }

    @Test
    void removeIngredient() {
        Ingredient newIngredient = new Ingredient("To Remove","KG", 10000, 1.00d, supplier, "lactose");
        int currentSize = menuItem.getIngredientList().size();
        menuItem.addIngredient(newIngredient);
        assertEquals(currentSize+1, menuItem.getIngredientList().size());
        menuItem.removeIngredient(newIngredient);
        assertEquals(currentSize, menuItem.getIngredientList().size());
    }

    @Test
    void getName() {
        assertNotNull(menuItem.getName());
        assertEquals(menuName, menuItem.getName());
    }

    @Test
    void setName() {
        String newMenuName = "The new menu name";
        assertNotEquals(newMenuName, menuName);
        menuItem.setName(newMenuName);
        assertEquals(newMenuName, menuItem.getName());
    }
}