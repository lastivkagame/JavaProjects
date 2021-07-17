package com.example.springboot.controllers.api;

import com.example.springboot.entities.Animal;
import com.example.springboot.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnimalController {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    /*@CrossOrigin(origins = "http://localhost:8080",
    methods = RequestMethod.GET, allowedHeaders = "*")*/
    @GetMapping("/animals")
    public List<Animal> index () {
        return  (List<Animal>) animalRepository.findAll();
    }
}
