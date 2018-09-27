package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Table;
import com.capgemini.restaurant.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController

@RequestMapping("/api/tables")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    @CrossOrigin
    @GetMapping("/list")
    public Collection<Table> list() {
        return tableRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/get/{tableNR}")
    public Table findByTableNR(@PathVariable int tableNR) {
        return tableRepository.findByTableNR(tableNR);
    }

    @CrossOrigin
    @PostMapping("/post")
    public Table addTable(@RequestBody Table newTable) {
        this.tableRepository.save(newTable);
        return newTable;
    }

    @CrossOrigin
    @DeleteMapping("/delete/{tableNR}")
    public void deleteByTableNR(@PathVariable int tableNR) {
        this.tableRepository.deleteByTableNR(tableNR);
    }

    @CrossOrigin
    @PutMapping("update/{tableNR}")
    public Table updateByTableNR(@PathVariable int tableNR, @RequestBody Table update) {
        return this.tableRepository.updateTable(tableNR, update);
    }
}

