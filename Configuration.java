package com.ejemplo.config;

import com.ejemplo.model.Pelicula;
import com.ejemplo.repository.PeliculaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PeliculaRepository repository) {
        return args -> {
            log.info("Precargando: " + repository.save(
                new Pelicula("El Viaje de Chihiro", "Hayao Miyazaki", 2001, "Fantasia")
            ));
            log.info("Precargando: " + repository.save(
                new Pelicula("La Forma del Agua", "Guillermo del Toro", 2017, "Fantasia")
            ));
        };
    }
}