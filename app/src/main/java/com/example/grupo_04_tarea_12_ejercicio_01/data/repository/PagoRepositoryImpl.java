package com.example.grupo_04_tarea_12_ejercicio_01.data.repository;

import com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao.PagoDao;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.PagoRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;

import java.util.List;

import javax.inject.Inject;

public class PagoRepositoryImpl implements PagoRepository {

    private final PagoDao pagoDao;

    @Inject
    public PagoRepositoryImpl(PagoDao pagoDao) {
        this.pagoDao = pagoDao;
    }

    @Override
    public void insert(Pago pago) {
        pagoDao.insert(pago);
    }

    @Override
    public void update(Pago pago) {
        pagoDao.update(pago);
    }

    @Override
    public void delete(Pago pago) {
        pagoDao.delete(pago);
    }

    @Override
    public List<Pago> getAll() {
        return pagoDao.getAll();
    }

    @Override
    public Pago getById(int id) {
        return pagoDao.getById(id);
    }

    @Override
    public List<Pago> getByReserva(int idReserva) {
        return pagoDao.getByReserva(idReserva);
    }

    @Override
    public Pago getByComprobante(String numComprobante) {
        return pagoDao.getByComprobante(numComprobante);
    }

    @Override
    public double getTotalPagadoReserva(int idReserva) {
        return pagoDao.getTotalPagadoReserva(idReserva);
    }

    @Override
    public void deleteAll() {
        pagoDao.deleteAll();
    }
}