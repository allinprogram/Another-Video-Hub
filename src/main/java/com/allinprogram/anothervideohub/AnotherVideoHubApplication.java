package com.allinprogram.anothervideohub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AnotherVideoHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnotherVideoHubApplication.class, args);
	}
}