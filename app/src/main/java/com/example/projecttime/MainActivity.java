package com.example.projecttime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button BtnNew,btnEstadistica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnNew = findViewById(R.id.btnNewActivity);
            btnEstadistica= findViewById(R.id.btnEstadistica);


        BtnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir=new Intent(MainActivity.this, NewActividad.class);
                startActivity(ir);
            }
        });

       btnEstadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir=new Intent(MainActivity.this, GraficaBarras.class);
                startActivity(ir);
            }
        });
    }
}