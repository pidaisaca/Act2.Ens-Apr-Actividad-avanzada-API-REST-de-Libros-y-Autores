package com.tuapp.bibliotecaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuapp.bibliotecaapi.model.Libro;
import com.tuapp.bibliotecaapi.service.LibroService;




@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {

    private final LibroService libroService;


    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }


    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }
    
    @GetMapping("/{id}")
    public Libro getOne(@PathVariable Long id) {
        return libroService.getLibroById(id);
    }

    @PostMapping
    public Libro createLibro(Libro libro) {
        return libroService.crearLibro(libro);
    }

    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
    }

    
    
}
