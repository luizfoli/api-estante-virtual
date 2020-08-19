package com.luizfoli.apiestantevirtual.services;

import com.luizfoli.apiestantevirtual.models.Book;

import org.json.JSONObject;

public class BookService {

    public Book convertJsonToBook(JSONObject json) {
        Book book = new Book();
        return book;
    }

}