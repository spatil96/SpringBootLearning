package com.springframework.spring5webapp.controller;

import com.springframework.spring5webapp.repositories.AuthorRepo;
import com.springframework.spring5webapp.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    public AuthorController(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }


    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute( "authors",authorRepo.findAll());
        return "authors";
    }
    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute( "books",bookRepo.findAll());
        return "books";
    }
    @RequestMapping("/ba")
    public String getBooksAndAuthors(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        model.addAttribute("authors", authorRepo.findAll());
        return "booksAndAuthors";
    }
}
