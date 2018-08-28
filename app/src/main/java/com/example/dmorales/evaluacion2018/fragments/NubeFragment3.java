package com.example.dmorales.evaluacion2018.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dmorales.evaluacion2018.R;
import com.example.dmorales.evaluacion2018.adapters.RegistradoAdapter;
import com.example.dmorales.evaluacion2018.adapters.RegistradoAdapter3;
import com.example.dmorales.evaluacion2018.modelo.Data;
import com.example.dmorales.evaluacion2018.modelo.Registrado;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NubeFragment3 extends Fragment {
    RecyclerView recyclerView;
    Context context;
    ArrayList<Registrado> registrados;
    Spinner spdia;
    String cod_local;
    String sede;
    String aula;
    Button btn_buscar;
    TextView txtNumero;

    public NubeFragment3() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public NubeFragment3(String cod_local, Context context) {
        this.context = context;
        this.cod_local = cod_local;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nube3, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.nube_recycler3);
        txtNumero = (TextView) rootView.findViewById(R.id.nube_txtNumero3);
        spdia = (Spinner) rootView.findViewById(R.id.sp_dia);
        btn_buscar = (Button) rootView.findViewById(R.id.btn_buscar);
        return rootView;




    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        cargaData();
        final RegistradoAdapter3 registradoAdapter3 = new RegistradoAdapter3(registrados,context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(registradoAdapter3);


        btn_buscar. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargaDataAula(spdia.getSelectedItem().toString());
            }
        });

    }

    public void cargaData(){
        registrados = new ArrayList<>();
        try {
            Data data = new Data(context);
            data.open();
            registrados = data.getSedeRegistradosNube(cod_local);
            txtNumero.setText("Total enviados: " + registrados.size());
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargaDataAula(String aula){
        registrados = new ArrayList<>();
        try {
            Data data = new Data(context);
            data.open();
            registrados = data.getSedeRegistradosDia(aula);
            txtNumero.setText("Total enviados: " + registrados.size());
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
