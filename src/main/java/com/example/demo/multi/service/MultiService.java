package com.example.demo.multi.service;

import org.springframework.stereotype.Service;

//計算処理を行うメソッドを定義するクラス

@Service
public class MultiService {
//掛け算をするメソッド
	public int multinum(int num1,int num2) {
		return num1*num2;
	}
}
