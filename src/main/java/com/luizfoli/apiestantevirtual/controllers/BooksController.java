package com.luizfoli.apiestantevirtual.controllers;

import com.luizfoli.apiestantevirtual.models.Book;
import com.luizfoli.apiestantevirtual.services.BookService;
import com.luizfoli.apiestantevirtual.utils.RequestMaker;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BooksController {

    private RequestMaker requestMaker = new RequestMaker();
    private BookService bookService = new BookService();

    @GetMapping
    public Book get(@RequestParam String name) {
        System.out.println(name);
        name = name.replaceAll(" ", "+");
        System.out.println(name);
        System.out.println("https://www.googleapis.com/books/v1/volumes?q=" + name);
        JSONObject retorno = requestMaker.get("https://www.googleapis.com/books/v1/volumes?q=" + name);
        Book book = bookService.convertJsonToBook(retorno);
        return book;
    }
}