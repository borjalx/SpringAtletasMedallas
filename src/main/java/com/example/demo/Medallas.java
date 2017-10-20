package com.example.demo;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Entity
public class Medallas {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private enumeracion tipoMedalla;
    private String especialidad;
    private String competicion;

    @ManyToOne
    private Atletas atleta;

    public Medallas() {
    }

    public enum enumeracion{ORO, PLATA, BRONCE, NINGUNO};

    public Medallas(String especialidad, String competicion, Atletas atleta) {
        this.especialidad = especialidad;
        this.competicion = competicion;
        this.atleta = atleta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Atletas getAtleta() {
        return atleta;
    }

    public void setAtleta(Atletas atleta) {
        this.atleta = atleta;
    }

    public enumeracion getTipoMedalla() {
        return tipoMedalla;
    }

    public void setTipoMedalla(enumeracion tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }
}
