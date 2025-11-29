package com.jovellypino.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jovellypino.modelos.Cancion;
import com.jovellypino.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;
    
    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        List<Cancion> listaCanciones = servicioCanciones.obtenerTodasLasCanciones();
        modelo.addAttribute("canciones", listaCanciones);
        return "canciones";
    }
    
    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long id, Model modelo) {
        Cancion cancionDetalle = servicioCanciones.obtenerCancionPorId(id);
        
        if (cancionDetalle == null) {
            return "redirect:/canciones"; 
        }
        
        modelo.addAttribute("cancion", cancionDetalle);
        return "detalleCancion";
    }
    
    //Ruta para mostrar el formulario(GET)
    @GetMapping("/canciones/formulario/agregar")
    public String formAgregarCancion(Model modelo) {
    	modelo.addAttribute("cancion", new Cancion());
    	return "agregarCancion";
    }
    
    //Ruta para procesar el formulario
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
    									BindingResult result) {
    	if (result.hasErrors()) {
    		return "agregarCancion";
    	}
    	//Si no hay errores, guarda y redirige a la lista
    	servicioCanciones.agregarCancion(cancion);
    	return"redirect:/canciones";
    }
}