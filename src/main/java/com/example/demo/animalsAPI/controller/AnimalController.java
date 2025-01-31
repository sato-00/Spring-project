package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.service.AnimalService;
import com.example.demo.sampleAPI.data.Animals;

@Controller
public class AnimalController {
	private final AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/animal")
	public String getPets(Model model) throws IOException {
		List<Animals> animalsList = animalService.getAnimals();
		model.addAttribute("animalsList", animalsList);
		return "animal-search.html";
	}
	
	//PostMapping←このアノテーションは、HTTP POSTリクエストを処理するメソッドに使用されます。
		//POSTリクエストは、データの送信と変更に使用されることが多く、フォームの送信やリソースの作成などに使用されます。
		@PostMapping("/animal")
		public String getPets(@RequestParam("selectAnimal") int id,Model model) throws IOException {
			//System.out.println(id);
			try {
				List<Animals> animalsList =animalService.getAnimal(id);
				System.out.println(animalsList);
				model.addAttribute("animalsList", animalsList);
			}catch(ArithmeticException | NumberFormatException e) {
				model.addAttribute("result", e.getMessage());
			}
				return "animal-detail.html";	
			
		}
}
