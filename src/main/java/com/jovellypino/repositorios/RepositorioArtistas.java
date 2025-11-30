package com.jovellypino.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jovellypino.modelos.Artista;

public interface RepositorioArtistas extends CrudRepository<Artista, Long> {
	List<Artista> findAll();	
}
