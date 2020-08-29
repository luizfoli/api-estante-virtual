package com.luizfoli.apiestantevirtual.repository;

import java.util.List;

import com.luizfoli.apiestantevirtual.dto.LivroDTO;
import com.luizfoli.apiestantevirtual.service.LivroService;

import org.springframework.stereotype.Repository;

@Repository
public class LivroRepository {

    private LivroService livroService;

    public LivroRepository(LivroService livroService) {
        this.livroService = livroService;
    }

    public List<LivroDTO> find(String bookName) throws Exception {
        return this.livroService.getBook(bookName);
    }
};