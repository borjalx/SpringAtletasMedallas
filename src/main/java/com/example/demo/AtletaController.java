package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    AtletaRepository atletaRepository;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atletas crearAtleta(@RequestBody Atletas atleta){
        return atletaRepository.save(atleta);
    };

    @GetMapping
    public List<Atletas> getAtletas(){
        return atletaRepository.findAll();
    }

    @GetMapping("/nacionalidad/{nacionalidad}")
    public List<Atletas> getByNacionalidad(@PathVariable String nacionalidad){
        return atletaRepository.findByNacionalidadEquals(nacionalidad);
    }

    @GetMapping("/fechaN/{fecha}")
    public List<Atletas> getByFechaNacimiento(@PathVariable @DateTimeFormat(pattern = "dd-mm-yyyy") LocalDate fecha){
        return atletaRepository.findByFechaNacimientoBefore(fecha);
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
    private LocalDate date;

    @GetMapping("/GroupByNacionalidad")
    public Map<String, List<Atletas>> getAthleteGroupByNacionality(){
        return atletaRepository.findAll().parallelStream().collect(groupingBy(Atletas::getNacionalidad));
    }

    @GetMapping("/groupByMedalla")
    public Map<Medallas.enumeracion, List<Atletas>> getAtletasGroupByMedallas(){
        return atletaRepository.findAll().parallelStream().collect(groupingBy(atletas -> {
            if(Atletas.getMedallas().stream().anyMatch(medallas -> medallas.getTipoMedalla() == Medallas.enumeracion.ORO)){
                return Medallas.enumeracion.ORO;
            }else if(Atletas.getMedallas().stream().anyMatch(medallas -> medallas.getTipoMedalla() == Medallas.enumeracion.PLATA)){
                return Medallas.enumeracion.PLATA;
            }else if(Atletas.getMedallas().stream().anyMatch(medallas -> medallas.getTipoMedalla() == Medallas.enumeracion.BRONCE)){
                return Medallas.enumeracion.BRONCE;
            }else {
                return Medallas.enumeracion.NINGUNO;
            }

        }));
    }
}
