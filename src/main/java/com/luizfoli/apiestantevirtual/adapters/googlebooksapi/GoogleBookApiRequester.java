package com.luizfoli.apiestantevirtual.adapters.googlebooksapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import com.luizfoli.apiestantevirtual.utils.RequestMaker;

/**
 * Adapter class for make requests to Google Books API
 * 
 * @author luizfoli
 * @since 20/08/2020
 */

@Service
public class GoogleBookApiRequester {

    @Value("${google_books_api_url}")
    private String googleBooksApiUrl;
    private RequestMaker requestMaker;

    public GoogleBookApiRequester(RequestMaker requestMaker) {
        this.requestMaker = requestMaker;
    }

    /**
     * Method to make a get request in /volumes to Google Books API.
     * 
     * @param bookName
     * @return JSON Object from Google Books API
     * @author luizfoli
     * @since 20/08/2020
     */

    public JSONObject getBooks(String bookName) {
        return requestMaker.get(this.googleBooksApiUrl + "/volumes?printType=books&q=" + bookName);
    }

}