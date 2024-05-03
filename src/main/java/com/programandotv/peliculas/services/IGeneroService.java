package com.programandotv.peliculas.services;

import com.programandotv.peliculas.entities.Genero;

import java.util.List;

public interface IGeneroService {

    public void save(Genero genero);
    public Genero findById(Long id);
    public List<Genero> findAll();

}
