package com.example.projecttime.conexion;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;



public class Conexion extends SQLiteOpenHelper {


   final String query ="CREATE TABLE agenda(id_trabajo INT, nombre_trabajo TEXT);";

    public Conexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("--------->>>>"+query);
      db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        System.out.println("-->>> Hola bd");
        db.execSQL("DROP TABLE IF EXISTS agenda");
        onCreate(db);
    }
}
