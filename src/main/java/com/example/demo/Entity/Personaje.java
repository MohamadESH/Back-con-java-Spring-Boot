package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name ="PERSONAJE")
public class Personaje {

    @Id
    @Column(name = "id_personaje")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_personaje;

    @Column(name = "nombre_personaje")
    private String nombre_personaje;

    //N:M
    @ManyToMany( fetch = FetchType.EAGER) //cascade = CascadeType.ALL
    @JoinTable(
            name= "CAPITULO_PERSONAJES",
            joinColumns = @JoinColumn(name = "id_personaje"),
            inverseJoinColumns = @JoinColumn(name="numero_capitulo")
    )
    private List<Capitulo> capitulos;

}
