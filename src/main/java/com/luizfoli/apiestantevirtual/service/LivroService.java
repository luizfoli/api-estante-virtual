package com.luizfoli.apiestantevirtual.service;

import com.luizfoli.apiestantevirtual.enums.LeituraStatus;
import com.luizfoli.apiestantevirtual.model.Livro;
import com.luizfoli.apiestantevirtual.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.GoogleBooksApi;
import com.luizfoli.apiestantevirtual.adapters.googlebooksapi.dto.VolumeGoogleBooksApiDTO;
import com.luizfoli.apiestantevirtual.dto.LivroDTO;

@Service
public class LivroService {

	private LivroRepository repository;
    private GoogleBooksApi googleBookApiRequester;

    public LivroService(LivroRepository repository, GoogleBooksApi googleBookApiRequester) {
    	this.repository = repository;
        this.googleBookApiRequester = googleBookApiRequester;
    }

    public List<LivroDTO> getBook(String bookName) throws Exception {
        bookName = bookName.replaceAll(" ", "+");
        return this.convertVolumeToBooks(this.googleBookApiRequester.getVolumes(bookName));
    }

    public Boolean postBook(LivroDTO dto) {
		Livro livro = new Livro();
		livro.setAutor(dto.getAutor());
		livro.setAvaliacao(dto.getAvaliacao());
		livro.setAvaliacaoMedia(dto.getAvaliacaoMedia());
		livro.setDataPublicacao(dto.getDataPublicacao());
		livro.setDescricao(dto.getDescricao());
		livro.setGoogleBooksApiId(dto.getGoogleBooksApiId());
		livro.setLinkImagem(dto.getLinkImagem());
		livro.setPublicador(dto.getPublicador());
		livro.setQtdPaginas(dto.getQtdPaginas());
		livro.setTitulo(dto.getTitulo());
		switch (dto.getLeituraStatus()) {
			case 1: livro.setLeituraStatus(LeituraStatus.LENDO);
			case 2: livro.setLeituraStatus(LeituraStatus.QUERO_LER);
			case 3: livro.setLeituraStatus(LeituraStatus.LIDO);
		}

		Livro livroAlreadySaved = this.repository.findByGoogleBooksApiId(dto.getGoogleBooksApiId());
		if(livroAlreadySaved != null) {
			System.out.println("Livro com o id={" + dto.getGoogleBooksApiId() + "} da Books API já foi adicionado");
			return false;
		}

    	Livro livroSaved =  this.repository.save(livro);
    	return (livroSaved != null);
	}

	private List<LivroDTO> convertVolumeToBooks(VolumeGoogleBooksApiDTO dto) {

		List<LivroDTO> books = new ArrayList<>();
		dto.getItems().forEach(item -> {
			LivroDTO book = new LivroDTO();
			book.setGoogleBooksApiId(item.getId());
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