package com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pasajero;

import java.util.List;

@Dao
public interface PasajeroDao {

    @Insert
    void insert(Pasajero pasajero);

    @Update
    void update(Pasajero pasajero);

    @Delete
    void delete(Pasajero pasajero);

    @Query("SELECT * FROM pasajero")
    List<Pasajero> getAll();

    @Query("SELECT * FROM pasajero WHERE idpasajero = :id")
    Pasajero getById(int id);

    @Query("SELECT * FROM pasajero WHERE email = :email LIMIT 1")
    Pasajero getByEmail(String email);

    @Query("SELECT * FROM pasajero WHERE num_documento = :numDocumento LIMIT 1")
    Pasajero getByDocumento(String numDocumento);

    @Query("SELECT * FROM pasajero WHERE email = :email AND clave = :clave LIMIT 1")
    Pasajero login(String email, String clave);

    @Query("DELETE FROM pasajero")
    void deleteAll();
}