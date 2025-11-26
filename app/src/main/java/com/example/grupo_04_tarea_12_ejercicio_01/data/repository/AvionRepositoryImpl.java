package com.example.grupo_04_tarea_12_ejercicio_01.data.repository;

import com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao.AvionDao;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.AvionRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Avion;

import java.util.List;

import javax.inject.Inject;

public class AvionRepositoryImpl implements AvionRepository {

    private final AvionDao avionDao;

    @Inject
    public AvionRepositoryImpl(AvionDao avionDao) {
        this.avionDao = avionDao;
    }

    @Override
    public void insert(Avion avion) {
        avionDao.insert(avion);
    }

    @Override
    public void update(Avion avion) {
        avionDao.update(avion);
    }

    @Override
    public void delete(Avion avion) {
        avionDao.delete(avion);
    }

    @Override
    public List<Avion> getAll() {
        return avionDao.getAll();
    }

    @Override
    public Avion getById(int id) {
        return avionDao.getById(id);
    }

    @Override
    public List<Avion> getByAerolinea(int idAerolinea) {
        return avionDao.getByAerolinea(idAerolinea);
    }

    @Override
    public List<Avion> getByTipo(String tipoAvion) {
        return avionDao.getByTipo(tipoAvion);
    }

    @Override
    public List<Avion> getByCapacidadMinima(int capacidadMinima) {
        return avionDao.getByCapacidadMinima(capacidadMinima);
    }

    @Override
    public void deleteAll() {
        avionDao.deleteAll();
    }
}