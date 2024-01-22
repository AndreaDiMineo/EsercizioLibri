package com.example.eserciziolibri.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4, max = 20)
    private String nome;
    @NotNull
    @Size(min = 4, max = 20)
    private String cognome;
    @NotNull
    @Size(min = 4, max = 10)
    private String username;
    @NotNull
    @Size(min = 4, max = 10)
    private String passwordUser;

    public Utente() {}

    public Utente(String nome, String cognome, String username, String passwordUser) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.passwordUser = passwordUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}
