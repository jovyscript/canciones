package com.jovellypino.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jovellypino.modelos.Cancion;
import com.jovellypino.servicios.ServicioArtistas;
import com.jovellypino.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicioCanciones;
    
    @Autowired
    private ServicioArtistas servicioArtistas;    
    
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
    	//Envia la lista para el select
    	modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
    	return "agregarCancion";
    }
    
    //Ruta para procesar el formulario y agregar cancion
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
    									BindingResult result, 
    									Model modelo) {//Se agrega Model por si hay error
    	if (result.hasErrors()) {
    		// Si falla, hay que volver a enviar la lista de artistas
    		modelo.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
    		return "agregarCancion";
    	}
    	//Si no hay errores, guarda y redirige a la lista
    	servicioCanciones.agregarCancion(cancion);
    	return"redirect:/canciones";
    }
    //Ruta para editar
    @GetMapping("/canciones/formulario/editar/{id}")
    public String formEditarCancion(@PathVariable("id") Long id, Model modelo) {
    	Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
    	modelo.addAttribute("cancion", cancion);
    	return "editarCancion";
    }
    
    @PostMapping("/canciones/procesa/editar/{id}")
    public String procesaEditarCancion(@PathVariable("id") Long id, 
    									@Valid @ModelAttribute("cancion") Cancion cancion, 
    									BindingResult result) {
    	if(result.hasErrors()) {
    		return "editarCancion";
    	}
    	cancion.setId(id);
    	
    	servicioCanciones.actualizaCancion(cancion);
    	return "redirect:/canciones";
    }
    //Ruta para eliminar canciones
    @DeleteMapping("/canciones/eliminar/{id}")
    public String procesarEliminarCancion(@PathVariable("id") Long id) {
    	servicioCanciones.eliminaCancion(id);
    	return "redirect:/canciones";
    }
    
}