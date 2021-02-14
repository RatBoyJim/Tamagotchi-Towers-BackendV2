package com.example.Tamagotchi_Towers;

import com.example.Tamagotchi_Towers.models.User;
import com.example.Tamagotchi_Towers.models.animals.Animal;
import com.example.Tamagotchi_Towers.models.animals.AnimalType;
import com.example.Tamagotchi_Towers.repositories.AnimalRepository;
import com.example.Tamagotchi_Towers.repositories.UserRepository;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest
class TamagotchiTowersApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AnimalRepository animalRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void checkingUserProperties(){
		User user = userRepository.getOne(1L);
		assertEquals("Stuart", user.getUserName());
		assertEquals("ILikePenguins7", user.getPassword());
		assertEquals("fakeImgUrl", user.getImageURL());
		assertEquals(1, user.getAnimals().size());
	}

	@Test
	public void checkingAnimalProperties(){
		Animal animal = animalRepository.getOne(1L);
		assertEquals("Toto", animal.getAnimalName());
		assertEquals(100, animal.getHealth());
		assertEquals(100, animal.getHappiness());
		assertEquals(100, animal.getCleanliness());
		assertEquals(100, animal.getFitness());
		assertEquals(100, animal.getHunger());
		assertEquals(AnimalType.DOG, animal.getAnimalType());
//		List<User> foundUser = userRepository.findUserByAnimals(animal);
//		assertEquals(foundUser, animal.getUser());
	}

	@Test
	public void checkingAnimalTypeProperties(){
		Animal animal = animalRepository.getOne(1L);
		assertEquals(1.2, animal.getAppetite());
		assertEquals(1.5, animal.getGrooming());
		assertEquals(1, animal.getCheeriness());
		assertEquals(1.75, animal.getActivityLevel());
	}

}
