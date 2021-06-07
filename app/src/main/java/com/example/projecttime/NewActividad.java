package com.example.projecttime;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;

import com.example.projecttime.conexion.Conexion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewActividad extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_actividad);


        /*Conexion cone= new Conexion(this, "agenda",null, 1);
        final int id_trabajo=54;
         db.execSQL("insert into agenda(id_agenda,nombre_trabajo)values ("+id_trabajo+",'NOMBRE_TRABAJO')");




        if(cone!=null){
            System.out.println("Hubo Conexión");
        }*/
    }


}