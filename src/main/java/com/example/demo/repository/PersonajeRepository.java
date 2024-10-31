package com.example.demo.repository;

import com.example.demo.Entity.Capitulo;
import com.example.demo.Entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository  extends  JpaRepository<Personaje,Integer>{
//    @Query ("SELECT c FROM Capitulo c  WHERE c.personaje.id_personaje = idpersonaje")
//    List<Capitulo> findCapituloBySerieId(@Param("id_personaje")int idpersonaje);
}