package com.programandotv.peliculas.dao;

import com.programandotv.peliculas.entities.Genero;

import java.util.List;

public interface IGeneroRepository {

    public void save(Genero genero);

    public Genero findById(Long id);
    public List<Genero> findAll();

}
