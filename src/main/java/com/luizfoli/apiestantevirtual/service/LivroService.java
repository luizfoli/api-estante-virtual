package com.luizfoli.apiestantevirtual.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.GoogleBooksApi;
import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.dto.VolumeGoogleBooksApiDTO;
import com.luizfoli.apiestantevirtual.dto.LivroDTO;

@Service
public class LivroService {

    private GoogleBooksApi googleBookApiRequester;

    public LivroService(GoogleBooksApi googleBookApiRequester) {
        this.googleBookApiRequester = googleBookApiRequester;
    }

    public List<LivroDTO> getBook(String bookName) throws Exception {
        bookName = bookName.replaceAll(" ", "+");
        return this.convertBooks(this.googleBookApiRequester.getVolumes(bookName));
    }

    private List<LivroDTO> convertBooks(VolumeGoogleBooksApiDTO dto) {
    	
    	List<LivroDTO> books = new ArrayList<>();
    	dto.getItems().forEach(item -> {
    		LivroDTO book = new LivroDTO();
    		book.setId(item.getId()); 
    		book.setDescricao(item.getVolumeInfo().getDescription());
    		book.setDataPublicacao(item.getVolumeInfo().getPublishedDate());
    		book.setPublicador(item.getVolumeInfo().getPublisher());
    		book.setQtdPaginas(item.getVolumeInfo().getPageCount());
    		book.setTitulo(item.getVolumeInfo().getTitle());
    		book.setAvaliacaoMedia(item.getVolumeInfo().getAverageRating());
    		book.setAvaliacao(item.getVolumeInfo().getRatingsCount());
    		
    		if(item.getVolumeInfo().getImageLinks() != null) {
    			book.setLinkImagem(item.getVolumeInfo().getImageLinks().getThumbnail());    			
    		}
    		
    		books.add(book);
    	});
    	
    	return books;
    }
}