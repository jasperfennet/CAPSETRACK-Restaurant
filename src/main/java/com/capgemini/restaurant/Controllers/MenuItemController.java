package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.MenuItem;
import com.capgemini.restaurant.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/menuItem")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/list")
    public Iterable<MenuItem> list() {
        return menuItemRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public MenuItem findByMenuItemNR(@PathVariable int id) {
        return menuItemRepository.findById(id).get();
    }

    @PostMapping("/post")
    public MenuItem addMenuItem(@RequestBody MenuItem newMenuItem) {
       return menuItemRepository.save(newMenuItem);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByMenuItemNR(@PathVariable int id){ menuItemRepository.deleteById(id);
    }

    @PutMapping("update/{id}")
    public MenuItem updateByMenuItemNR(@PathVariable int id, @RequestBody MenuItem update){
        Optional<MenuItem> currentMenuItem = menuItemRepository.findById(id);
        if(!currentMenuItem.isPresent()) {
            throw new RuntimeException();
        }
        return menuItemRepository.save(update);
    }
}

