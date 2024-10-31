package com.example.demo.service;


import com.example.demo.dto.PersonajeDto;
import com.example.demo.mappers.PersonajeMapper;
import com.example.demo.repository.PersonajeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {
    private final PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public List<PersonajeDto> getAllPer (){
        return personajeRepository.findAll().stream().map(PersonajeMapper::toDto).collect(Collectors.toList());
    }

    public PersonajeDto getPersonajeById(int id){
        return personajeRepository.findById(id)
                .map(PersonajeMapper::toDto)
                .orElseThrow(() ->new EntityNotFoundException("No encontrado Capitulo con ID: " + id));
    }

    public PersonajeDto createPer(PersonajeDto personajeDto){
        if(personajeDto ==null){
            throw new IllegalArgumentException("El Personaje no puede ser nulo");
        }
        if(personajeRepository.existsById(personajeDto.getId_personaje())){
            throw new IllegalArgumentException("Un Personaje con esa ID ya existe");
        }
        return PersonajeMapper.toDto(personajeRepository.save(PersonajeMapper.toEntity(personajeDto)));
    }


    public PersonajeDto updatePersonaje3 (int id,PersonajeDto personajeDto){
        if (!personajeRepository.existsById(id)){
            throw new EntityNotFoundException("Personaje no encontrado con ID: "+id);
        }
            personajeRepository.save(PersonajeMapper.toEntity(personajeDto));
            return PersonajeMapper.toDto(personajeRepository.getReferenceById(id));
        }



    public void deletePerById(int id){
        if (!personajeRepository.existsById(id)){
            throw new EntityNotFoundException("No encontrado Personaje con ID: "+id);
        }
        personajeRepository.deleteById(id);
    }
}

//    public PersonajeDto updatePersonaje(int id, PersonajeDto personajeDto){
//        return personajeRepository.findById(id)
//                .map(personajeAntiguo -> {
//                    personajeAntiguo.setId_personaje(personajeDto.getId_personaje());
//                    personajeAntiguo.setNombre_personaje(personajeDto.getNombre_personaje());
//
//                    List<Capitulo> capitulos = personajeDto.getCapitulosId().stream()
//                            .map( ids ->{
//                                Capitulo capitulo = new Capitulo();
//                                capitulo.setNumero_capitulo(ids);
//                                return capitulo;
//                            })
//                            .collect(Collectors.toList());
//                    personajeAntiguo.setCapitulos(capitulos);
//
//                    return PersonajeMapper.toDto(personajeRepository.save(personajeAntiguo));
//                })
//                .orElseThrow(() -> new EntityNotFoundException("No encontrado Personaje con ID: " + id));
//    }

//    public PersonajeDto updateNamePersonaje(int id, PersonajeDto personajeDto){
//       var personajeActualizado = personajeRepository.findById(id).map(
//                personajeAntiguo -> {
//                    personajeAntiguo.setNombre_personaje(personajeDto.getNombre_personaje());
//                    return personajeAntiguo;
//                }
//        ).orElseThrow(()-> new IllegalArgumentException("No encontrado Personaje con ID: " +id));
//       return PersonajeMapper.toDto(personajeActualizado);
//    }

//    public PersonajeDto updatePersonaje2(int id, PersonajeDto personajeDto){
//         var personajeActualizado =personajeRepository.findById(id)
//                .map(personajeEncontrado -> {
//                    personajeEncontrado.setNombre_personaje(personajeDto.getNombre_personaje());
//                    List<Capitulo> caps = personajeRepository.findCapituloBySerieId(id);
//                    personajeEncontrado.setCapitulos(caps);
//                    return personajeEncontrado;
//                })
//                .orElseThrow(()-> new EntityNotFoundException("No encontrada Serie con ID "+id));
//        return PersonajeMapper.toDto(personajeActualizado);
//    }
