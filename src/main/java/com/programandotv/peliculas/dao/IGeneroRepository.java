package com.programandotv.peliculas.dao;

import com.programandotv.peliculas.entities.Genero;

public interface IGeneroRepository {

    public void save(Genero genero);

    public Genero findById(Long id);

}
