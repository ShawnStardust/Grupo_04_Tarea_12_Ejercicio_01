package com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Aeropuerto;

import java.util.List;

@Dao
public interface AeropuertoDao {

    @Insert
    void insert(Aeropuerto aeropuerto);

    @Update
    void update(Aeropuerto aeropuerto);

    @Delete
    void delete(Aeropuerto aeropuerto);

    @Query("SELECT * FROM aeropuerto")
    List<Aeropuerto> getAll();

    @Query("SELECT * FROM aeropuerto WHERE idaeropuerto = :id")
    Aeropuerto getById(int id);

    @Query("SELECT * FROM aeropuerto WHERE idpais = :idPais")
    List<Aeropuerto> getByPais(int idPais);

    @Query("SELECT * FROM aeropuerto WHERE nombre LIKE :nombre || '%'")
    List<Aeropuerto> searchByNombre(String nombre);

    @Query("DELETE FROM aeropuerto")
    void deleteAll();
}