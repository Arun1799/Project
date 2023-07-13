package com.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration, @EnableAutoConfiguration , @ComponentScan
@SpringBootApplication
public class ImsApApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsApApplication.class, args);
		System.out.println("Inventory project is Running.....");
	}

}
