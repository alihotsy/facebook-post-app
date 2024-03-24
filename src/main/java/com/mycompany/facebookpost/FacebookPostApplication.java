package com.mycompany.facebookpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacebookPostApplication implements Runnable {

	public static void main(String[] args) {
		SpringApplication.run(FacebookPostApplication.class, args);
	}

	@Override
	public void run() {
		System.out.println("Hello world, Spring boot");
	}
}
