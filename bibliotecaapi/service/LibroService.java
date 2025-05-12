package com.tuapp.bibliotecaapi.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.tuapp.bibliotecaapi.model.Libro;
import com.tuapp.bibliotecaapi.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }
    
    public Libro getLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro update(Libro libro, Long id) {
        return libroRepository.findById(id).map(l -> {
            l.setTitulo(libro.getTitulo());
            l.setISBN(libro.getISBN());
            l.setAnioPublicacion(libro.getAnioPublicacion());
            l.setAutor(libro.getAutor());
            return libroRepository.save(l);
        }).orElseGet(() -> {
            libro.setId_libro(id);
            return libroRepository.save(libro);
        });
    }

    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> buscar(@RequestParam(required = false) String titulo, 
                           @RequestParam(required = false) Integer anio, 
                           @RequestParam(required = false) String sortBy, 
                           @RequestParam(required = false) String order) {
    List<Libro> libros = libroRepository.findAll();

    if (titulo != null) {
        libros = libros.stream()
                .filter(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }

    if (anio != null) {
        libros = libros.stream()
                .filter(libro -> libro.getAnioPublicacion() == anio)
                .collect(Collectors.toList());
    }

    if (sortBy != null && order != null) {
        if (order.equalsIgnoreCase("asc")) {
            libros = libros.stream()
                    .sorted(Comparator.comparing(libro -> (Libro) libro, Comparator.comparing(l -> getSortField((Libro) l, sortBy))))
                    .collect(Collectors.toList());
        } else if (order.equalsIgnoreCase("desc")) {
            libros = libros.stream()
                    .sorted(Comparator.comparing(libro -> (Libro) libro, Comparator.comparing(l -> getSortField((Libro) l, sortBy))))
                    .collect(Collectors.toList());
        }
    }

    return libros;
}

private Comparable getSortField(Libro libro, String sortBy) {
    switch (sortBy) {
        case "anioPublicacion":
            return libro.getAnioPublicacion();
        case "titulo":
            return libro.getTitulo();
        // Agrega más casos para otros campos que desees ordenar
        default:
            return libro.getTitulo();
    }
}

}
