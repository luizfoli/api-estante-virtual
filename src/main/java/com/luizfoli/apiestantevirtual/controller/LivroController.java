package com.luizfoli.apiestantevirtual.controller;

import java.util.List;

import com.luizfoli.apiestantevirtual.model.Livro;
import com.luizfoli.apiestantevirtual.repository.LivroRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Livro> get(@RequestParam String name) throws Exception {
        return this.repository.find(name);
    }
}