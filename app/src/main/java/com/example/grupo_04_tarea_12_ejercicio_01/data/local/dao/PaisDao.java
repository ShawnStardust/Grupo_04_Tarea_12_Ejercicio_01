package com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pais;

import java.util.List;

@Dao
public interface PaisDao {

    @Insert
    void insert(Pais pais);

    @Update
    void update(Pais pais);

    @Delete
    void delete(Pais pais);

    @Query("SELECT * FROM pais")
    List<Pais> getAll();

    @Query("SELECT * FROM pais WHERE idpais = :id")
    Pais getById(int id);

    @Query("SELECT * FROM pais WHERE nombre LIKE :nombre || '%'")
    List<Pais> searchByNombre(String nombre);

    @Query("DELETE FROM pais")
    void deleteAll();
}
