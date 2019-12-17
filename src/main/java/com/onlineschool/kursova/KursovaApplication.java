package com.onlineschool.kursova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@SpringBootApplication
public class KursovaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KursovaApplication.class, args);
	}

}
