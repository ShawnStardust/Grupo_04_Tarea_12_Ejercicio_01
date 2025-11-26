package com.example.grupo_04_tarea_12_ejercicio_01.data.repository;

import com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao.PaisDao;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.PaisRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pais;

import java.util.List;

import javax.inject.Inject;

public class PaisRepositoryImpl implements PaisRepository {

    private final PaisDao paisDao;

    @Inject
    public PaisRepositoryImpl(PaisDao paisDao) {
        this.paisDao = paisDao;
    }

    @Override
    public void insert(Pais pais) {
        paisDao.insert(pais);
    }

    @Override
    public void update(Pais pais) {
        paisDao.update(pais);
    }

    @Override
    public void delete(Pais pais) {
        paisDao.delete(pais);
    }

    @Override
    public List<Pais> getAll() {
        return paisDao.getAll();
    }

    @Override
    public Pais getById(int id) {
        return paisDao.getById(id);
    }

    @Override
    public List<Pais> searchByNombre(String nombre) {
        return paisDao.searchByNombre(nombre);
    }

    @Override
    public void deleteAll() {
        paisDao.deleteAll();
    }
}