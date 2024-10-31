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
public class SerieDto {

    @JsonProperty("id_serie")
    private int id_serie;

    @JsonProperty("nombre_serie")
    private String nombre_serie;

    @JsonProperty("capitulos")
    private List<Integer> capitulosId;

}
