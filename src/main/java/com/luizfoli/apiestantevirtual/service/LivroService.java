package com.luizfoli.apiestantevirtual.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.GoogleBookApi;
import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.GoogleBookApiRequester;
import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.model.VolumeGoogleBookApi;
import com.luizfoli.apiestantevirtual.model.Livro;

@Service
public class LivroService {

    private GoogleBookApiRequester googleBookApiRequester;

    public LivroService(GoogleBookApiRequester googleBookApiRequester) {
        this.googleBookApiRequester = googleBookApiRequester;
    }

    public List<Livro> getBook(String bookName) throws Exception {
        bookName = bookName.replaceAll(" ", "+");
        return this.convertBooks(this.googleBookApiRequester.getVolumes(bookName));
    }

    private List<Livro> convertBooks(List<VolumeGoogleBookApi> volumes) throws Exception {
        List<Livro> livros = new ArrayList<>();
        volumes.forEach(volume -> {
            Livro livro = new Livro();
            // livro.getAutor(volume.get)
            livro.setDescricao(volume.getDescription());
            livro.setDataPublicacao(volume.getPublishedDate());
            livro.setId(volume.getId());
            livro.setPublicador(volume.getPublisher());
            livro.setQtdPaginas(volume.getPageCount());
            livro.setTitulo(volume.getTitle());
            livro.setAvaliacaoMedia(volume.getAverageRating());
            livro.setAvaliacao(volume.getRatingsCount());
            livro.setLinkImagem(volume.getImageLink());

            livros.add(livro);
        });
        return livros;
    }
}