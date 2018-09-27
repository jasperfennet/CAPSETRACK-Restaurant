package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.MenuItem;
import com.capgemini.restaurant.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/menuItem")
public class MenuController {

    @Autowired
    private MenuRepository menuItemRepository;

    @GetMapping("/list")
    public Collection<MenuItem> list() {
        return menuItemRepository.findAll();
    }

    @GetMapping("/get/{menuItemNR}")
    public MenuItem findByMenuItemNR(@PathVariable int menuItemNR) {
        return menuItemRepository.findByMenuItemNR(menuItemNR);
    }


    @PostMapping("/post")
    public MenuItem addMenuItem(@RequestBody MenuItem newMenuItem) {
        this.menuItemRepository.save(newMenuItem);
        return newMenuItem;
    }

    @DeleteMapping("/delete/{menuItemNR}")
    public void deleteByMenuItemNR(@PathVariable int menuItemNR){
        this.menuItemRepository.deleteByMenuItemNR(menuItemNR);
    }

    @PutMapping("update/{menuItemNR}")
    public MenuItem updateByMenuItemNR(@PathVariable int menuItemNR, @RequestBody MenuItem update){
        return this.menuItemRepository.updateMenuItem(menuItemNR, update);
    }
}

