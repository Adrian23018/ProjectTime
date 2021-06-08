package com.example.projecttime.conexion;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class Conexion extends SQLiteOpenHelper {


   String query ="CREATE TABLE agenda(nombre TEXT, selecionar TEXT);";

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
        //db.execSQL("DROP TABLE IF EXISTS agenda");
        //onCreate(db);
    }

    public ArrayList llenar_lv()
    {
        ArrayList<String> lista=new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        String q="SELECT * FROM agenda";
        Cursor resgistros=database.rawQuery(q,null);

        if(resgistros.moveToFirst()){
            do {
                lista.add(" "+resgistros.getString(0)+" "+resgistros.getString(1));
            }while(resgistros.moveToNext());
        }
        return lista;
    }
}
