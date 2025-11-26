package com.example.grupo_04_tarea_12_ejercicio_01.domain.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "pasajero")
public class Pasajero {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idpasajero")
    private int idPasajero;

    @ColumnInfo(name = "nombres")
    private String nombres;

    @ColumnInfo(name = "apellidos")
    private String apellidos;

    @ColumnInfo(name = "tipo_documento")
    private String tipoDocumento;

    @ColumnInfo(name = "num_documento")
    private String numDocumento;

    @ColumnInfo(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @ColumnInfo(name = "idpais")
    private int idPais;

    @ColumnInfo(name = "telefono")
    private String telefono;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "clave")
    private String clave;

    // Constructor vacío
    public Pasajero() {
    }

    // Constructor completo
    public Pasajero(String nombres, String apellidos, String aMaterno, String tipoDocumento,
                    String numDocumento, Date fechaNacimiento, int idPais, String telefono,
                    String email, String clave) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.idPais = idPais;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
    }

    // Getters y Setters
    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}