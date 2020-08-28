package com.demo.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//配列
	private String[] data = {
			"0:aaa",
			"1:bbb",
			"2:ccc"
	};
	
	//ランダム値引数
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// 配列からランダムに選択
		//配列の個数を上限にランダム値格納
		int index = myRandom.nextInt(data.length);
		
		//取得
		String theFortune = data[index];
		
		return theFortune;
	}

}
