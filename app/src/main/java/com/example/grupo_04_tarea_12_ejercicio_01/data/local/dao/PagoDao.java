package com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;

import java.util.List;

@Dao
public interface PagoDao {

    @Insert
    void insert(Pago pago);

    @Update
    void update(Pago pago);

    @Delete
    void delete(Pago pago);

    @Query("SELECT * FROM pago")
    List<Pago> getAll();

    @Query("SELECT * FROM pago WHERE idpago = :id")
    Pago getById(int id);

    @Query("SELECT * FROM pago WHERE idreserva = :idReserva")
    List<Pago> getByReserva(int idReserva);

    @Query("SELECT * FROM pago WHERE num_comprobante = :numComprobante LIMIT 1")
    Pago getByComprobante(String numComprobante);

    @Query("SELECT SUM(monto) FROM pago WHERE idreserva = :idReserva")
    double getTotalPagadoReserva(int idReserva);

    @Query("DELETE FROM pago")
    void deleteAll();
}