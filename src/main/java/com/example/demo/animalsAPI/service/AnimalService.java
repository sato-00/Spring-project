package com.example.demo.animalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.animalsAPI.repository.AnimalRepository;
import com.example.demo.sampleAPI.data.Animals;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class AnimalService {
	
	private final AnimalRepository animalRepository;
	
	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository =animalRepository;
	}
	public List<Animals> getAnimals() throws IOException {

		Animals[] animalsList = animalRepository.getAnimals();
		return Arrays.asList(animalsList);

	}
	public List<Animals> getAnimal(int id) throws JsonMappingException, JsonProcessingException {
		Animals[] animalsList = animalRepository.getAnimal(id);
		return Arrays.asList(animalsList);
		
	}
}
