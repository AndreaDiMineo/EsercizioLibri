package com.example.eserciziolibri.repositories;

import com.example.eserciziolibri.models.Credenziali;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CredenzialiRepository extends CrudRepository<Credenziali, Long> {

    @Modifying
    @Query("insert into Credenziali (username, passwordUser) VALUES (:username, :passwordUser)")
    @Transactional
    public int register(String username, String passwordUser);

    @Query("select s from Credenziali s where username = :username and passwordUser = :passwordUser")
    public Credenziali login(String username, String passwordUser);
}
