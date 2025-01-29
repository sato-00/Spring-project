package com.example.demo.minus.controller;
//リクエストの受け取り

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

//minus.htmlに掛け算結果を渡してあげる、minus.htmlの表示

@Controller
public class MinusController {
	private final MinusService minusService;
	//依存性の注入
			//Serviceクラスのインスタンスをspringbootから受け取る
	public MinusController(MinusService minusService) {
		this.minusService=minusService;
	}
	
	//@GetMapping←このアノテーションは、HTTP GETリクエストを処理するメソッドに付けられます。
	//GETリクエストは、主にデータの取得に使用されます。たとえば、ウェブページの表示、リソースの検索などに使われます。
	@GetMapping("minus")
	public String minus() {
		
		return "minus.html";
	}
	
	//@PostMapping←このアノテーションは、HTTP POSTリクエストを処理するメソッドに使用されます。
	//POSTリクエストは、データの送信と変更に使用されることが多く、フォームの送信やリソースの作成などに使用されます。
	@PostMapping("minus")
	public String minus(@RequestParam int numBox1,@RequestParam int numBox2,Model model) {
		int result = minusService.minusNum(numBox1,numBox2);
		//リクエストスコープに格納
		model.addAttribute("result", result);
		return "minus.html";
	
	}
	
}
