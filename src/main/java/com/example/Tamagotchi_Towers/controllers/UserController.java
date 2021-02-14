package com.example.Tamagotchi_Towers.controllers;

import com.example.Tamagotchi_Towers.models.User;
import com.example.Tamagotchi_Towers.models.animals.Animal;
import com.example.Tamagotchi_Towers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsersWithFilter(
            @RequestParam(name = "username", required = false) String username){
        if (username != null) {
            return new ResponseEntity<>(userRepository.findByUserName(username), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> postUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<User> deleteAnimal(@PathVariable Long id) {
        User found = userRepository.getOne(id);
        userRepository.delete(found);
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }
}
