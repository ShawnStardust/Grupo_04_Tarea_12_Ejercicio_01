package com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Tarifa;

import java.util.List;

@Dao
public interface TarifaDao {

    @Insert
    void insert(Tarifa tarifa);

    @Update
    void update(Tarifa tarifa);

    @Delete
    void delete(Tarifa tarifa);

    @Query("SELECT * FROM tarifa")
    List<Tarifa> getAll();

    @Query("SELECT * FROM tarifa WHERE idtarifa = :id")
    Tarifa getById(int id);

    @Query("SELECT * FROM tarifa WHERE clase = :clase LIMIT 1")
    Tarifa getByClase(String clase);

    @Query("SELECT * FROM tarifa ORDER BY precio ASC")
    List<Tarifa> getAllOrdenadoPorPrecio();

    @Query("DELETE FROM tarifa")
    void deleteAll();
}