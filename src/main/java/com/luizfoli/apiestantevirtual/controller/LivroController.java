package com.luizfoli.apiestantevirtual.controller;

import java.util.List;

import com.luizfoli.apiestantevirtual.dto.LivroDTO;
import com.luizfoli.apiestantevirtual.repository.LivroRepository;
import com.luizfoli.apiestantevirtual.service.LivroService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private LivroRepository repository;
    private LivroService service;

    public LivroController(LivroRepository repository, LivroService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<LivroDTO> get(@RequestParam String name) throws Exception {
        return this.service.getBook(name);
    }
}