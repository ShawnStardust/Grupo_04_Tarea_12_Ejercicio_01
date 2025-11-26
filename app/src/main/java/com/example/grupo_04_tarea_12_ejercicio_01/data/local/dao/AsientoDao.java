package com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Asiento;

import java.util.List;

@Dao
public interface AsientoDao {

    @Insert
    void insert(Asiento asiento);

    @Update
    void update(Asiento asiento);

    @Delete
    void delete(Asiento asiento);

    @Query("SELECT * FROM asiento")
    List<Asiento> getAll();

    @Query("SELECT * FROM asiento WHERE idasiento = :id")
    Asiento getById(int id);

    @Query("SELECT * FROM asiento WHERE idvuelo = :idVuelo")
    List<Asiento> getByVuelo(int idVuelo);

    @Query("SELECT * FROM asiento WHERE idreserva = :idReserva")
    List<Asiento> getByReserva(int idReserva);

    @Query("SELECT * FROM asiento WHERE idvuelo = :idVuelo AND estado = :estado")
    List<Asiento> getByVueloYEstado(int idVuelo, String estado);

    @Query("SELECT COUNT(*) FROM asiento WHERE idvuelo = :idVuelo AND estado = 'disponible'")
    int getAsientosDisponibles(int idVuelo);

    @Query("DELETE FROM asiento")
    void deleteAll();
}