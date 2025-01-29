package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

//計算処理を行うメソッドを定義するクラス

@Service
public class CalculatorService {

	public double calculator(double numBox1, double numBox2, String operation) {
		double result = 0;

		switch (operation) { //←operationに選択した際の計算式が入る

		case "plus":// 足し算を行うメソッド
			result = numBox1 + numBox2;
			break;
		case "minus"://引き算
			result = numBox1 - numBox2;
			break;
		case "multi"://掛け算
			result = numBox1 * numBox2;
			break;
		case "divide"://割り算
			if (numBox2 == 0) {
				throw new ArithmeticException("ゼロ除算はできません");
			}
			result = numBox1 / numBox2;
			break;
			
		default:
			throw new IllegalArgumentException("無効な演算子です");
		}
		return result;

	}
}

//if (numBox2 != 0) {
//return numBox1 / numBox2;
//} else {
//throw new ArithmeticException
//return ("ゼロ除算はできません");
//}

// throw new ArithmeticException
