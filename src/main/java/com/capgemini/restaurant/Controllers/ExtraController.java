package com.capgemini.restaurant.Controllers;

import com.capgemini.restaurant.Models.Extra;
import com.capgemini.restaurant.Repository.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/extra")
public class ExtraController {

    @Autowired
    private ExtraRepository extraRepository;

    @GetMapping("/list")
    public Iterable<Extra> list() {
        return extraRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Extra findByExtraId(@PathVariable int id) {
        return extraRepository.findById(id).get();
    }

    @PostMapping("/post")
    public Extra addExtra(@RequestBody Extra newExtra) {
        return extraRepository.save(newExtra);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByExtraId(@PathVariable int id){ extraRepository.deleteById(id);
    }

    @PutMapping("update/{id}")
    public Extra updateByExtraId(@PathVariable int id, @RequestBody Extra update){
        Optional<Extra> currentExtra = extraRepository.findById(id);
        if(!currentExtra.isPresent()) {
            throw new RuntimeException();
        }
        return extraRepository.save(update);
    }
}

