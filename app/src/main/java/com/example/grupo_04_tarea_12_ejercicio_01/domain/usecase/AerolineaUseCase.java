package com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.AerolineaRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Aerolinea;

import java.util.List;

import javax.inject.Inject;

public class AerolineaUseCase {

    private final AerolineaRepository repository;

    @Inject
    public AerolineaUseCase(AerolineaRepository repository) {
        this.repository = repository;
    }

    // ─────────────────────────────
    // CREATE
    // ─────────────────────────────
    public void insertAerolinea(Aerolinea aerolinea) {
        repository.insert(aerolinea);
    }

    // ─────────────────────────────
    // UPDATE
    // ─────────────────────────────
    public void updateAerolinea(Aerolinea aerolinea) {
        repository.update(aerolinea);
    }

    // ─────────────────────────────
    // DELETE
    // ─────────────────────────────
    public void deleteAerolinea(Aerolinea aerolinea) {
        repository.delete(aerolinea);
    }

    // ─────────────────────────────
    // READ
    // ─────────────────────────────
    public List<Aerolinea> getAllAerolineas() {
        return repository.getAll();
    }

    public Aerolinea getAerolineaById(int id) {
        return repository.getById(id);
    }

    public List<Aerolinea> getAerolineasByPais(int idPais) {
        return repository.getByPais(idPais);
    }

    public List<Aerolinea> searchAerolineasByNombre(String nombre) {
        return repository.searchByNombre(nombre);
    }
}
