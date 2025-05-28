package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
