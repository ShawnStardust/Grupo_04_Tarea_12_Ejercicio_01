package com.example.grupo_04_tarea_12_ejercicio_01.domain.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "asiento",
        foreignKeys = {
                @ForeignKey(
                        entity = Vuelo.class,
                        parentColumns = "idvuelo",
                        childColumns = "idvuelo",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Reserva.class,
                        parentColumns = "idreserva",
                        childColumns = "idreserva",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {
                @Index("idvuelo"),
                @Index("idreserva")
        }
)
public class Asiento {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idasiento")
    private int idAsiento;

    @ColumnInfo(name = "idvuelo")
    private int idVuelo;

    @ColumnInfo(name = "idreserva")
    private int idReserva;

    @ColumnInfo(name = "fila")
    private int fila;

    @ColumnInfo(name = "estado")
    private String estado;

    // Constructor vacío
    public Asiento() {
    }

    // Constructor
    public Asiento(int idVuelo, int idReserva, int fila, String estado) {
        this.idVuelo = idVuelo;
        this.idReserva = idReserva;
        this.fila = fila;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}