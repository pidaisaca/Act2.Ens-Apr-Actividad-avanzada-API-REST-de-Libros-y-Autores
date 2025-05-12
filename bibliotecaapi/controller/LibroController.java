package com.tuapp.bibliotecaapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuapp.bibliotecaapi.model.Libro;
import com.tuapp.bibliotecaapi.service.LibroService;




@RestController
@RequestMapping("/api/v1/libros")
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
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.crearLibro(libro);
    }

    @PutMapping("/{id}")
    public Libro update(@RequestBody Libro mascota, @PathVariable Long id) {
        return libroService.update(mascota, id);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
    }

    @GetMapping("/buscar")
public List<Libro> buscar(@RequestParam(required = false) String titulo, 
                           @RequestParam(required = false) Integer anio, 
                           @RequestParam(required = false) String sortBy, 
                           @RequestParam(required = false) String order) {
    return libroService.buscar(titulo, anio, sortBy, order);
}
    
    
}
