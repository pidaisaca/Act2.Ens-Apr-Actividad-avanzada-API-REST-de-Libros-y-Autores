package com.tuapp.bibliotecaapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tuapp.bibliotecaapi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
