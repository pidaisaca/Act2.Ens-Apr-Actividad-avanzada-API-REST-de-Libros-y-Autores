package com.tuapp.bibliotecaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

    public Libro updateLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public List<Libro> buscar() {
        List<Libro> libros = libroRepository.findAll();
        // falta aqui
        return libros;
    }

}
