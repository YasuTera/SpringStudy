package com.spring.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			//Jackson用　ObjectMapper
			ObjectMapper mpp = new ObjectMapper();
			
			//JSONファイル読込  setter/getter格納処理
			Student stdnt = mpp.readValue(new File("data/sample-full.json"), Student.class);
			
			//c 確認
			System.out.println("First name = "+ stdnt.getFirstName());
			System.out.println("Last name = "+ stdnt.getLastName()+ "\n");
			
			//Address 確認
			Address tmpAddress = stdnt.getAddress();
			
			System.out.println("Street = "+ tmpAddress.getBuilding());
			System.out.println("Street = "+ tmpAddress.getStreet());
			System.out.println("Street = "+ tmpAddress.getCity() + "\n");
			
			//language　確認
			for(String tmpLang : stdnt.getLanguages()) {
				System.out.println(tmpLang);
			}
		}
		catch(Exception e){
			
			e.printStackTrace();
		}

	}

}
