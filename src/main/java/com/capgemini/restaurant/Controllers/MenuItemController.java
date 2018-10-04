package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Exceptions.UserNotFoundException;
import com.capgemini.restaurant.Models.MenuItem;
import com.capgemini.restaurant.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/menuItem")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Secured({"ROLE_Owner","ROLE_Kitchen","ROLE_Chef"})
    @GetMapping("/list")
    public Iterable<MenuItem> list() {
        return menuItemRepository.findAll();
    }
    @Secured({"ROLE_Owner","ROLE_Kitchen","ROLE_Chef"})
    @GetMapping("/get/{id}")
    public MenuItem findByMenuItemNR(@PathVariable int id) {
        return menuItemRepository.findById(id).get();
    }
    @Secured({"ROLE_Owner","ROLE_Chef"})
    @PostMapping("/post")
    public MenuItem addMenuItem(@RequestBody MenuItem newMenuItem) {
       return menuItemRepository.save(newMenuItem);
    }
    @Secured({"ROLE_Owner","ROLE_Chef"})
    @DeleteMapping("/delete/{id}")
    public void deleteByMenuItemNR(@PathVariable int id){ menuItemRepository.deleteById(id);
    }
    @Secured({"ROLE_Owner","ROLE_Chef"})
    @PutMapping("update/{id}")
    public MenuItem updateByMenuItemNR(@PathVariable int id, @RequestBody MenuItem update){
        Optional<MenuItem> currentMenuItem = menuItemRepository.findById(id);
        if(!currentMenuItem.isPresent()) {
            throw new UserNotFoundException("Is Already Present");
        }
        return menuItemRepository.save(update);
    }
}

