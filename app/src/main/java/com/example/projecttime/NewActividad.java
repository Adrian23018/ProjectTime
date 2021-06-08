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


public class NewActividad extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;


    SQLiteDatabase db;
    RadioGroup grupoRadio;
    RadioButton productivo,Noproductivo;
    EditText nombre1;
    TextView txtRadioSeleccionado,resultados2;
    ListView res;
    Button guardar,mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_actividad);


        nombre1=findViewById(R.id.ediNombre);
        grupoRadio =findViewById(R.id.grupoRadio);
        productivo = findViewById(R.id.radioProductiva);
        Noproductivo = findViewById(R.id.radioNoProductiva);
        txtRadioSeleccionado = findViewById(R.id.resultado);
        guardar=findViewById(R.id.btnEGuardar);
        resultados2=findViewById(R.id.respuesta);
        mostrar=findViewById(R.id.btnMostar);
        res=findViewById(R.id.lista);
        //iniciarFirebase();

        grupoRadio.clearCheck();

        grupoRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) 				{
                if(productivo.isChecked())
                {
                    txtRadioSeleccionado.setTextColor(0xff00ff00);
                    txtRadioSeleccionado.setText(productivo.getText());
                }
                else if(Noproductivo.isChecked())
                {
                    txtRadioSeleccionado.setTextColor(0xff00ff00);
                    txtRadioSeleccionado.setText(Noproductivo.getText());
                }

            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Cargar();
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

    private void iniciarFirebase() {
        // Write a message to the database

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Usuarios");
        Toast.makeText(getApplicationContext(),"Dentro a direbase",Toast.LENGTH_SHORT).show();

        myRef.setValue("hola");
    }

    public void validarCampos(){
        String nombre = nombre1.getText().toString();
        String selecionado = txtRadioSeleccionado.getText().toString();

        if( nombre.equals("") || selecionado.equals("")){

            Toast.makeText(getApplicationContext(),"PORFAVOR LLENAR TODOS LOS CAMPOS",Toast.LENGTH_SHORT).show();

        }else{

            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setSelecionado(selecionado);

            myRef.child("usuario").child(usuario.getNombre()).setValue(usuario);
            Toast.makeText(getApplicationContext(),"Se registro correctamente: "+ nombre,Toast.LENGTH_SHORT).show();


        }
    }


    public void GuardarDatos(){
        String nombres = nombre1.getText().toString();
        String selecionar = txtRadioSeleccionado.getText().toString();

        Conexion conexion= new Conexion(this, "ACTIVIDADES",null,1);
        SQLiteDatabase db =conexion.getWritableDatabase();
        if(db!=null){
            System.out.println("Entro");
            ContentValues registroNuevo=new ContentValues();
            registroNuevo.put("nombre", nombres);
            registroNuevo.put("selecionar", selecionar);

            db.insert("agenda", null, registroNuevo);
            Toast.makeText(this, "Datos Almacenados",Toast.LENGTH_SHORT).show();
        }

        /*long i = db.insert("Datos", null, registronuevo);

   if(i == -1){
        Log.e(TAG, "Inserción de datos no se realizo.");
   }else{
        Log.i(TAG, "Inserción de datos se realizo con exito.");
   }*/

    }

    public void Cargar() {

        Conexion baseHelper = new Conexion(this, "ACTIVIDDADES", null, 1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db != null) {
            Cursor c = db.rawQuery("select * from agenda", null);
            int cantidad = c.getCount();
            int i = 0;
            String[] arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do{
                    String linea = c.getInt(0)+" "+ c.getString(1)+" "+ c.getString(3)+" "+ c.getString(4);
                    arreglo[i] = linea;
                    i++;

                }while (c.moveToNext());
            }
            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
           // ListView lista = (ListView) findViewById(R.id.lista);
            res.setAdapter(adapter);
        }
    }
}



