package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medallas")
public class MedallasController {

    @Autowired
    MedallasRepository medallasRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medallas crearMedalla(@RequestBody Medallas medallas){
        return medallasRepository.save(medallas);
    }

    @GetMapping
    public List<Medallas> getAllMedallas(){
        return medallasRepository.findAll();
    }

    @PutMapping
    public Medallas updateMedalla(@RequestBody Medallas medallas){
        return medallasRepository.save(medallas);
    }

    @DeleteMapping("/{id}")
    public void deleteMedallaId(@PathVariable Long id){
        Medallas medallas = medallasRepository.findOne(id);
        if(medallas != null){
            medallasRepository.delete(id);
        }
    }
}
