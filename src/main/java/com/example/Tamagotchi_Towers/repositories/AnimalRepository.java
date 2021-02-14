package com.example.Tamagotchi_Towers.repositories;

import com.example.Tamagotchi_Towers.models.User;
import com.example.Tamagotchi_Towers.models.animals.Animal;
import com.example.Tamagotchi_Towers.models.animals.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findAnimalByAnimalName(String name);

    List<Animal> findAnimalByAnimalType(AnimalType animalType);

    List<Animal> findAnimalByUserUserName(String username);
}
