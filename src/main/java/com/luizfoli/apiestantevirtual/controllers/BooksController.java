package com.luizfoli.apiestantevirtual.controllers;

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

    @GetMapping
    public JSONObject get(@RequestParam String name) {
        name = name.replaceAll(" ", "+");
        JSONObject retorno = requestMaker.get("https://www.googleapis.com/books/v1/volumes?q=" + name);
        System.out.println(retorno);
        return retorno;
    }
}