package com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Aeropuerto;

import java.util.List;

public interface AeropuertoRepository {
    void insert(Aeropuerto aeropuerto);
    void update(Aeropuerto aeropuerto);
    void delete(Aeropuerto aeropuerto);
    List<Aeropuerto> getAll();
    Aeropuerto getById(int id);
    List<Aeropuerto> getByPais(int idPais);
    List<Aeropuerto> searchByNombre(String nombre);
    void deleteAll();
}