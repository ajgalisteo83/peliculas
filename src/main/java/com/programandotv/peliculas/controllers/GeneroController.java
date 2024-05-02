package com.programandotv.peliculas.controllers;

import com.programandotv.peliculas.entities.Genero;
import com.programandotv.peliculas.services.IGeneroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GeneroController {

    private IGeneroService service;

    public GeneroController(IGeneroService service) {
        this.service = service;
    }

    @PostMapping("genero")
    public ResponseEntity<Long> guardar(@RequestParam String nombre) {
        Genero genero = new Genero();
        genero.setNombre(nombre);

        service.save(genero);
        return new ResponseEntity<>(genero.getId(), HttpStatus.OK);
    }

    @GetMapping("genero/{id}")
    public ResponseEntity<String> buscarPorId(@PathVariable(name = "id") Long id) {
        Optional<String> generoNombreOptional = Optional.ofNullable(service.findById(id).getNombre());
        return generoNombreOptional.map(name -> new ResponseEntity<>(name, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("", HttpStatus.NOT_FOUND));
    }
}
