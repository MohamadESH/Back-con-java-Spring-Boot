package com.example.demo.dto;

import com.example.demo.Entity.Capitulo;
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
public class PersonajeDto {

    @JsonProperty("id_personaje")
    private int id_personaje;

    @JsonProperty("nombre_personaje")
    private String nombre_personaje;

    @JsonProperty("capitulos")
    private List<Integer> capitulosId;



}
