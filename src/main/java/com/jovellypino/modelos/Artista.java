package com.jovellypino.modelos;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="artistas")
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, message="El nombre debe tener al menos 2 letras")
	private String nombre;
	
	@Size(min=2, message="El apellido debe tener al menos 2 letras")
	private String apellido;
	
	@Column(columnDefinition="TEXT")
	private String biografia;
	
	@Column(updatable=false)
	private Date fechaCreacion;
	private Date fechaActualizacion;
	
	// RELACIÓN 1:N (Un Artista -> Muchas Canciones)
    // mappedBy busca el atributo "artista" en la clase Cancion
    @OneToMany(mappedBy="artista", fetch = FetchType.LAZY)
    private List<Cancion> canciones;
    
    //Metodo vacio
    public Artista() {}
    
    public Artista(String nombre, String apellido, String biografia) {
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.biografia = biografia;
    }
    
    //Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
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

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	@PrePersist
    protected void onCreate(){ 
		this.fechaCreacion = new Date(); }
    
    @PreUpdate
    protected void onUpdate(){ 
    	this.fechaActualizacion = new Date(); }
    
}
