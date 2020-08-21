package com.luizfoli.apiestantevirtual.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.GoogleBookApi;
import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.GoogleBookApiRequester;
import com.luizfoli.apiestantevirtual.models.Livro;

@Service
public class LivroService {

    private GoogleBookApi googleBookApi;
    private GoogleBookApiRequester googleBookApiRequester;

    public LivroService(GoogleBookApi googleBookApi, GoogleBookApiRequester googleBookApiRequester) {
        this.googleBookApi = googleBookApi;
        this.googleBookApiRequester = googleBookApiRequester;
    }

    public List<Livro> getBook(String bookName) throws Exception {
        return this.convertBooks(this.googleBookApiRequester.getBooks(bookName));
    }

    private List<Livro> convertBooks(JSONObject json) throws Exception {

        if (json == null) {
            throw new Exception("");
        }

        List<Livro> livros = new ArrayList<>();

        this.googleBookApi.convertJsonToItems(json).forEach(item -> {
            JSONObject volumeInfo = ((JSONObject) item).getJSONObject("volumeInfo");
            livros.add(this.createBook(volumeInfo));
        });

        return livros;
    }

    private Livro createBook(JSONObject json) {
        Livro livro = new Livro();
        livro.setTitulo(json.has("title") ? json.getString("title") : "");
        livro.setDescricao(json.has("description") ? json.getString("description") : "");
        livro.setQtdPaginas(json.has("pageCount") ? json.getInt("pageCount") : 0);
        return livro;
    }

}