package com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.AeropuertoRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Aeropuerto;

import java.util.List;

import javax.inject.Inject;

public class AeropuertoUseCase {

    private final AeropuertoRepository repository;

    @Inject
    public AeropuertoUseCase(AeropuertoRepository repository) {
        this.repository = repository;
    }

    // ─────────────────────────────
    // CREATE
    // ─────────────────────────────
    public void insertAeropuerto(Aeropuerto aeropuerto) {
        repository.insert(aeropuerto);
    }

    // ─────────────────────────────
    // UPDATE
    // ─────────────────────────────
    public void updateAeropuerto(Aeropuerto aeropuerto) {
        repository.update(aeropuerto);
    }

    // ─────────────────────────────
    // DELETE
    // ─────────────────────────────
    public void deleteAeropuerto(Aeropuerto aeropuerto) {
        repository.delete(aeropuerto);
    }

    // ─────────────────────────────
    // READ
    // ─────────────────────────────
    public List<Aeropuerto> getAllAeropuertos() {
        return repository.getAll();
    }

    public Aeropuerto getAeropuertoById(int id) {
        return repository.getById(id);
    }

    public List<Aeropuerto> getAeropuertosByPais(int idPais) {
        return repository.getByPais(idPais);
    }

    public List<Aeropuerto> searchAeropuertosByNombre(String nombre) {
        return repository.searchByNombre(nombre);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}