package com.example.projecttime;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.projecttime.conexion.Conexion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewActividad extends AppCompatActivity {

    SQLiteDatabase db;
    RadioGroup grupoRadio;
    RadioButton productivo,Noproductivo;
    TextView txtRadioSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_actividad);

        grupoRadio =findViewById(R.id.grupoRadio);
        productivo = findViewById(R.id.radioNoProductiva);
        Noproductivo = findViewById(R.id.radioNoProductiva);
        txtRadioSeleccionado = findViewById(R.id.resultado);



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

        /*Conexion cone= new Conexion(this, "agenda",null, 1);
        final int id_trabajo=54;
         db.execSQL("insert into agenda(id_agenda,nombre_trabajo)values ("+id_trabajo+",'NOMBRE_TRABAJO')");




        if(cone!=null){
            System.out.println("Hubo Conexión");
        }*/
    }


}