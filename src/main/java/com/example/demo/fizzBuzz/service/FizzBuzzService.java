package com.example.demo.fizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzService {
	//計算処理を行うメソッドを定義するクラス
	//リストはList<データ型> 変数名 = new ArrayList<>()でできます。
	public List<String> fizzBuzz=new ArrayList<>();
	//1から100までの数字を表示
	for(int i = 1;i<=100;i++)
	{
		//3と5のどちらでも割り切れる数を求めてFizzBuzzと表示させる。
		if (i % 3 == 0 && i % 5 == 0) {
			fizzBuzz.add("FizzBuzz");

		} else if (i % 3 == 0) {
			fizzBuzz.add("Fizz");
		} else if (i % 5 == 0) {
			fizzBuzz.add("Buzz");
		}
	}
	return fizzBuzz;
}
}
