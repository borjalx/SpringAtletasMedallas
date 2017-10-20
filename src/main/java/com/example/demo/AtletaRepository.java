package com.example.demo;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AtletaRepository extends JpaRepository<Atletas, Long> {


    List<Atletas> findByNacionalidadEquals(String nacionalidad);

    List<Atletas> findByFechaNacimientoBefore(LocalDate fecha);
    /*
    @Query("select atletas from Atletas group by nacionalidad")
    List<Atletas> groupByNacionalidad();
    */
}

