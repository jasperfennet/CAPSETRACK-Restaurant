package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialDataLoader {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @PostConstruct
    public void createMenuItem() {
        List <MenuItem> menuItems = new ArrayList<>();

        Allergy allergyone = new Allergy("Pinda");
        Address addressone = new Address("koffiestraat", 52, "hoog","1111AD", "Amsterdam","Noord-Holland", "Holland");
        Supplier supplierone = new Supplier("Piet", addressone,"+22","052525252", "25252", "Piet@h.nl");
        List<Supplier> suppliers = new ArrayList<>();
        List<Allergy> allergies = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredientone = new Ingredient("deeg", "gram", 100, 2.11, suppliers, allergies );
        ingredients.add(ingredientone);
        suppliers.add(supplierone);
        allergies.add(allergyone);

        menuItems.add(new MenuItem(1,"Springrolls","very cripy roll",ingredients, 5.21,"google.nl"));
        menuItems.add(new MenuItem(2,"Spring","roll",ingredients, 5,"google.nl"));


    }
    @PostConstruct
    public void createUsers() {
        List<Person> persons = new ArrayList<>();

        persons.add(new Employee(8, "Mister", "Owner", "MisterOwner@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China","countryguy"),
                Role.Owner, "owner", encryptPassword("ownerPassword"), "+316","123456789"));
        persons.add(new Employee(9, "Mister", "Chef", "MisterChef@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China", "country"),
                Role.Chef, "chef", encryptPassword("chefPassword"), "+316","123456789"));
        persons.add(new Employee(10, "Mister", "Floormanager", "MisterFloormanager@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China", "country"),
                Role.Floormanager, "floormanager", encryptPassword("floormanagerPassword"), "+316","123456789"));

        for (Person person : persons) {
            employeeRepository.save((Employee) person);
        }

        guestRepository.save(new Guest(10, "Mister", "Guest", "MisterGuest@molveno.com",
                new Address("molveno", 1, "", "abcd12", "Beijing", "China", ""),
                Role.Guest, "guest", encryptPassword("guestPassword"), "+316", "123456789",true));

        tableRepository.save(new Table(1, TableType.ROUND));
        tableRepository.save(new Table(2, TableType.SQUARE));
    }

    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }


}
