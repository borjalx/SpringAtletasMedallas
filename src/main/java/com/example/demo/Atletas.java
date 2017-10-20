package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Atletas {

    @Id
    @GeneratedValue

    private Long id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    @OneToMany(mappedBy = "atleta", cascade = CascadeType.ALL)
    @JsonIgnore
    private static Set<Medallas> medallas = new HashSet<>();

    public static Set<Medallas> getMedallas(){
        return medallas;
    }
    public void setMedallas(Set<Medallas> medallas){
        this.medallas = medallas;
    }

    public Atletas(){

    }

    public Atletas(String nombre, String apellidos, String nacionalidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }


    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atletas atletas = (Atletas) o;

        if (id != null ? !id.equals(atletas.id) : atletas.id != null) return false;
        if (nombre != null ? !nombre.equals(atletas.nombre) : atletas.nombre != null) return false;
        if (apellidos != null ? !apellidos.equals(atletas.apellidos) : atletas.apellidos != null) return false;
        if (nacionalidad != null ? !nacionalidad.equals(atletas.nacionalidad) : atletas.nacionalidad != null)
            return false;
        return fechaNacimiento != null ? fechaNacimiento.equals(atletas.fechaNacimiento) : atletas.fechaNacimiento == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (nacionalidad != null ? nacionalidad.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Atletas{" +
                "id =>" + id +
                " / nombre='" + nombre + '\'' +
                " / apellidos='" + apellidos + '\'' +
                " / nacionalidad='" + nacionalidad + '\'' +
                " / fechaNacimiento=" + fechaNacimiento + " *** " +
                System.lineSeparator();
    }
}
