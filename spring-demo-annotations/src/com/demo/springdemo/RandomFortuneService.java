package com.demo.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//�z��
	private String[] data = {
			"0:aaa",
			"1:bbb",
			"2:ccc"
	};
	
	//�����_���l����
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// �z�񂩂烉���_���ɑI��
		//�z��̌�������Ƀ����_���l�i�[
		int index = myRandom.nextInt(data.length);
		
		//�擾
		String theFortune = data[index];
		
		return theFortune;
	}

}
