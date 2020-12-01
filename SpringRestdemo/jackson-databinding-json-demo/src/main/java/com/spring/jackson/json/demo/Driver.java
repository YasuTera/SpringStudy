package com.spring.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//Jackson�p�@ObjectMapper
			ObjectMapper mpp = new ObjectMapper();
			
			//JSON�t�@�C���Ǎ�  setter/getter�i�[����
			Student stdnt = mpp.readValue(new File("data/sample-full.json"), Student.class);
			
			//c �m�F
			System.out.println("First name = "+ stdnt.getFirstName());
			System.out.println("Last name = "+ stdnt.getLastName()+ "\n");
			
			//Address �m�F
			Address tmpAddress = stdnt.getAddress();
			
			System.out.println("Street = "+ tmpAddress.getBuilding());
			System.out.println("Street = "+ tmpAddress.getStreet());
			System.out.println("Street = "+ tmpAddress.getCity() + "\n");
			
			//language�@�m�F
			for(String tmpLang : stdnt.getLanguages()) {
				System.out.println(tmpLang);
			}
		}
		catch(Exception e){
			
			e.printStackTrace();
		}

	}

}
