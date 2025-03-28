package com.Healthcare_AI.Healthcare.AI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.Healthcare_AI.Healthcare.AI.repository")
public class HealthcareAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareAiApplication.class, args);
	}

}
