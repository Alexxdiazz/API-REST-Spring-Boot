package com.example.demo;

import java.util.Objects;


 import jakarta.persistence.*; 

@Entity
package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Pelicula {
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String director;
    private int año;
    private String genero;

    public Pelicula() {}

    public Pelicula(String titulo, String director, int año, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.año = año;
        this.genero = genero;
    }

    public Long getId() {
      return id;
     }
    public void setId(Long id) {
       this.id = id; 
      }
    public String getTitulo() { 
      return titulo; 
    }
    public void setTitulo(String titulo) {
       this.titulo = titulo;
       }
     public String getDirector()
      { 
        return director;   
      }
    public void setDirector(String director){   
        this.director = director; 
         }

    public int getAño() { 
        return año; 
      }
    
    public void setAño(int año) { 
        this.año = año; 
    }

    public String getGenero() { 
        return genero; 
    }
       public void setGenero(String genero) { 
        this.genero = genero; 
    }

    // equals(), hashCode(), toString() manuales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula pelicula)) return false;
        return año == pelicula.año && 
               Objects.equals(id, pelicula.id) && 
               Objects.equals(titulo, pelicula.titulo) && 
               Objects.equals(director, pelicula.director) && 
               Objects.equals(genero, pelicula.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, director, año, genero);
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", titulo='" + titulo + '\'' + ", director='" + director + '\'' + ", año=" + año + ", genero='" + genero + '\'' + '}';
    }
}