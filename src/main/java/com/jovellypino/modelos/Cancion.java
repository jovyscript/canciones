package com.jovellypino.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="canciones")
public class Cancion {
	//Atributos y Mapeo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min= 5, message= "El título debe tener al menos 5 caracteres")
	private String titulo;
	@Size(min= 3, message= "El artista debe tener al menos 3 caracteres")
	private String artista;
	@Size(min= 3, message= "El álbum debe tener al menos 3 caracteres")
	private String album;
	@Size(min= 3, message= "El género debe tener al menos 3 caracteres")
	private String genero;
	@Size (min= 3, message= "El idioma debe tener al menos 3 caracteres")
	private String idioma;
	
	//Config para la fecha
	@Column(updatable=false)
	private Date fechaCreacion;
	private Date fechaActualizacion;
	
	//Constructor vacío
	public Cancion() {
		
	}
	//Constructor con parámetros
	public Cancion(String titulo, String artista, String album, String genero, String idioma) {
		this.titulo = titulo;
		this.artista = artista;
		this.album = album;
		this.genero = genero;
		this.idioma = idioma;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	// 5. Métodos para la gestión automática de fechas
    @PrePersist
    protected void onCreate(){
        this.fechaCreacion = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.fechaActualizacion = new Date();
    }
}
