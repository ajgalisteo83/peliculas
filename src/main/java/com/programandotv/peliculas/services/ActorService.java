package com.programandotv.peliculas.services;

import com.programandotv.peliculas.dao.IActorRepository;
import com.programandotv.peliculas.entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    private IActorRepository repository;

    public ActorService(IActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) repository.findAll();
    }

    @Override
    public List<Actor> findAllById(List<Long> ids) {
        return (List<Actor>) repository.findAllById(ids);
    }
}
