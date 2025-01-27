package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.PlusService;

@Controller
public class PlusController {

	//依存性の注入（DI）
	private final PlusService plusService;

	//コンストラクタ
	public PlusController(PlusService plusService) {
		this.plusService = plusService;
	}

	@GetMapping("plus")
	public String plus(Model model) {

		String result = "";
//int型の値をString型に変更valueOf
		result = String.valueOf(plusService.plus(5, 6));

		//リクエストスコープに値を格納
		model.addAttribute("result", result);

		return "plus.html";
	}

}
