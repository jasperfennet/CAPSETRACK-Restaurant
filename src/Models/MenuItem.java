package Models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuItem {

    private BufferedImage image;
    private File imageFile;
    private String pathString;
    private int imageWidth, imageHeight;
    private String menuDescription;
    private List<Ingredient> ingredients;

    public MenuItem(ArrayList<Ingredient> ingredients) {
        //Photo properties
        image = null;
        imageFile = null;
        pathString = "src\\Images\\test.jpg";
        imageWidth = 200;
        imageHeight = 200; // both to be changed later
        setImage(pathString);

        menuDescription = "";

        this.ingredients = ingredients;
    }

    public Image getImage() {
        return image;
    }

    public BufferedImage setImage(String path) {
        try {
            imageFile = new File(path);
            System.out.println(path);
            image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return image;
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
