package com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Vuelo;

import java.util.List;

@Dao
public interface VueloDao {

    @Insert
    void insert(Vuelo vuelo);

    @Update
    void update(Vuelo vuelo);

    @Delete
    void delete(Vuelo vuelo);

    @Query("SELECT * FROM vuelo")
    List<Vuelo> getAll();

    @Query("SELECT * FROM vuelo WHERE idvuelo = :id")
    Vuelo getById(int id);

    @Query("SELECT * FROM vuelo WHERE idaeropuerto_origen = :idOrigen")
    List<Vuelo> getByOrigen(int idOrigen);

    @Query("SELECT * FROM vuelo WHERE idaeropuerto_destino = :idDestino")
    List<Vuelo> getByDestino(int idDestino);

    @Query("SELECT * FROM vuelo WHERE idaeropuerto_origen = :idOrigen AND idaeropuerto_destino = :idDestino")
    List<Vuelo> getByOrigenDestino(int idOrigen, int idDestino);

    @Query("SELECT * FROM vuelo WHERE idavion = :idAvion")
    List<Vuelo> getByAvion(int idAvion);

    @Query("DELETE FROM vuelo")
    void deleteAll();
}