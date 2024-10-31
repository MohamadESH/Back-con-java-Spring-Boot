package com.example.demo.repository;

import com.example.demo.Entity.Capitulo;
import com.example.demo.Entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie,Integer> {

//    @Query ("SELECT c FROM Capitulo c WHERE c.serie.id_serie = :idserie ")
//    List<Capitulo> findCapitulosBySerieId(@Param("idserie") int idserie);
}
