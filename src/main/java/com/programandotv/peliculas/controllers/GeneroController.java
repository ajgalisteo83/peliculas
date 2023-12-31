package com.programandotv.peliculas.controllers;

import com.programandotv.peliculas.dao.IGeneroRepository;
import com.programandotv.peliculas.entities.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GeneroController {

    @Autowired
    IGeneroRepository generoRepository;

    @PostMapping("genero")
    public ResponseEntity<Long> guardar(@RequestParam String nombre) {
        Genero genero = new Genero();
        genero.setNombre(nombre);

        generoRepository.save(genero);
        return new ResponseEntity<>(genero.getId(), HttpStatus.OK);
    }

    @GetMapping("genero/{id}")
    public ResponseEntity<String> buscarPorId(@PathVariable(name = "id") Long id) {
        Optional<String> generoNombreOptional = Optional.ofNullable(generoRepository.findById(id).getNombre());
        return generoNombreOptional.map(name -> new ResponseEntity<>(name, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("", HttpStatus.NOT_FOUND));
    }
}
