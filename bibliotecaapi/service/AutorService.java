package com.tuapp.bibliotecaapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tuapp.bibliotecaapi.model.Autor;
import com.tuapp.bibliotecaapi.model.Libro;
import com.tuapp.bibliotecaapi.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deleteAutor(Long id){
        autorRepository.deleteById(id);
    }

    public Autor update(Autor autor, Long id) {
        return autorRepository.findById(id).map(a -> {
            a.setNombre(autor.getNombre());
            a.setNacionalidad(autor.getNacionalidad());
            a.setLibros(autor.getLibros());
            return autorRepository.save(a);
        }).orElseGet(() -> {
            autor.setId_autor(id);
            return autorRepository.save(autor);
        });
    }

}
