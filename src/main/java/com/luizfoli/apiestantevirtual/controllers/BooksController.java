package com.luizfoli.apiestantevirtual.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BooksController {


    @GetMapping
    public String get() {
        return "Hello World!";
    }
}