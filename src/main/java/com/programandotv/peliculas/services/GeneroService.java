package com.programandotv.peliculas.services;

import com.programandotv.peliculas.dao.IGeneroRepository;
import com.programandotv.peliculas.entities.Genero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService implements IGeneroService {

    IGeneroRepository repository;

    public GeneroService(IGeneroRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Genero genero) {
        repository.save(genero);
    }

    @Override
    public Genero findById(Long id) {
        return repository.findById(id);
    }
}
