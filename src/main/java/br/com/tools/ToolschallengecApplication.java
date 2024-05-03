package br.com.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Classe principal da nossa aplicação Spring Boot.
 */
@SpringBootApplication
public class ToolschallengecApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolschallengecApplication.class, args);
	}

}
