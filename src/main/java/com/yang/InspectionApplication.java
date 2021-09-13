package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.yang"})
public class InspectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InspectionApplication.class, args);
	}

}
