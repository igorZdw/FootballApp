package com.akademia.kodu.AplikacjaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AplikacjaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplikacjaSpringApplication.class, args);

	}

}
