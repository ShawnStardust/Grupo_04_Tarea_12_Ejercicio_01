package com.example.grupo_04_tarea_12_ejercicio_01.data.repository;

import com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao.AsientoDao;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.AsientoRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Asiento;

import java.util.List;

import javax.inject.Inject;

public class AsientoRepositoryImpl implements AsientoRepository {

    private final AsientoDao asientoDao;

    @Inject
    public AsientoRepositoryImpl(AsientoDao asientoDao) {
        this.asientoDao = asientoDao;
    }

    @Override
    public void insert(Asiento asiento) {
        asientoDao.insert(asiento);
    }

    @Override
    public void update(Asiento asiento) {
        asientoDao.update(asiento);
    }

    @Override
    public void delete(Asiento asiento) {
        asientoDao.delete(asiento);
    }

    @Override
    public List<Asiento> getAll() {
        return asientoDao.getAll();
    }

    @Override
    public Asiento getById(int id) {
        return asientoDao.getById(id);
    }

    @Override
    public List<Asiento> getByVuelo(int idVuelo) {
        return asientoDao.getByVuelo(idVuelo);
    }

    @Override
    public List<Asiento> getByReserva(int idReserva) {
        return asientoDao.getByReserva(idReserva);
    }

    @Override
    public List<Asiento> getByVueloYEstado(int idVuelo, String estado) {
        return asientoDao.getByVueloYEstado(idVuelo, estado);
    }

    @Override
    public int getAsientosDisponibles(int idVuelo) {
        return asientoDao.getAsientosDisponibles(idVuelo);
    }

    @Override
    public void deleteAll() {
        asientoDao.deleteAll();
    }
}