package com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;

import java.util.List;

@Dao
public interface ReservaDao {

    @Insert
    void insert(Reserva reserva);

    @Update
    void update(Reserva reserva);

    @Delete
    void delete(Reserva reserva);

    @Query("SELECT * FROM reserva")
    List<Reserva> getAll();

    @Query("SELECT * FROM reserva WHERE idreserva = :id")
    Reserva getById(int id);

    @Query("SELECT * FROM reserva WHERE idpasajero = :idPasajero")
    List<Reserva> getByPasajero(int idPasajero);

    @Query("SELECT * FROM reserva WHERE idvuelo = :idVuelo")
    List<Reserva> getByVuelo(int idVuelo);

    @Query("SELECT * FROM reserva WHERE idpasajero = :idPasajero ORDER BY fecha DESC")
    List<Reserva> getReservasPasajeroOrdenadas(int idPasajero);

    @Query("DELETE FROM reserva")
    void deleteAll();
}