package com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.AsientoRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Asiento;

import java.util.List;

import javax.inject.Inject;

public class AsientoUseCase {

    private final AsientoRepository repository;

    @Inject
    public AsientoUseCase(AsientoRepository repository) {
        this.repository = repository;
    }

    // ─────────────────────────────
    // CREATE
    // ─────────────────────────────
    public void insertAsiento(Asiento asiento) {
        repository.insert(asiento);
    }

    // ─────────────────────────────
    // UPDATE
    // ─────────────────────────────
    public void updateAsiento(Asiento asiento) {
        repository.update(asiento);
    }

    // ─────────────────────────────
    // DELETE
    // ─────────────────────────────
    public void deleteAsiento(Asiento asiento) {
        repository.delete(asiento);
    }

    // ─────────────────────────────
    // READ
    // ─────────────────────────────
    public List<Asiento> getAllAsientos() {
        return repository.getAll();
    }

    public Asiento getAsientoById(int id) {
        return repository.getById(id);
    }

    public List<Asiento> getAsientosByVuelo(int idVuelo) {
        return repository.getByVuelo(idVuelo);
    }

    public List<Asiento> getAsientosByReserva(int idReserva) {
        return repository.getByReserva(idReserva);
    }

    public List<Asiento> getAsientosByVueloYEstado(int idVuelo, String estado) {
        return repository.getByVueloYEstado(idVuelo, estado);
    }

    // ─────────────────────────────
    // BUSINESS LOGIC
    // ─────────────────────────────
    public int getAsientosDisponibles(int idVuelo) {
        return repository.getAsientosDisponibles(idVuelo);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}