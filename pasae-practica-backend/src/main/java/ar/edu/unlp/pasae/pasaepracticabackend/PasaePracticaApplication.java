package ar.edu.unlp.pasae.pasaepracticabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "ar.edu.unlp.pasae.pasaepracticabackend.repository")

public class PasaePracticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasaePracticaApplication.class, args);
	}
}
