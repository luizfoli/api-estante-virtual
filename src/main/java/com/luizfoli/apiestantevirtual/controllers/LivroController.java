package com.luizfoli.apiestantevirtual.controllers;

import com.luizfoli.apiestantevirtual.models.Livro;
import com.luizfoli.apiestantevirtual.services.LivroService;
import com.luizfoli.apiestantevirtual.utils.RequestMaker;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private RequestMaker requestMaker = new RequestMaker();
    private LivroService bookService = new LivroService();

    @GetMapping
    public Livro get(@RequestParam String name) {
        name = name.replaceAll(" ", "+");
        JSONObject retorno = requestMaker.get("https://www.googleapis.com/books/v1/volumes?q=" + name);
        Livro book = bookService.convertJsonToBook(retorno);
        return book;
    }
}