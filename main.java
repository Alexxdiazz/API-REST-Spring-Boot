package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


    @Bean
    CommandLineRunner initDatabase(PeliculaRepository repository) {
        return args -> {
            repository.save(new Pelicula("El Viaje de Chihiro", "Hayao Miyasaki", 2001, "Fantasia"));
            repository.save(new Pelicula("La Forma del Agua", "Guillermo del Toro", 2017, "Fantasia"));

}
