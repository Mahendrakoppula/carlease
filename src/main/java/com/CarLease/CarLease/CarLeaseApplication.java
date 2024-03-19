package com.CarLease.CarLease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Starts the Spring Boot application by running the {@link SpringApplication#run(Class, String[])} method.
 *
 * @paramargs the command line arguments
 */
@SpringBootApplication
public class CarLeaseApplication {

	public static void main(String[] args) {

		SpringApplication.run(CarLeaseApplication.class, args);
		System.out.println("hello world!");
	}

}
