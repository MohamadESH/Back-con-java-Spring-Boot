package com.example.demo.controller;

import com.example.demo.Entity.Capitulo;

import com.example.demo.dto.CapituloDto;
import com.example.demo.service.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CapituloController {
    private final CapituloService capituloService;

    @Autowired
    public CapituloController(CapituloService capituloRepository) {
        this.capituloService = capituloRepository;
    }


    //recibo y envio dtos

    @GetMapping("/capitulos")
    public ResponseEntity<List<CapituloDto>> getAllCapitulosBien(){
        return ResponseEntity.ok(capituloService.getAllCap());
    }

    @GetMapping("/capitulos/{id}")
    public ResponseEntity<CapituloDto> getCapitulById( @PathVariable int id){
        return ResponseEntity.ok(capituloService.getCapituloById(id));
    }

    @PostMapping("/capitulos")
    public ResponseEntity<CapituloDto> createCapitulo(@RequestBody CapituloDto capituloDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(capituloService.createCap(capituloDto));
    }


    @PutMapping("/capitulos/{id}")
    public ResponseEntity<CapituloDto> updateCapitulo(@PathVariable int id, @RequestBody CapituloDto capituloDto) {
        CapituloDto updatedCapitulo = capituloService.updateCapitulo3(id, capituloDto);
        return ResponseEntity.ok(updatedCapitulo);
    }

    @DeleteMapping("/capitulos/{id}")
    public ResponseEntity<Void> deleteCapitulo(@PathVariable int id){
        capituloService.deleteCapitulo(id);
        return ResponseEntity.noContent().build();
    }

}
