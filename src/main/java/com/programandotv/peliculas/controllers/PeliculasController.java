package com.programandotv.peliculas.controllers;

import com.programandotv.peliculas.entities.Pelicula;
import com.programandotv.peliculas.services.IGeneroService;
import com.programandotv.peliculas.services.IPeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeliculasController {

    private IPeliculaService service;
    private IGeneroService generoService;

    public PeliculasController(IPeliculaService service, IGeneroService generoService) {
        this.service = service;
        this.generoService = generoService;
    }

    @GetMapping("pelicula")
    public String crear(Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("titulo", "Nueva Película");
        model.addAttribute("generos",  generoService.findAll());
        model.addAttribute("pelicula", pelicula);
        model.addAttribute(pelicula);
        return "pelicula";
    }

    @GetMapping("pelicula/{id}")
    public String editar(@PathVariable(name = "id") Long id, Model model) {

        Pelicula pelicula = service.findByID(id);
        model.addAttribute("pelicula", pelicula);
        return "pelicula";
    }

    @PostMapping("/pelicula")
    public String guardar(Pelicula pelicula) {
        service.save(pelicula);
        return "redirect:home";
    }

    @GetMapping("/"/*, "/home", "/index"*/)
    public String home() {
        return "home";
    }

}
