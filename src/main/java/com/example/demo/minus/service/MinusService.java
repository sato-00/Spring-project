
package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

//計算処理を行うメソッドを定義するクラス

@Service
public class MinusService {
	//引き算をするメソッド
	public int minusNum(int numBox1,int numBox2){
		return numBox1 - numBox2;
	}
}
