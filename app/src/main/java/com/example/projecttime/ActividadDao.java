package com.example.projecttime;


import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface ActividadDao {
    @Query("SELECT * FROM actividad")

}
