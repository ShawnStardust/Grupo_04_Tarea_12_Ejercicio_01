package com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.TarifaRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Tarifa;

import java.util.List;

import javax.inject.Inject;

public class TarifaUseCase {

    private final TarifaRepository repository;

    @Inject
    public TarifaUseCase(TarifaRepository repository) {
        this.repository = repository;
    }

    // ─────────────────────────────
    // CREATE
    // ─────────────────────────────
    public void insertTarifa(Tarifa tarifa) {
        repository.insert(tarifa);
    }

    // ─────────────────────────────
    // UPDATE
    // ─────────────────────────────
    public void updateTarifa(Tarifa tarifa) {
        repository.update(tarifa);
    }

    // ─────────────────────────────
    // DELETE
    // ─────────────────────────────
    public void deleteTarifa(Tarifa tarifa) {
        repository.delete(tarifa);
    }

    // ─────────────────────────────
    // READ
    // ─────────────────────────────
    public List<Tarifa> getAllTarifas() {
        return repository.getAll();
    }

    public Tarifa getTarifaById(int id) {
        return repository.getById(id);
    }

    public Tarifa getTarifaByClase(String clase) {
        return repository.getByClase(clase);
    }

    public List<Tarifa> getAllTarifasOrdenadoPorPrecio() {
        return repository.getAllOrdenadoPorPrecio();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}