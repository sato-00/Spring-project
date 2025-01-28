package com.example.demo.fizzBuzz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.fizzBuzz.service.FizzBuzzService;

//リクエストの受け取り
@Controller
//fizzBuzz.htmlに掛け算結果を渡してあげる、fizzBuzz.htmlの表示
public class FizzBuzzController {
	private final FizzBuzzService fizzBuzzService;

	//依存性の注入
	//Serviceクラスのインスタンスをspringbootから受け取る
	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		this.fizzBuzzService = fizzBuzzService;
	}

	@GetMapping("fizzBuzz")
	public String fizzBuzz(Model model) {
		List<String> result = fizzBuzzService.getFizzBuzzList();
		//リクエストスコープに格納
		model.addAttribute("result", result);
		return "fizzBuzz.html";

	}
}
