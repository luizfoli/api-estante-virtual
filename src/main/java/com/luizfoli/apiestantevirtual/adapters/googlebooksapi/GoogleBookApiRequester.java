package com.luizfoli.apiestantevirtual.adapters.googlebooksapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.model.VolumeGoogleBookApi;
import com.luizfoli.apiestantevirtual.util.RequestMaker;

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

    private GoogleBookApi googleBookApi;
    private RequestMaker requestMaker;

    public GoogleBookApiRequester(GoogleBookApi googleBookApi, RequestMaker requestMaker) {
        this.requestMaker = requestMaker;
        this.googleBookApi = googleBookApi;
    }

    /**
     * Method to make a get request in /volumes to Google Books API.
     * 
     * @param bookName
     * @return JSON Object from Google Books API
     * @author luizfoli
     * @since 20/08/2020
     */

    public List<VolumeGoogleBookApi> getVolumes(String bookName) {
        JSONObject response = requestMaker.get(this.googleBooksApiUrl + "/volumes?printType=books&q=" + bookName);

        if (response == null) {
            System.out.println("Problemas com a API do Google");
        } else if (response.getInt("totalItems") == 0) {
            System.out.println("Não obteve resultado da Google Books API");
            return new ArrayList<>();
        }

        return this.googleBookApi.convertJsonToVolumes(response);
    }

}