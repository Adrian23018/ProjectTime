package com.example.projecttime;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projecttime.conexion.Conexion;
import com.example.projecttime.models.Usuario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class NewActividad extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    ArrayList<String> lista;
    ArrayAdapter adaptador;


    SQLiteDatabase db;
    RadioGroup grupoRadio;
    RadioButton productivo, Noproductivo;
    EditText nombre1;
    TextView txtRadioSeleccionado, resultados2;
    ListView res;
    Button guardar, mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_actividad);


        nombre1 = findViewById(R.id.ediNombre);
        grupoRadio = findViewById(R.id.grupoRadio);
        productivo = findViewById(R.id.radioProductiva);
        Noproductivo = findViewById(R.id.radioNoProductiva);
        txtRadioSeleccionado = findViewById(R.id.resultado);
        guardar = findViewById(R.id.btnEGuardar);
        resultados2 = findViewById(R.id.respuesta);
        mostrar = findViewById(R.id.btnMostar);
        res = findViewById(R.id.lista);


        grupoRadio.clearCheck();

        grupoRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (productivo.isChecked()) {
                    txtRadioSeleccionado.setTextColor(0xff00ff00);
                    txtRadioSeleccionado.setText(productivo.getText());
                } else if (Noproductivo.isChecked()) {
                    txtRadioSeleccionado.setTextColor(0xff00ff00);
                    txtRadioSeleccionado.setText(Noproductivo.getText());
                }

            }
        });



        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cargar();
              consultar();
            }
        });


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validarCampos();
                GuardarDatos();
            }
        });


    }


    public void GuardarDatos() {
        String nombres = nombre1.getText().toString();
        String selecionar = txtRadioSeleccionado.getText().toString();

        Conexion conexion = new Conexion(this, "ACTIVIDAD", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        if (db != null) {
            System.out.println("Entro");
            ContentValues registroNuevo = new ContentValues();
            registroNuevo.put("nombre", nombres);
            registroNuevo.put("selecionar", selecionar);

            db.insert("agenda", null, registroNuevo);
            Toast.makeText(this, "Datos Almacenados", Toast.LENGTH_SHORT).show();
        }
    }

   public void Cargar() {

        Conexion baseHelper = new Conexion(this, "ACTIVIDAD", null, 1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from agenda", null);
            int cantidad = c.getCount();
            int i = 0;
            String[] arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do{
                    String linea = c.getInt(0)+" "+ c.getString(1)+" "+ c.getString(2);
                    arreglo[i] = linea;
                    i++;

                }while (c.moveToNext());
            }
            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
            // ListView lista = (ListView) findViewById(R.id.lista);
            res.setAdapter(adapter);
        }
    }

    public void consultar(){
        Conexion conexion=new Conexion(this,"ACTIVIDAD",null,1);
        lista=conexion.llenar_lv();
        adaptador=new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        res.setAdapter(adaptador);

    }



    }





