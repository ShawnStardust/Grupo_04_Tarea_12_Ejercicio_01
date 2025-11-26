package com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.PasajeroRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pasajero;

import java.util.List;

import javax.inject.Inject;

public class PasajeroUseCase {

    private final PasajeroRepository repository;

    @Inject
    public PasajeroUseCase(PasajeroRepository repository) {
        this.repository = repository;
    }

    // ─────────────────────────────
    // CREATE
    // ─────────────────────────────
    public void insertPasajero(Pasajero pasajero) {
        repository.insert(pasajero);
    }

    // ─────────────────────────────
    // UPDATE
    // ─────────────────────────────
    public void updatePasajero(Pasajero pasajero) {
        repository.update(pasajero);
    }

    // ─────────────────────────────
    // DELETE
    // ─────────────────────────────
    public void deletePasajero(Pasajero pasajero) {
        repository.delete(pasajero);
    }

    // ─────────────────────────────
    // READ
    // ─────────────────────────────
    public List<Pasajero> getAllPasajeros() {
        return repository.getAll();
    }

    public Pasajero getPasajeroById(int id) {
        return repository.getById(id);
    }

    public Pasajero getPasajeroByEmail(String email) {
        return repository.getByEmail(email);
    }

    public Pasajero getPasajeroByDocumento(String numDocumento) {
        return repository.getByDocumento(numDocumento);
    }

    // ─────────────────────────────
    // BUSINESS LOGIC
    // ─────────────────────────────
    public Pasajero login(String email, String clave) {
        return repository.login(email, clave);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}