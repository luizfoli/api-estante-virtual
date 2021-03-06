package com.luizfoli.apiestantevirtual.service;

import com.luizfoli.apiestantevirtual.dto.StatusLeituraDTO;
import com.luizfoli.apiestantevirtual.enums.LeituraStatus;
import com.luizfoli.apiestantevirtual.model.Livro;
import com.luizfoli.apiestantevirtual.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<LivroDTO> getBooksByLeituraStatus(int leituraStatus) {
		List<LivroDTO> dtos = new ArrayList<>();
    	List<Livro> livros = this.repository.findByLeituraStatus(this.readStatusByInt(leituraStatus));
    	livros.forEach(livro -> {
    		LivroDTO dto = new LivroDTO();
    		dto.setId(livro.getId());
    		dto.setAutor(livro.getAutor());
    		dto.setAvaliacao(livro.getAvaliacao());
    		dto.setAvaliacaoMedia(livro.getAvaliacaoMedia());
    		dto.setDataPublicacao(livro.getDataPublicacao());
    		dto.setDescricao(livro.getDescricao());
    		dto.setGoogleBooksApiId(livro.getGoogleBooksApiId());
    		dto.setLeituraStatus(livro.getLeituraStatus());
    		dto.setLinkImagem(livro.getLinkImagem());
    		dtos.add(dto);
		});
    	return dtos;
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
		livro.setLeituraStatus(readStatusByInt(dto.getLeituraStatus()));

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

	public Boolean putStatusLeitura(StatusLeituraDTO dto) {
    	Optional<Livro> livroIsAdded = this.repository.findById(dto.getIdLivro());

    	if(livroIsAdded.isEmpty()) {
			System.out.println("/status-leitura - Livro com id={" + dto.getIdLivro() + "} não encontrado");
			return false;
		}

		Livro livro = livroIsAdded.get();
		livro.setLeituraStatus(this.readStatusByInt(dto.getStatusLeitura()));
		repository.save(livro);
		return true;
	}

	private LeituraStatus readStatusByInt(int leituraStatus) {
		switch (leituraStatus) {
			case 0: return LeituraStatus.QUERO_LER;
			case 1: return LeituraStatus.LENDO;
			case 2: return LeituraStatus.LIDO;
		}

		return null;
	}

}