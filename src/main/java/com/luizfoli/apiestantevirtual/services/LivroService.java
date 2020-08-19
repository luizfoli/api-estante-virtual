package com.luizfoli.apiestantevirtual.services;

import com.luizfoli.apiestantevirtual.models.Livro;

import org.json.JSONObject;

public class LivroService {

    public Livro convertJsonToBook(JSONObject json) {
        Livro book = new Livro();

        JSONObject volumeInfo = json.getJSONArray("items").getJSONObject(0).getJSONObject("volumeInfo");

        book.setTitulo(volumeInfo.getString("title"));
        book.setDescricao(volumeInfo.getString("description"));
        book.setQtdPaginas(volumeInfo.getInt("pageCount"));

        return book;
    }

}