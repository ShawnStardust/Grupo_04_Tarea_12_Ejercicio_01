package com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.ReservaRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;

import java.util.List;

import javax.inject.Inject;

public class ReservaUseCase {

    private final ReservaRepository repository;

    @Inject
    public ReservaUseCase(ReservaRepository repository) {
        this.repository = repository;
    }

    // ─────────────────────────────
    // CREATE
    // ─────────────────────────────
    public void insertReserva(Reserva reserva) {
        repository.insert(reserva);
    }

    // ─────────────────────────────
    // UPDATE
    // ─────────────────────────────
    public void updateReserva(Reserva reserva) {
        repository.update(reserva);
    }

    // ─────────────────────────────
    // DELETE
    // ─────────────────────────────
    public void deleteReserva(Reserva reserva) {
        repository.delete(reserva);
    }

    // ─────────────────────────────
    // READ
    // ─────────────────────────────
    public List<Reserva> getAllReservas() {
        return repository.getAll();
    }

    public Reserva getReservaById(int id) {
        return repository.getById(id);
    }

    public List<Reserva> getReservasByPasajero(int idPasajero) {
        return repository.getByPasajero(idPasajero);
    }

    public List<Reserva> getReservasByVuelo(int idVuelo) {
        return repository.getByVuelo(idVuelo);
    }

    public List<Reserva> getReservasPasajeroOrdenadas(int idPasajero) {
        return repository.getReservasPasajeroOrdenadas(idPasajero);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}