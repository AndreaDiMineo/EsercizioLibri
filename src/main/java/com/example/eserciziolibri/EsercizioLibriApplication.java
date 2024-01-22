package com.example.eserciziolibri;

import com.example.eserciziolibri.repositories.CredenzialiRepository;
import com.example.eserciziolibri.repositories.LibroRepository;
import com.example.eserciziolibri.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsercizioLibriApplication {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private CredenzialiRepository credenzialiRepository;

    public static void main(String[] args) {
        SpringApplication.run(EsercizioLibriApplication.class, args);
    }

}
