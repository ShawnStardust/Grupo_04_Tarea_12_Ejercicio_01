package com.example.grupo_04_tarea_12_ejercicio_01.domain.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "aerolinea",
        foreignKeys = {
                @ForeignKey(
                        entity = Pais.class,
                        parentColumns = "idpais",
                        childColumns = "idpais",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {@Index("idpais")}
)
public class Aerolinea {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idaerolinea")
    private int idAerolinea;

    @ColumnInfo(name = "nombre")
    private String nombre;

    @ColumnInfo(name = "idpais")
    private int idPais;

    // Constructor vacío
    public Aerolinea() {
    }

    // Constructor
    public Aerolinea(String nombre, int idPais) {
        this.nombre = nombre;
        this.idPais = idPais;
    }

    // Getters y Setters
    public int getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
}