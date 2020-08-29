package com.luizfoli.apiestantevirtual.adapters.googlebooksapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.dto.VolumeGoogleBooksApiDTO;

/**
 * Adapter Class for Google Books API Request
 * @author luizfoli
 * @since 29/08/2020
 *
 */

@Service
public class GoogleBooksApi {

    @Value("${google_books_api_url}")
    private String googleBooksApiUrl;


    public VolumeGoogleBooksApiDTO getVolumes(String bookName) {
    	
    	RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<VolumeGoogleBooksApiDTO> exchange = 
				restTemplate.exchange(this.googleBooksApiUrl + "/volumes?printType=books&q=" + bookName,
				HttpMethod.GET, null, VolumeGoogleBooksApiDTO.class);

        return exchange.getBody();
    }

}