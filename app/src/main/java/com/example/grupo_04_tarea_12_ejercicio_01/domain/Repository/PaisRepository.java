package com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pais;

import java.util.List;

public interface PaisRepository {
    void insert(Pais pais);
    void update(Pais pais);
    void delete(Pais pais);
    List<Pais> getAll();
    Pais getById(int id);
    List<Pais> searchByNombre(String nombre);
    void deleteAll();
}