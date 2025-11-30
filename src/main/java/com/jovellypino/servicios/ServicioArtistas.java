package com.jovellypino.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jovellypino.modelos.Artista;
import com.jovellypino.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {
	@Autowired
	private RepositorioArtistas repoArtistas;
	
	public List<Artista> obtenerTodosLosArtistas(){
		return repoArtistas.findAll();
	}
	
	public Artista obtenerArtistaPorId(Long id) {
		Optional<Artista> artista = repoArtistas.findById(id);
		return artista.orElse(null);
	}
	
	public Artista agregarArtista(Artista artista) {
        return repoArtistas.save(artista);
    }
}
