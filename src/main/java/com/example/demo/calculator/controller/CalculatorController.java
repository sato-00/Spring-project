package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

//リクエストの受け取り
//掛け算結果を渡してhtmlの表示
@Controller
public class CalculatorController {
	private final CalculatorService calculatorService;

	//依存性の注入
	//Serviceクラスのインスタンスをspringbootから受け取る
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	//@GetMapping←このアノテーションは、HTTP GETリクエストを処理するメソッドに付けられます。
	//GETリクエストは、主にデータの取得に使用されます。たとえば、ウェブページの表示、リソースの検索などに使われます。
	@GetMapping("calculator")
	public String calculator() {
		return "calculator.html";
	}

	//@PostMapping←このアノテーションは、HTTP POSTリクエストを処理するメソッドに使用されます。
	//POSTリクエストは、データの送信と変更に使用されることが多く、フォームの送信やリソースの作成などに使用されます。
	@PostMapping("calculator")
	public String calculator(@RequestParam double numBox1, @RequestParam double numBox2, @RequestParam String operation, Model model) {
		try{double result = calculatorService.calculator(numBox1, numBox2,operation);
		model.addAttribute("result", result);
		}catch(ArithmeticException | NumberFormatException e) {
			model.addAttribute("result", e.getMessage());
		}
		return "calculator.html";
	}

}
