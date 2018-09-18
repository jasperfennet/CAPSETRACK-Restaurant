package Models;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MenuItem {

    // foto, omschrijving, ingr[], prijs(), giveAllergies()?
    private BufferedImage image;
    private File imageFile;
    private String pathString;
    private int imageWidth, imageHeigth;

    private String menuDescription;

    private ArrayList<Ingredient> ingredients;

    public MenuItem(ArrayList<Ingredient> ingredients){
        //Photo properties
        image = null;
        imageFile = null;
        pathString = "src\\Images\\test.jpg";
        imageWidth = 200;
        imageHeigth = 200; // both to be changed later
        setImage(pathString);

        menuDescription = "";

        this.ingredients = ingredients;
    }

    public Image getImage(){
        return image;
    }
    public Image setImage(String path){
        try {
            imageFile = new File(path);
            System.out.println(path);
            image = new BufferedImage(imageWidth, imageHeigth, BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(imageFile);
        }
        catch(IOException e){
            System.out.println("Error: " + e);
        }
        return image;
    }

    public String getMenuDescription(){
        return menuDescription;
    }
    public void setMenuDescription(String description){
        menuDescription = description;
    }

    public ArrayList<Ingredient> getIngredientList(){
        return ingredients;
    }
    public void setIngredientList(ArrayList<Ingredient> ingredients){
        this.ingredients = ingredients;
    }
    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
    }
}
