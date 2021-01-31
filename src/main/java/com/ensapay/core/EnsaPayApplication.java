package com.ensapay.core;

import com.ensapay.core.dao.AgentRepository;
import com.ensapay.core.entities.Agent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})



public class EnsaPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnsaPayApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AgentRepository agentRepository) {
		return args->{
			agentRepository.deleteAll();

			agentRepository.save(new Agent(null,"omar","password"));

			agentRepository.findAll().forEach(System.out::println);
		};
	}
}
