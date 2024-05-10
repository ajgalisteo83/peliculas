package com.programandotv.peliculas.services;

import com.programandotv.peliculas.entities.Actor;

import java.util.List;

public interface IActorService {
    public List<Actor> findAll();
    public List<Actor> findAllById(List<Long> ids);
}
