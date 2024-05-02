package com.programandotv.peliculas.services;

import com.programandotv.peliculas.dao.IPeliculaRepository;
import com.programandotv.peliculas.entities.Pelicula;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {


    private IPeliculaRepository repository;

    public PeliculaService(IPeliculaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Pelicula pelicula) {
        repository.save(pelicula);
    }

    @Override
    public Pelicula findByID(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Pelicula> findAll() {
        return (List<Pelicula>) repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
