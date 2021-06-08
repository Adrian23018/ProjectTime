package com.example.projecttime.conexion;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Actividad  {

    @ColumnInfo(name = "nombre")
    String nombre;

    @ColumnInfo(name = "Selecionado")
    String selecionado;

    public Actividad(String nombre, String selecionado) {
        this.nombre = nombre;
        this.selecionado = selecionado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(String selecionado) {
        this.selecionado = selecionado;
    }
}
