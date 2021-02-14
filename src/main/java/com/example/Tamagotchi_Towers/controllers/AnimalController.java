package com.example.Tamagotchi_Towers.controllers;

import com.example.Tamagotchi_Towers.models.User;
import com.example.Tamagotchi_Towers.models.animals.Animal;
import com.example.Tamagotchi_Towers.models.animals.AnimalType;
import com.example.Tamagotchi_Towers.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    AnimalRepository animalRepository;

    @GetMapping(value = "/animals")
    public ResponseEntity<List<Animal>> getAllAnimalsWithFilter(
            @RequestParam(name = "animalname", required = false) String animalname,
            @RequestParam(name = "animaltype", required = false) AnimalType animaltype){
        if (animalname != null){
            return new ResponseEntity<>(animalRepository.findAnimalByAnimalName(animalname), HttpStatus.OK);
        }
        if (animaltype != null){
            return new ResponseEntity<>(animalRepository.findAnimalByAnimalType(animaltype), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(animalRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/animals/users")
    public ResponseEntity<List<User>> findAnimalsForUsersNamedQuery(
            @RequestParam(name = "username") String username){
        return new ResponseEntity(animalRepository.findAnimalByUserUserName(username), HttpStatus.OK);
    }

    @GetMapping(value = "/animals/{id}")
    public ResponseEntity getAnimal(@PathVariable Long id){
        return new ResponseEntity(animalRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/animals")
    public ResponseEntity<Animal> postAnimal(@RequestBody Animal animal){
        animalRepository.save(animal);
        return new ResponseEntity<>(animal, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/animals/{id}")
    public ResponseEntity<Animal> deleteAnimal(@PathVariable Long id){
        Animal found = animalRepository.getOne(id);
        animalRepository.delete(found);
        return new ResponseEntity(animalRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value="/animals/{id}")
    public ResponseEntity<Animal> putAnimal(@RequestBody Animal animal, @PathVariable Long id){
        Animal animalToUpdate = animalRepository.findById(id).get();
        animalToUpdate.setAnimalName(animal.getAnimalName());
        animalToUpdate.setAnimalType(animal.getAnimalType());
        animalToUpdate.setHealth(animal.getHealth());
        animalToUpdate.setHappiness(animal.getHappiness());
        animalToUpdate.setCleanliness(animal.getCleanliness());
        animalToUpdate.setFitness(animal.getFitness());
        animalToUpdate.setHunger(animal.getHunger());
        animalRepository.save(animalToUpdate);
        return new ResponseEntity<>(animalToUpdate, HttpStatus.OK);
    }
}
