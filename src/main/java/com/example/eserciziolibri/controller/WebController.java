package com.example.eserciziolibri.controller;

import com.example.eserciziolibri.models.Credenziali;
import com.example.eserciziolibri.models.Libro;
import com.example.eserciziolibri.models.Utente;
import com.example.eserciziolibri.repositories.CredenzialiRepository;
import com.example.eserciziolibri.repositories.LibroRepository;
import com.example.eserciziolibri.repositories.UtenteRepository;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class WebController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private CredenzialiRepository credenzialiRepository;

    @Autowired
    private Gson gson;

    ArrayList<Libro> books = new ArrayList<>();

    ArrayList<String> gsonBooks = new ArrayList<>();

    String userCred;

    Utente user;

    ArrayList<Libro> cart = new ArrayList<>();

    @GetMapping(value = "/")
    public String showInitial() {
        return "initial";
    }

    @GetMapping(value = "registerUser")
    public String showRegister(Utente utente, Model model) {
        model.addAttribute(utente);
        return "register";
    }

    @PostMapping(value = "registerUser")
    public String registerUser(@Valid Utente utente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "register";

        int status = utenteRepository.register(utente.getNome(), utente.getCognome(), utente.getUsername(), utente.getPasswordUser());
        if (status == 0) {
            return "register";
        }
        else {
            int statusReg = credenzialiRepository.register(utente.getUsername(), utente.getPasswordUser());
            user = utenteRepository.loadCred(utente.getUsername());
            userCred = utente.getUsername();
            return "redirect:/homepage";
        }
    }

    @GetMapping(value = "loginUser")
    public String showLogin(Credenziali credenziali, Model model) {
        model.addAttribute(credenziali);
        return "login";
    }

    @PostMapping(value = "loginUser")
    public String checkUser(@Valid Credenziali credenziali, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "login";

        Utente utente = utenteRepository.loadCred(credenziali.getUsername());
        if (utente == null) {
            return "login";
        }
        else {
            user = utente;
            userCred = credenziali.getUsername();
            return "redirect:/homepage";
        }
    }

    @GetMapping(value = "homepage")
    public String showHomepage(Model model) {
        model.addAttribute("username", userCred);
        return "homepage";
    }

    @GetMapping(value = "add")
    public String showAddBook(Libro libro, Model model) {
        model.addAttribute(libro);
        return "addBook";
    }

    @PostMapping(value = "add")
    public String registerBook(@Valid Libro libro, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "addBook";

        int status = libroRepository.registerBook(libro.getTitolo(), libro.getAutore(), libro.getAnno(), libro.getPrezzo());
        if (status == 0) {
            return "addBook";
        }
        else {
            books.add(libro);
            return "redirect:/homepage";
        }
    }

    @GetMapping(value = "books")
    public String listBooks(Model model) {
        gsonBooks.clear();
        books = libroRepository.loadBooks();
        String json;
        for (Libro book: books) {
            json = gson.toJson(book);
            gsonBooks.add(json);
        }
        model.addAttribute("libri", books);
        model.addAttribute("libriJson", gsonBooks);
        return "booksList";
    }

    @GetMapping(value = "profile")
    public String profilePage(Model model) {
        model.addAttribute("profilo", user);
        return "profile";
    }

    @RequestMapping(value = "delete")
    public String deleteProfile() {
        utenteRepository.delete(user.getUsername());
        return "initial";
    }

    @GetMapping(value = "cart")
    public String showCart(Model model) {
        model.addAttribute("carrello", cart);
        return "cart";
    }

    @RequestMapping(value = "addToCart/{title}")
    public String addBookCart(@PathVariable(value = "title") String title, Model model) {
        Libro book = libroRepository.specificBook(title);
        cart.add(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "deleteFromCart/{title}")
    public String deleteBookCart(@PathVariable(value = "title") String title, Model model) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getTitolo().equals(title)) {
                cart.remove(i);
                break;
            }
        }
        model.addAttribute("carrello", cart);
        return "redirect:/cart";
    }

    @RequestMapping(value = "details/{title}")
    public String detailsBook(@PathVariable(value = "title") String title, Model model) {
        Libro book = libroRepository.specificBook(title);
        model.addAttribute("libro", book);
        return "details";
    }
}
