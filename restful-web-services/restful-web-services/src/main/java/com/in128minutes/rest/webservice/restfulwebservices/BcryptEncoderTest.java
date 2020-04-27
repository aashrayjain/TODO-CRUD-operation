package com.in128minutes.rest.webservice.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i=1;i<=10;i++) {
			String encodedString = encoder.encode("7389330515");
			System.out.println(encodedString);
		}
		
	}

}
