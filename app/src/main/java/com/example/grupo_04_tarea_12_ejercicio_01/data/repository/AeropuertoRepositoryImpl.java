package com.example.grupo_04_tarea_12_ejercicio_01.data.repository;

import com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao.AeropuertoDao;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.AeropuertoRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Aeropuerto;

import java.util.List;

import javax.inject.Inject;

public class AeropuertoRepositoryImpl implements AeropuertoRepository {

    private final AeropuertoDao aeropuertoDao;

    @Inject
    public AeropuertoRepositoryImpl(AeropuertoDao aeropuertoDao) {
        this.aeropuertoDao = aeropuertoDao;
    }

    @Override
    public void insert(Aeropuerto aeropuerto) {
        aeropuertoDao.insert(aeropuerto);
    }

    @Override
    public void update(Aeropuerto aeropuerto) {
        aeropuertoDao.update(aeropuerto);
    }

    @Override
    public void delete(Aeropuerto aeropuerto) {
        aeropuertoDao.delete(aeropuerto);
    }

    @Override
    public List<Aeropuerto> getAll() {
        return aeropuertoDao.getAll();
    }

    @Override
    public Aeropuerto getById(int id) {
        return aeropuertoDao.getById(id);
    }

    @Override
    public List<Aeropuerto> getByPais(int idPais) {
        return aeropuertoDao.getByPais(idPais);
    }

    @Override
    public List<Aeropuerto> searchByNombre(String nombre) {
        return aeropuertoDao.searchByNombre(nombre);
    }

    @Override
    public void deleteAll() {
        aeropuertoDao.deleteAll();
    }
}