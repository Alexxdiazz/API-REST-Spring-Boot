package com.ejemplo.exception;

public class PeliculaNotFoundException extends RuntimeException {
    public PeliculaNotFoundException(Long id) {
        super("No se encontró la película con ID: " + id);
    }
}