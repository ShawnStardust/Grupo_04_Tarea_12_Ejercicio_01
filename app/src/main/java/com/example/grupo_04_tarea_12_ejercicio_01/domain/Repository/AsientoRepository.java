package com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Asiento;

import java.util.List;

public interface AsientoRepository {
    void insert(Asiento asiento);
    void update(Asiento asiento);
    void delete(Asiento asiento);
    List<Asiento> getAll();
    Asiento getById(int id);
    List<Asiento> getByVuelo(int idVuelo);
    List<Asiento> getByReserva(int idReserva);
    List<Asiento> getByVueloYEstado(int idVuelo, String estado);
    int getAsientosDisponibles(int idVuelo);
    void deleteAll();
}