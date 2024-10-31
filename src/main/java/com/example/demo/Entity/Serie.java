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
@Table(name ="SERIE")
public class Serie {

    @Id
    @Column(name = "id_serie")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_serie;

    @Column(name = "nombre_serie")
    private String nombre_serie;

    // 1:N (Una serie tiene muchos capítulos)
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Capitulo> capitulos;


}
