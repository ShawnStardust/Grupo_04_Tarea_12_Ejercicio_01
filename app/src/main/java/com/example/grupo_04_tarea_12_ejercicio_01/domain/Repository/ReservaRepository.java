package com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;

import java.util.List;

public interface ReservaRepository {
    void insert(Reserva reserva);
    void update(Reserva reserva);
    void delete(Reserva reserva);
    List<Reserva> getAll();
    Reserva getById(int id);
    List<Reserva> getByPasajero(int idPasajero);
    List<Reserva> getByVuelo(int idVuelo);
    List<Reserva> getReservasPasajeroOrdenadas(int idPasajero);
    void deleteAll();
}