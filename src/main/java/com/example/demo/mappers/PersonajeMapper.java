package com.example.demo.mappers;

import com.example.demo.Entity.Capitulo;
import com.example.demo.Entity.Personaje;
import com.example.demo.dto.PersonajeDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonajeMapper {

    public static PersonajeDto toDto(Personaje personaje) {
        if (personaje == null) {
            return null;
        }

        PersonajeDto personajeDto = new PersonajeDto();
        personajeDto.setId_personaje(personaje.getId_personaje());
        personajeDto.setNombre_personaje(personaje.getNombre_personaje());

        // Mapea los IDs de los capítulos
        List<Integer> capitulosIds = personaje.getCapitulos().stream()
                .map(Capitulo::getNumero_capitulo)
                .collect(Collectors.toList());
        personajeDto.setCapitulosId(capitulosIds);

        return personajeDto;
    }

    public static Personaje toEntity(PersonajeDto personajeDto) {
        if (personajeDto == null) {
            return null;
        }

        Personaje personaje = new Personaje();
        personaje.setId_personaje(personajeDto.getId_personaje());
        personaje.setNombre_personaje(personajeDto.getNombre_personaje());

        // Mapea los capítulos usando sus IDs
        List<Capitulo> capitulos = personajeDto.getCapitulosId().stream()
                .map(id -> {
                    Capitulo capitulo = new Capitulo();
                    capitulo.setNumero_capitulo(id);
                    return capitulo;
                })
                .collect(Collectors.toList());
        personaje.setCapitulos(capitulos);

        return personaje;
    }
}
