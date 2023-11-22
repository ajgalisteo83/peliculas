package com.programandotv.peliculas.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "peliculas")
@Data
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(name = "fecha_estreno")
    @Temporal(TemporalType.DATE)
    private Date fechaEstreno;
    private Genero genero;
    private List<Actor> protagonistas;
}
