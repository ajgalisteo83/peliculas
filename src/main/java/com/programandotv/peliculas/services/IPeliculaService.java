package com.programandotv.peliculas.services;

import com.programandotv.peliculas.entities.Pelicula;
import java.util.List;

public interface IPeliculaService {
    public void save(Pelicula pelicula);
    public Pelicula findByID(Long id);
    public List<Pelicula> findAll();
    public void delete(Long id);

}
