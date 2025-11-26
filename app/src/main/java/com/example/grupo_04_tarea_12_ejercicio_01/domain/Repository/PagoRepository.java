package com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;

import java.util.List;

public interface PagoRepository {
    void insert(Pago pago);
    void update(Pago pago);
    void delete(Pago pago);
    List<Pago> getAll();
    Pago getById(int id);
    List<Pago> getByReserva(int idReserva);
    Pago getByComprobante(String numComprobante);
    double getTotalPagadoReserva(int idReserva);
    void deleteAll();
}