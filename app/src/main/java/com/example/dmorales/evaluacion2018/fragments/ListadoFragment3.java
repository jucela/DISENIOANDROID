package com.example.dmorales.evaluacion2018.fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmorales.evaluacion2018.R;
import com.example.dmorales.evaluacion2018.adapters.RegistradoAdapter;
import com.example.dmorales.evaluacion2018.adapters.RegistradoAdapter3;
import com.example.dmorales.evaluacion2018.modelo.Data;
import com.example.dmorales.evaluacion2018.modelo.Registrado;
import com.example.dmorales.evaluacion2018.modelo.SQLConstantes;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment3 extends Fragment {
    RecyclerView recyclerView;
    Context context;
    ArrayList<Registrado> registrados;
    ArrayList<Registrado> agregados;
    ArrayList<Registrado> agregados2;
    ArrayList<Registrado> agregados3;
    ArrayList<Registrado> agregados4;
    String sede;
    Data data;
    FloatingActionButton fabUpLoad;
    TextView txtNumero;
    boolean b = false;

    public ListadoFragment3() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    public ListadoFragment3(String sede, Context context) {
        this.context = context;
        this.sede = sede;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //CABEZERA
        View rootView = inflater.inflate(R.layout.fragment_listado3, container, false);
        //DETALLE
        recyclerView = (RecyclerView) rootView.findViewById(R.id.listado_recycler3);
        fabUpLoad = (FloatingActionButton) rootView.findViewById(R.id.listado_btnUpload3);
        txtNumero = (TextView) rootView.findViewById(R.id.listado_txtNumero3);
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

        fabUpLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = false;
                agregados = new ArrayList<>();
                agregados2 = new ArrayList<>();
                try {
                    data = new Data(context);
                    data.open();
                    agregados = data.getAllRegistradosTemporal();
                    agregados2 = data.getAllRegistradosTemporal2();
                    data.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(agregados.size() > 0){
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    //if(registrados)

                    for (final Registrado registrado : agregados){

                        Map<String,Object> valor = new HashMap<>();
                        valor.put("_id",registrado.get_id());
                        valor.put("nombres",registrado.getNombres());
                        valor.put("nivel",registrado.getNivel());
                        valor.put("dia1",registrado.getDia1());
                        valor.put("mesl",registrado.getMes1());
                        valor.put("aniol",registrado.getAnio1());
                        valor.put("horal",registrado.getHora1());
                        valor.put("minutol",registrado.getMinuto1());


                        if(registrado.getSubido1()==0) {
                            registrado.setSubido1(1);
                            String fecha = registrado.getDia1() + "-" + registrado.getMes1() + "-" + registrado.getAnio1();
                            String coleccion = "ASISTENCIA_NIYII";
                            final String c = registrado.getCodigo();
                            db.collection(coleccion).document(registrado.get_id()).set(valor)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d("FIRESTORE", "DocumentSnapshot successfully written!");
                                            if (!b) {
                                                //
                                                Toast.makeText(context, agregados.size() + "  Registros de Entrada en la Nube", Toast.LENGTH_SHORT).show();
                                                b = true;
                                            }
                                            try {
                                                data = new Data(context);
                                                data.open();
                                                ContentValues contentValues = new ContentValues();
                                                contentValues.put(SQLConstantes.fecha_de_registro_subido1, 1);
                                                data.actualizarFechaRegistro(c, contentValues);
                                                cargaData();
                                                registradoAdapter3.notifyDataSetChanged();
                                                data.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w("FIRESTORE", "Error writing document", e);
                                        }
                                    });
                        }//end if
                        else {Toast.makeText(context, " Error al cargar subidos", Toast.LENGTH_SHORT).show();}
                    }//end for
                }else if(agregados2.size() > 0){
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    //if(registrados)
                    for (final Registrado registrado : agregados2){
                        Map<String,Object> valor = new HashMap<>();
                        valor.put("_id",registrado.get_id());
                        valor.put("nombres",registrado.getNombres());
                        valor.put("nivel",registrado.getNivel());
                        valor.put("dia1",registrado.getDia1());
                        valor.put("mesl",registrado.getMes1());
                        valor.put("aniol",registrado.getAnio1());
                        valor.put("horal",registrado.getHora1());
                        valor.put("minutol",registrado.getMinuto1());

                        if(registrado.getSubido2()==0) {
                            registrado.setSubido2(1);
                            String fecha = registrado.getDia2() + "-" + registrado.getMes2() + "-" + registrado.getAnio2();
                            String coleccion = "ASISTENCIA_NIYII";
                            final String c = registrado.getCodigo();
                            //Toast.makeText(context, "Subiendo...", Toast.LENGTH_SHORT).show();
                            db.collection(coleccion).document(registrado.get_id()).set(valor)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d("FIRESTORE", "DocumentSnapshot successfully written!");
                                            if (!b) {
                                                Toast.makeText(context, agregados2.size() + "  Registros de Salida en la Nube", Toast.LENGTH_SHORT).show();
                                                b = true;
                                            }
                                            try {
                                                data = new Data(context);
                                                data.open();
                                                ContentValues contentValues = new ContentValues();
                                                contentValues.put(SQLConstantes.fecha_de_registro_subido2, 1);
                                                data.actualizarFechaRegistro(c, contentValues);
                                                cargaData();
                                                registradoAdapter3.notifyDataSetChanged();
                                                data.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w("FIRESTORE", "Error writing document", e);
                                        }
                                    });
                        }//end if
                        else {Toast.makeText(context, " Error al cargar subidos", Toast.LENGTH_SHORT).show();}
                    }//end for
                }else {
                    Toast.makeText(context, "No hay registros nuevos para subir", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void cargaData(){
        registrados = new ArrayList<>();
        try {
            Data data = new Data(context);
            data.open();
            registrados = data.getAllRegistrados(sede);
            txtNumero.setText("Total registros: " + registrados.size());
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
