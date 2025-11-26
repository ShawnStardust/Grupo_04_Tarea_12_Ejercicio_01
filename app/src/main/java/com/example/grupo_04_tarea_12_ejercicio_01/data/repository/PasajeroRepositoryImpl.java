package com.example.grupo_04_tarea_12_ejercicio_01.data.repository;

import com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao.PasajeroDao;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.PasajeroRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pasajero;

import java.util.List;

import jakarta.inject.Inject;

public class PasajeroRepositoryImpl implements PasajeroRepository {

    private final PasajeroDao pasajeroDao;

    @Inject
    public PasajeroRepositoryImpl(PasajeroDao pasajeroDao) {
        this.pasajeroDao = pasajeroDao;
    }

    @Override
    public void insert(Pasajero pasajero) {
        pasajeroDao.insert(pasajero);
    }

    @Override
    public void update(Pasajero pasajero) {
        pasajeroDao.update(pasajero);
    }

    @Override
    public void delete(Pasajero pasajero) {
        pasajeroDao.delete(pasajero);
    }

    @Override
    public List<Pasajero> getAll() {
        return pasajeroDao.getAll();
    }

    @Override
    public Pasajero getById(int id) {
        return pasajeroDao.getById(id);
    }

    @Override
    public Pasajero getByEmail(String email) {
        return pasajeroDao.getByEmail(email);
    }

    @Override
    public Pasajero getByDocumento(String numDocumento) {
        return pasajeroDao.getByDocumento(numDocumento);
    }

    @Override
    public Pasajero login(String email, String clave) {
        return pasajeroDao.login(email, clave);
    }

    @Override
    public void deleteAll() {
        pasajeroDao.deleteAll();
    }
}