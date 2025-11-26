package com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Avion;

import java.util.List;

@Dao
public interface AvionDao {

    @Insert
    void insert(Avion avion);

    @Update
    void update(Avion avion);

    @Delete
    void delete(Avion avion);

    @Query("SELECT * FROM avion")
    List<Avion> getAll();

    @Query("SELECT * FROM avion WHERE idavion = :id")
    Avion getById(int id);

    @Query("SELECT * FROM avion WHERE idaerolinea = :idAerolinea")
    List<Avion> getByAerolinea(int idAerolinea);

    @Query("SELECT * FROM avion WHERE tipo_avion = :tipoAvion")
    List<Avion> getByTipo(String tipoAvion);

    @Query("SELECT * FROM avion WHERE capacidad >= :capacidadMinima")
    List<Avion> getByCapacidadMinima(int capacidadMinima);

    @Query("DELETE FROM avion")
    void deleteAll();
}