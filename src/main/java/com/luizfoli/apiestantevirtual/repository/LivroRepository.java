package com.luizfoli.apiestantevirtual.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luizfoli.apiestantevirtual.enums.LeituraStatus;
import com.luizfoli.apiestantevirtual.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

	Livro findByGoogleBooksApiId(String googleBooksApiId);
	List<Livro> findByLeituraStatus(LeituraStatus leituraStatus);
	
};