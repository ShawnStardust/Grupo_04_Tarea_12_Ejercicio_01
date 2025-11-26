package com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Avion;

import java.util.List;

public interface AvionRepository {
    void insert(Avion avion);
    void update(Avion avion);
    void delete(Avion avion);
    List<Avion> getAll();
    Avion getById(int id);
    List<Avion> getByAerolinea(int idAerolinea);
    List<Avion> getByTipo(String tipoAvion);
    List<Avion> getByCapacidadMinima(int capacidadMinima);
    void deleteAll();
}