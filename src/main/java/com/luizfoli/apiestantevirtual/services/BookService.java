package com.luizfoli.apiestantevirtual.services;

import com.luizfoli.apiestantevirtual.models.Book;

import org.json.JSONObject;

public class BookService {

    public Book convertJsonToBook(JSONObject json) {
        Book book = new Book();

        JSONObject volumeInfo = json.getJSONArray("items").getJSONObject(0).getJSONObject("volumeInfo");

        book.setTitle(volumeInfo.getString("title"));
        book.setDescription(volumeInfo.getString("description"));
        //book.setPublisher(volumeInfo.getString("publisher"));
        //book.setPublishedDate(volumeInfo.getString("publishedDate"));
        book.setPageCount(volumeInfo.getInt("pageCount"));

        return book;
    }

}