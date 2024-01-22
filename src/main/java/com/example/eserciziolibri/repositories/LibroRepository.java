package com.example.eserciziolibri.repositories;

import com.example.eserciziolibri.models.Libro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface LibroRepository extends CrudRepository<Libro, Long> {

    @Modifying
    @Query("insert into Libro (titolo, autore, anno, prezzo) VALUES (:titolo, :autore, :anno, :prezzo)")
    @Transactional
    public int registerBook(String titolo, String autore, String anno, int prezzo);

    @Query(value = "select * from Libro", nativeQuery = true)
    public ArrayList<Libro> loadBooks();

    @Query(value = "select * from Libro where titolo = :titolo", nativeQuery = true)
    public Libro specificBook(String titolo);
}
