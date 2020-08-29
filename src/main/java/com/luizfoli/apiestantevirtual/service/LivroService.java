package com.luizfoli.apiestantevirtual.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.GoogleBooksApi;
import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.dto.VolumeGoogleBooksApiDTO;
import com.luizfoli.apiestantevirtual.model.Livro;

@Service
public class LivroService {

    private GoogleBooksApi googleBookApiRequester;

    public LivroService(GoogleBooksApi googleBookApiRequester) {
        this.googleBookApiRequester = googleBookApiRequester;
    }

    public List<Livro> getBook(String bookName) throws Exception {
        bookName = bookName.replaceAll(" ", "+");
        //return this.convertBooks(this.googleBookApiRequester.getVolumes(bookName));
        VolumeGoogleBooksApiDTO dto = this.googleBookApiRequester.getVolumes(bookName);
        return null;
    }

    private List<Livro> convertBooks(List<VolumeGoogleBooksApiDTO> volumes) throws Exception {
		/*
		 * List<Livro> livros = new ArrayList<>(); volumes.forEach(volume -> { Livro
		 * livro = new Livro(); // livro.getAutor(volume.get)
		 * livro.setDescricao(volume.getDescription());
		 * livro.setDataPublicacao(volume.getPublishedDate());
		 * livro.setId(volume.getId()); livro.setPublicador(volume.getPublisher());
		 * livro.setQtdPaginas(volume.getPageCount());
		 * livro.setTitulo(volume.getTitle());
		 * livro.setAvaliacaoMedia(volume.getAverageRating());
		 * livro.setAvaliacao(volume.getRatingsCount());
		 * livro.setLinkImagem(volume.getImageLink());
		 * 
		 * livros.add(livro); }); return livros;
		 */
    	return null;
    }
}