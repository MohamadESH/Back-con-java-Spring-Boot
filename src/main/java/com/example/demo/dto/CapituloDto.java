package com.example.demo.dto;

import com.example.demo.Entity.Personaje;
import com.example.demo.Entity.Serie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CapituloDto {
    @JsonProperty("numero_capitulo")
    private int numero_capitulo;

    @JsonProperty("nombre_capitulo")
    private String nombre_capitulo;

    @JsonProperty("serie")
    private int serieId;

    @JsonProperty("personajes")
    private List<Integer> personajesId;

}
