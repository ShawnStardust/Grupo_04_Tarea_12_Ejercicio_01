package com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.PaisRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pais;

import java.util.List;

import javax.inject.Inject;

public class PaisUseCase {

    private final PaisRepository repository;

    @Inject
    public PaisUseCase(PaisRepository repository) {
        this.repository = repository;
    }

    // ─────────────────────────────
    // CREATE
    // ─────────────────────────────
    public void insertPais(Pais pais) {
        repository.insert(pais);
    }

    // ─────────────────────────────
    // UPDATE
    // ─────────────────────────────
    public void updatePais(Pais pais) {
        repository.update(pais);
    }

    // ─────────────────────────────
    // DELETE
    // ─────────────────────────────
    public void deletePais(Pais pais) {
        repository.delete(pais);
    }

    // ─────────────────────────────
    // READ
    // ─────────────────────────────
    public List<Pais> getAllPaises() {
        return repository.getAll();
    }

    public Pais getPaisById(int id) {
        return repository.getById(id);
    }

    public List<Pais> searchPaisesByNombre(String nombre) {
        return repository.searchByNombre(nombre);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}