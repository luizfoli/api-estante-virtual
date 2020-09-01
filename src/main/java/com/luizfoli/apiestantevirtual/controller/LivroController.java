package com.luizfoli.apiestantevirtual.controller;

import java.util.List;

import com.luizfoli.apiestantevirtual.dto.LivroDTO;
import com.luizfoli.apiestantevirtual.dto.StatusLeituraDTO;
import com.luizfoli.apiestantevirtual.enums.LeituraStatus;
import com.luizfoli.apiestantevirtual.repository.LivroRepository;
import com.luizfoli.apiestantevirtual.service.LivroService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public List<LivroDTO> get(@RequestParam String name) throws Exception {
        return this.service.getBook(name);
    }

    @PostMapping
    public Boolean post(@RequestBody LivroDTO livro) {
        return this.service.postBook(livro);
    }

    @PutMapping("/status-leitura")
    public Boolean putStatusLeitura(@RequestBody StatusLeituraDTO dto) {
        return this.service.putStatusLeitura(dto);
    }
}