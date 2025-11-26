package com.example.grupo_04_tarea_12_ejercicio_01.data.repository;


import com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao.ReservaDao;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.ReservaRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;

import java.util.List;

import javax.inject.Inject;

public class ReservaRepositoryImpl implements ReservaRepository {

    private final ReservaDao reservaDao;

    @Inject
    public ReservaRepositoryImpl(ReservaDao reservaDao) {
        this.reservaDao = reservaDao;
    }

    @Override
    public void insert(Reserva reserva) {
        reservaDao.insert(reserva);
    }

    @Override
    public void update(Reserva reserva) {
        reservaDao.update(reserva);
    }

    @Override
    public void delete(Reserva reserva) {
        reservaDao.delete(reserva);
    }

    @Override
    public List<Reserva> getAll() {
        return reservaDao.getAll();
    }

    @Override
    public Reserva getById(int id) {
        return reservaDao.getById(id);
    }

    @Override
    public List<Reserva> getByPasajero(int idPasajero) {
        return reservaDao.getByPasajero(idPasajero);
    }

    @Override
    public List<Reserva> getByVuelo(int idVuelo) {
        return reservaDao.getByVuelo(idVuelo);
    }

    @Override
    public List<Reserva> getReservasPasajeroOrdenadas(int idPasajero) {
        return reservaDao.getReservasPasajeroOrdenadas(idPasajero);
    }

    @Override
    public void deleteAll() {
        reservaDao.deleteAll();
    }
}