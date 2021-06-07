package com.example.projecttime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraficaBarras extends AppCompatActivity {

    BarChart graficaBarras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica_barras);

        graficaBarras=findViewById(R.id.graficaBarras);

        List<BarEntry> entradas=new ArrayList<>();

        entradas.add(new BarEntry(0f, 2));
        entradas.add(new BarEntry(1f, 4));
        entradas.add(new BarEntry(2f, 6));
        entradas.add(new BarEntry(3f, 8));
        entradas.add(new BarEntry(4f, 3));
        entradas.add(new BarEntry(5f, 1));

        BarDataSet datos =new BarDataSet(entradas, "GRAFICAS DE BARRAS");

        BarData data=new BarData(datos);

        datos.setColors(ColorTemplate.COLORFUL_COLORS);

        data.setBarWidth(0.9f);

        graficaBarras.setData(data);

        graficaBarras.setFitBars(true);
        graficaBarras.invalidate();



    }
}