package com.example.eserciziolibri.controller;

import com.example.eserciziolibri.models.LibroAPI;
import com.example.eserciziolibri.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestBooksController {

    @Autowired
    private LibroRepository libroRepository;

    @RequestMapping("/sincronizza")
    public void syncBooks() {
        RestTemplate restTemplate = new RestTemplate();
        String bookResourceUrl
                = "https://www.googleapis.com/books/v1/volumes?q=harry+potter";
        LibroAPI libroAPI = restTemplate.getForObject(bookResourceUrl, LibroAPI.class);
        for (int i = 0; i < libroAPI.items.length; i++) {
            if (libroAPI.items[i].getSaleInfo().getListPrice() == null) {
                libroRepository.registerBook(libroAPI.items[i].getVolumeInfo().getTitle(), libroAPI.items[i].getVolumeInfo().authors[0], libroAPI.items[i].getVolumeInfo().getPublishedDate(), 0);
            }
            libroRepository.registerBook(libroAPI.items[i].getVolumeInfo().getTitle(), libroAPI.items[i].getVolumeInfo().authors[0], libroAPI.items[i].getVolumeInfo().getPublishedDate(), (int)libroAPI.items[i].getSaleInfo().getListPrice().getAmount());
        }
    }
}
