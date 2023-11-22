package com.programandotv.peliculas.dao;

import com.programandotv.peliculas.entities.Genero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class GeneroRepositoryImpl implements IGeneroRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public void save(Genero genero) {
        entityManager.persist(genero);
    }

    @Override
    @Transactional
    public Genero findById(Long id) {
        return entityManager.find(Genero.class, id);
    }
}
