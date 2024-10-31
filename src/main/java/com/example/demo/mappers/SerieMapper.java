package com.example.demo.mappers;

import com.example.demo.Entity.Capitulo;
import com.example.demo.Entity.Serie;
import com.example.demo.dto.SerieDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SerieMapper {

    public static SerieDto toDto(Serie serie) {
        if (serie == null) {
            return null;
        }

        SerieDto serieDto = new SerieDto();
        serieDto.setId_serie(serie.getId_serie());
        serieDto.setNombre_serie(serie.getNombre_serie());

        // Mapea los IDs de los capítulos
        List<Integer> capitulosIds = serie.getCapitulos().stream()
                .map(Capitulo::getNumero_capitulo)
                .collect(Collectors.toList());
        serieDto.setCapitulosId(capitulosIds);

        return serieDto;
    }

    public static Serie toEntity(SerieDto serieDto) {
        if (serieDto == null) {
            return null;
        }

        Serie serie = new Serie();
        serie.setId_serie(serieDto.getId_serie());
        serie.setNombre_serie(serieDto.getNombre_serie());

        // Mapea los capítulos usando sus IDs
        List<Capitulo> capitulos = serieDto.getCapitulosId().stream()
                .map(id -> {
                    Capitulo capitulo = new Capitulo();
                    capitulo.setNumero_capitulo(id);
                    return capitulo;
                })
                .collect(Collectors.toList());
        serie.setCapitulos(capitulos);

        return serie;
    }
}
