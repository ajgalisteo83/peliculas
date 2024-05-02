package com.programandotv.peliculas.dao;

import com.programandotv.peliculas.entities.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Long> {
}
