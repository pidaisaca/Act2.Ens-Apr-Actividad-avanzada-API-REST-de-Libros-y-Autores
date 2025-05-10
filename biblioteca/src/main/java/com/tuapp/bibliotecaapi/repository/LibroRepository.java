package com.tuapp.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuapp.bibliotecaapi.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
