package com.programandotv.peliculas.controllers;

import com.programandotv.peliculas.entities.Pelicula;
import com.programandotv.peliculas.services.IPeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PeliculasController {

    private IPeliculaService service;

    public PeliculasController(IPeliculaService service) {
        this.service = service;
    }

    @GetMapping("pelicula")
    public String crear(Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("titulo", "Nueva Película");
        model.addAttribute(pelicula);
        return "pelicula";
    }

    @GetMapping("pelicula/{id}")
    public ResponseEntity<String> editar(@PathVariable(name = "id") Long id, Model model) {

        String nombrePelicula = service.findByID(id).getNombre();
        return new ResponseEntity<>(nombrePelicula, HttpStatus.OK);
    }

}
