package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MsMonileAppApplication {
	private static final Logger logger = LogManager.getLogger(MsMonileAppApplication.class);
	public static void main(String[] args) {
		logger.info("Starting Employees API...");
		SpringApplication.run(MsMonileAppApplication.class, args);
	}

}
