package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Table;
import com.capgemini.restaurant.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/table")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    @GetMapping("/list")
    public Iterable<Table> list() {
        return tableRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Table findByTableNR(@PathVariable int id) {
        return tableRepository.findById(id).get();
    }

    @PostMapping("/post")
    public Table addTable(@RequestBody Table newTable) {
       return tableRepository.save(newTable);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByTableNR(@PathVariable int id){ tableRepository.deleteById(id);
    }

    @PutMapping("update/{id}")
    public Table updateByTableNR(@PathVariable int id, @RequestBody Table update){
        Optional<Table> currentTable = tableRepository.findById(id);
        if(!currentTable.isPresent()) {
            throw new RuntimeException();
        }
        return tableRepository.save(update);
    }
}

