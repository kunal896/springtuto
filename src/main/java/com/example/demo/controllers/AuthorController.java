package com.example.demo.controllers;

import com.example.demo.domain.Author;
import com.example.demo.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

    @GetMapping("/authors/new")
    public String displayCreateForm(){
        return "author-form";
    }

    @PostMapping("/authors")
    public String createAuthor(Author author, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("savedAuthor", author);

        authorService.save(author);

        return "redirect:/authorCreateSucess";
    }

    @GetMapping("/authorCreateSucess")
    public String successPage(Model model){
        return "authorCreateSuccess";
    }

}
