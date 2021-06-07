package com.example.projecttime;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {

    private final int[] BOTONESMENU = {R.id.linterna, R.id.login, R.id.nivel};


    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mimenu = inflater.inflate(R.layout.fragment_menu, container,false);
        ImageButton botonmenu;

        for (int i = 0; i < BOTONESMENU.length; i++) {

            botonmenu = (ImageButton) mimenu.findViewById(BOTONESMENU[i]);
            final int queBoton = i;


            botonmenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Activity estaActividad = getActivity();
                    ((ComunicaMenu) estaActividad).menu(queBoton);
                }
            });
        }
        return mimenu;
    }




}