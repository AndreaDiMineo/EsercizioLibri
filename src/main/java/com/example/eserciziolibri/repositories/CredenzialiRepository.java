package com.example.eserciziolibri.repositories;

import com.example.eserciziolibri.models.Credenziali;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CredenzialiRepository extends CrudRepository<Credenziali, Long> {

    @Query("select s from Credenziali s where username = :username and passwordUser = :passwordUser")
    public Credenziali login(String username, String passwordUser);
}
