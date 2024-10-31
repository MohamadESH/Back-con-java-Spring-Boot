package com.example.demo.service;

import com.example.demo.dto.SerieDto;
import com.example.demo.mappers.SerieMapper;
import com.example.demo.repository.CapituloRepository;
import com.example.demo.repository.SerieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {
    private final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository, CapituloRepository capituloRepository) {
        this.serieRepository = serieRepository;
    }

    public List<SerieDto> getAllSerie (){
        return serieRepository.findAll().stream().map(SerieMapper::toDto).collect(Collectors.toList());
    }

    public SerieDto getSerieById (int id){
        return serieRepository.findById(id)
                .map(SerieMapper::toDto)
                .orElseThrow(()-> new EntityNotFoundException("No encontrado Serie con ID: " +id));
    }

    public SerieDto createSerie(SerieDto serieDto){
        if(serieDto == null){
            throw new IllegalArgumentException("La Serie no puede ser nulo");
        }
        if(serieRepository.existsById(serieDto.getId_serie())){
            throw new IllegalArgumentException("Una Serie con esa ID ya existe");
        }
        return SerieMapper.toDto(serieRepository.save(SerieMapper.toEntity(serieDto)));             // al dto recibido lo convierto en entity -> lo guardo con .save() -> y luego lo devuelvo en formato DTO (otra vez lo convierto/mapeo en DTO)
    }

    public SerieDto updateSerie3(int id , SerieDto serieDto){
        if(!serieRepository.existsById(id)){
            throw new EntityNotFoundException("Serie no encontrada con ID: "+id);
        }

        serieRepository.save(SerieMapper.toEntity(serieDto));
        return SerieMapper.toDto(serieRepository.getReferenceById(id));
    }


    public void deleteSerieById(int id){
        if (!serieRepository.existsById(id)){
            throw new EntityNotFoundException("No encontrada Serie con ID: " + id);
        }
        serieRepository.deleteById(id);
    }

}

//    public SerieDto updateSerie(int id,SerieDto serieDto){
//        return serieRepository.findById(id)
//                .map(serieEncontrada ->{
//                    serieEncontrada.setId_serie(serieDto.getId_serie());
//                    serieEncontrada.setNombre_serie(serieDto.getNombre_serie());
//
//                    List<Capitulo> capitulos = serieDto.getCapitulosId().stream()
//                            .map(ids -> {
//                                Capitulo capitulo = new Capitulo();
//                                capitulo.setNumero_capitulo(ids);
//                                return capitulo;
//                            })
//                            .collect(Collectors.toList());
//                    serieEncontrada.setCapitulos(capitulos);
//                    return SerieMapper.toDto(serieRepository.save(serieEncontrada));
//                })
//                .orElseThrow( () -> new EntityNotFoundException("No encontrada Serie con ID: " + id));
//    }

//                      Funcion incompleta (deberia usar la funcion personalziada del repository)
//
//
//    public SerieDto updateNameSerie(int id , SerieDto serieDto){
//        var serieActualizada = serieRepository.findById(id)
//                .map(serieEncontrada ->{
//                    serieEncontrada.setNombre_serie(serieDto.getNombre_serie());
//                    return serieEncontrada;
//                }
//        ).orElseThrow(()-> new IllegalArgumentException("No encontrada Serie con ID: "+id));
//        return SerieMapper.toDto(serieActualizada);
//    }