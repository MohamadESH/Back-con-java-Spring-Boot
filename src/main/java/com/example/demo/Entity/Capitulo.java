package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name ="CAPITULO")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Capitulo {

    @Id
    @Column (name = "numero_capitulo")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int numero_capitulo;

    @Column (name = "nombre_capitulo")
    private String nombre_capitulo;

    //1:N Varios capitulos pertenecen a una serie
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_serie")              //se crea columna id_serie (FK de tabla Serie)
    private Serie serie;

    //N:M
    @ManyToMany (mappedBy = "capitulos",fetch = FetchType.EAGER)
    private List<Personaje> personajes;

}