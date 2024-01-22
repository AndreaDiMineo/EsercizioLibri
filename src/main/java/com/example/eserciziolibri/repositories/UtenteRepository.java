package com.example.eserciziolibri.repositories;

import com.example.eserciziolibri.models.Credenziali;
import com.example.eserciziolibri.models.Utente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UtenteRepository extends CrudRepository<Utente, Long> {

    @Modifying
    @Query("insert into Utente (nome, cognome, username, passwordUser) VALUES (:nome, :cognome, :username, :passwordUser)")
    @Transactional
    public int register(String nome, String cognome, String username, String passwordUser);

    @Query("select s from Utente s where username = :username")
    public Utente loadCred(String username);

    @Query("delete from Utente where username = :username")
    public void delete(String username);

}
