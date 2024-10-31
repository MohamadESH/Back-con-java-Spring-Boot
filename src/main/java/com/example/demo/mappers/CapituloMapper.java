package com.example.demo.mappers;

import com.example.demo.Entity.Capitulo;
import com.example.demo.Entity.Personaje;
import com.example.demo.Entity.Serie;
import com.example.demo.dto.CapituloDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CapituloMapper {


    public static CapituloDto toDto(Capitulo capitulo) {
        if (capitulo == null) {
            return null;
        }

        CapituloDto capituloDto = new CapituloDto();
        capituloDto.setNumero_capitulo(capitulo.getNumero_capitulo());
        capituloDto.setNombre_capitulo(capitulo.getNombre_capitulo());
        capituloDto.setSerieId(capitulo.getSerie().getId_serie());
        List<Integer> personajesIds = capitulo.getPersonajes().stream()
                .map(Personaje::getId_personaje)
                .collect(Collectors.toList());
        capituloDto.setPersonajesId(personajesIds);

        return capituloDto;
    }

    public static Capitulo toEntity(CapituloDto capituloDto) {
        if (capituloDto == null) {
            return null;
        }

        Capitulo capitulo = new Capitulo();
        capitulo.setNumero_capitulo(capituloDto.getNumero_capitulo());
        capitulo.setNombre_capitulo(capituloDto.getNombre_capitulo());
        Serie serie = new Serie();
        serie.setId_serie(capituloDto.getSerieId());
        capitulo.setSerie(serie);
        List<Personaje> personajes = capituloDto.getPersonajesId().stream()
                .map(id -> {
                    //personajeRepository.findById(id).orElse(null).filter(objects::noNull).collect(Collectors.toList) : Listof();
                    Personaje personaje = new Personaje();
                    personaje.setId_personaje(id);
                    return personaje;
                })
                .collect(Collectors.toList());
        capitulo.setPersonajes(personajes);

        return capitulo;
    }



}
