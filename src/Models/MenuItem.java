package Models;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {

    private String menuDescription;
    private List<Ingredient> ingredients;

    public MenuItem(String menuDescription, ArrayList<Ingredient> ingredients) {
        this.menuDescription = menuDescription;
        this.ingredients = ingredients;
    }

    public String getMenuDescription() {
        return this.menuDescription;
    }

    public void setMenuDescription(String description) {
        this.menuDescription = description;
    }

    public List<Ingredient> getIngredientList() {
        return this.ingredients;
    }

    public void setIngredientList(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }
}
