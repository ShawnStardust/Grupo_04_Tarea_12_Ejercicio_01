package com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.PagoRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;

import java.util.List;

import javax.inject.Inject;

public class PagoUseCase {

    private final PagoRepository repository;

    @Inject
    public PagoUseCase(PagoRepository repository) {
        this.repository = repository;
    }

    // ─────────────────────────────
    // CREATE
    // ─────────────────────────────
    public void insertPago(Pago pago) {
        repository.insert(pago);
    }

    // ─────────────────────────────
    // UPDATE
    // ─────────────────────────────
    public void updatePago(Pago pago) {
        repository.update(pago);
    }

    // ─────────────────────────────
    // DELETE
    // ─────────────────────────────
    public void deletePago(Pago pago) {
        repository.delete(pago);
    }

    // ─────────────────────────────
    // READ
    // ─────────────────────────────
    public List<Pago> getAllPagos() {
        return repository.getAll();
    }

    public Pago getPagoById(int id) {
        return repository.getById(id);
    }

    public List<Pago> getPagosByReserva(int idReserva) {
        return repository.getByReserva(idReserva);
    }

    public Pago getPagoByComprobante(String numComprobante) {
        return repository.getByComprobante(numComprobante);
    }

    // ─────────────────────────────
    // BUSINESS LOGIC
    // ─────────────────────────────
    public double getTotalPagadoReserva(int idReserva) {
        return repository.getTotalPagadoReserva(idReserva);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}