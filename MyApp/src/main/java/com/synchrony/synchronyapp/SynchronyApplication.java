package com.synchrony.synchronyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.synchrony.synchronyapp.logger.Logger;

@SpringBootApplication
@ComponentScan("com.synchrony.synchronyapp")

public class SynchronyApplication {

	public static void main(String[] args) {
		Logger.info("Application started .........");
		SpringApplication.run(SynchronyApplication.class, args);
	}

}
