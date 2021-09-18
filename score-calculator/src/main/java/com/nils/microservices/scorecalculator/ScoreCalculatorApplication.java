package com.nils.microservices.scorecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ScoreCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreCalculatorApplication.class, args);
	}

}
