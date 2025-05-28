package com.example.demo;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaRepository repository;

    public PeliculaController(PeliculaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pelicula> all() {
        return repository.findAll();
    }

    @PostMapping
    public Pelicula newPelicula(@RequestBody Pelicula newPelicula) {
        return repository.save(newPelicula);
    }

    @GetMapping("/{id}")
    public Pelicula one(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new PeliculaNotFoundException(id));
    }

    @PutMapping("/{id}")
    public Pelicula replacePelicula(@RequestBody Pelicula newPelicula, @PathVariable Long id) {
        return repository.findById(id)
            .map(pelicula -> {
                pelicula.setTitulo(newPelicula.getTitulo());
                pelicula.setDirector(newPelicula.getDirector());
                pelicula.setAño(newPelicula.getAño());
                pelicula.setGenero(newPelicula.getGenero());
                return repository.save(pelicula);
            })
            .orElseGet(() -> {
                newPelicula.setId(id);
                return repository.save(newPelicula);
            });
    }

    @DeleteMapping("/{id}")
    void deletePelicula(@PathVariable Long id) {
        repository.deleteById(id);
    }
}