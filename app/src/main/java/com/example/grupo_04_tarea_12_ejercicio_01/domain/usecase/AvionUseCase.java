package com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.AvionRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Avion;

import java.util.List;

import javax.inject.Inject;

public class AvionUseCase {

    private final AvionRepository repository;

    @Inject
    public AvionUseCase(AvionRepository repository) {
        this.repository = repository;
    }

    // ─────────────────────────────
    // CREATE
    // ─────────────────────────────
    public void insertAvion(Avion avion) {
        repository.insert(avion);
    }

    // ─────────────────────────────
    // UPDATE
    // ─────────────────────────────
    public void updateAvion(Avion avion) {
        repository.update(avion);
    }

    // ─────────────────────────────
    // DELETE
    // ─────────────────────────────
    public void deleteAvion(Avion avion) {
        repository.delete(avion);
    }

    // ─────────────────────────────
    // READ
    // ─────────────────────────────
    public List<Avion> getAllAviones() {
        return repository.getAll();
    }

    public Avion getAvionById(int id) {
        return repository.getById(id);
    }

    public List<Avion> getAvionesByAerolinea(int idAerolinea) {
        return repository.getByAerolinea(idAerolinea);
    }

    public List<Avion> getAvionesByTipo(String tipoAvion) {
        return repository.getByTipo(tipoAvion);
    }

    public List<Avion> getAvionesByCapacidadMinima(int capacidadMinima) {
        return repository.getByCapacidadMinima(capacidadMinima);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}