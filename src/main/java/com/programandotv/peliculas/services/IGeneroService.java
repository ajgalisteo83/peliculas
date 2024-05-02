package com.programandotv.peliculas.services;

import com.programandotv.peliculas.entities.Genero;

public interface IGeneroService {

    public void save(Genero genero);
    public Genero findById(Long id);

}
