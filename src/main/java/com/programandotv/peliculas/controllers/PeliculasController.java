package com.programandotv.peliculas.controllers;

import com.programandotv.peliculas.entities.Pelicula;
import com.programandotv.peliculas.services.IActorService;
import com.programandotv.peliculas.services.IGeneroService;
import com.programandotv.peliculas.services.IPeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class PeliculasController {

    private IPeliculaService service;
    private IGeneroService generoService;
    private IActorService actorService;

    public PeliculasController(IPeliculaService service, IGeneroService generoService, IActorService actorService) {
        this.service = service;
        this.generoService = generoService;
        this.actorService = actorService;
    }

    @GetMapping("pelicula")
    public String crear(Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("titulo", "Nueva Película");
        model.addAttribute("generos",  generoService.findAll());
        model.addAttribute("actores",  actorService.findAll());
        model.addAttribute("pelicula", pelicula);
        model.addAttribute(pelicula);
        return "pelicula";
    }

    @GetMapping("pelicula/{id}")
    public String editar(@PathVariable(name = "id") Long id, Model model) {

        Pelicula pelicula = service.findByID(id);
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos",  generoService.findAll());
        model.addAttribute("actores",  actorService.findAll());
        model.addAttribute("titulo", "Editar Película");
        return "pelicula";
    }

    @PostMapping("/pelicula")
    public String guardar(Pelicula pelicula, @ModelAttribute(name = "ids") String ids) {

        List<Long> idsActores = Arrays.stream(ids.split(",")).map(Long::parseLong).toList();

        pelicula.setProtagonistas(actorService.findAllById(idsActores));

        service.save(pelicula);
        return "redirect:home";
    }

    @GetMapping("/"/*, "/home", "/index"*/)
    public String home() {
        return "home";
    }

}
