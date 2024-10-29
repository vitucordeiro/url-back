package com.example.urlshortener.app;

import java.time.Instant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.urlshortener.app.entities.Url;
import com.example.urlshortener.app.repository.UrlRepository;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UrlRepository repository) {
		return args -> {
			Instant now = Instant.now();
			Url url = new Url("https://www.youtube.com/watch?v=ssj0CGxv60k", now);
			repository.insert(url);
		};
	}
}

