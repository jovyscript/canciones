package com.jovellypino.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jovellypino.modelos.Cancion;
import com.jovellypino.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
	@Autowired
	private RepositorioCanciones repositorioCanciones;
	
	public List<Cancion> obtenerTodasLasCanciones(){
		return repositorioCanciones.findAll();
	}
	
	public Cancion obtenerCancionPorId(Long id) {
		return repositorioCanciones.findById(id).orElse(null);
	}
	
	public Cancion agregarCancion(Cancion cancion) {
		return repositorioCanciones.save(cancion);
	}
	
	public Cancion actualizaCancion(Cancion cancion) {
		return repositorioCanciones.save(cancion);
	}
	
	public void eliminaCancion(Long id) {
	    repositorioCanciones.deleteById(id);
	}
}
