package com.example.demo.animalsAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.sampleAPI.data.Animals;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalRepository {
	public Animals[] getAnimals() throws IOException {

		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		Animals[] animalsList = mapper.readValue(json, Animals[].class);

		return animalsList;
	}

	public Animals[] getAnimal(int id) throws JsonMappingException, JsonProcessingException {
		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI?id="+id;

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		Animals[] animalsList = mapper.readValue(json, Animals[].class);

		return animalsList;
	}
}
