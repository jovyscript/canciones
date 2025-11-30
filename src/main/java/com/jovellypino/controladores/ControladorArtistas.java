package com.jovellypino.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jovellypino.modelos.Artista;
import com.jovellypino.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
	@Autowired
	private ServicioArtistas servicioArtistas;
	
	@GetMapping("/artistas")
	public String desplegarArtistas(Model modelo) {
		modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
		return "artistas";
	}
		
	@GetMapping("/artistas/detalle/{id}")
    public String desplegarDetalleArtista(@PathVariable("id") Long id, Model model) {
        
        // 1. Buscamos al artista en la base de datos
        Artista artistaEncontrado = servicioArtistas.obtenerArtistaPorId(id);
        
        // 2. Lo ponemos en el modelo para que el JSP lo pueda leer
        model.addAttribute("artista", artistaEncontrado);
        
        // 3. Retornamos el nombre del archivo JSP (detalleArtista.jsp)
        return "detalleArtista";
    }
	
	// Ruta formulario agregar (Ojo: sin ID en la URL porque es nuevo)
    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(Model model) {
        model.addAttribute("artista", new Artista());
        return "agregarArtista";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, BindingResult result) {
        if (result.hasErrors()) {
            return "agregarArtista";
        }
        servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }
}
