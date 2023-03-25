package com.example.test;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestApplication {

	@Autowired
	private ParentRepo parentRepo;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@PostConstruct
	public void test() {
		final List<Long> ids = List.of(1L, 2L);

		ids.stream().forEach(id -> parentRepo.findById(id)
				.ifPresent(parent -> parentRepo.delete(parent)));
	}

}
