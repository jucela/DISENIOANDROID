package com.example.dmorales.evaluacion2018.fragments;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmorales.evaluacion2018.NumericKeyBoardTransformationMethod;
import com.example.dmorales.evaluacion2018.R;
import com.example.dmorales.evaluacion2018.modelo.Data;
import com.example.dmorales.evaluacion2018.modelo.Nacional;
import com.example.dmorales.evaluacion2018.modelo.Registrado;

import java.io.IOException;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalidaLocalFragment2 extends Fragment {

    ImageView btnBuscar;
    EditText edtDni;

    CardView cvNoregistrado;
    CardView cvYaregistrado;
    CardView cvRegistro;
    CardView cvError;
    CardView cvAviso;

    TextView txtErrorCargo;
    TextView txtErrorSede;
    TextView txtErrorLocal;

    TextView txtRegistroCargo;
    TextView txtRegistroDni;
    TextView txtRegistroNombres;
    TextView txtRegistroSede;
    TextView txtRegistroLocal;
    TextView txtRegistroAula;
    TextView txtRegistroNbungalow;
    TextView txtRegistroRbungalow;

    TextView txtRegistroDni_yaregistrado;
    TextView txtRegistroNombres_yaregistrado;
    TextView txtRegistroFecha;
    TextView txtRegistroDireccion;
    TextView txtErrorSede_error;
    TextView txtErrorLocal_error;

    String sede;
    Context context;



    public SalidaLocalFragment2() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    public SalidaLocalFragment2(String sede, Context context) {
        this.sede = sede;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_salidalocal, container, false);

        btnBuscar = (ImageView) rootView.findViewById(R.id.salidalocal_btnBuscar);
        edtDni = (EditText) rootView.findViewById(R.id.salidalocal_edtDni);

        cvError = (CardView) rootView.findViewById(R.id.salidalocal_cvError);
        cvNoregistrado = (CardView) rootView.findViewById(R.id.salidalocal_cvNoRegistrado);
        cvRegistro = (CardView) rootView.findViewById(R.id.salidalocal_cvRegistro);
        cvYaregistrado = (CardView) rootView.findViewById(R.id.salidalocal_cvYaRegistrado);
        cvAviso = (CardView) rootView.findViewById(R.id.salidalocal_cvAviso);

//        txtErrorCargo = (TextView) rootView.findViewById(R.id.salidalocal_error_txtCargo);
//        txtErrorLocal = (TextView) rootView.findViewById(R.id.salidalocal_error_txtLocal);
//        txtErrorSede = (TextView) rootView.findViewById(R.id.salidalocal_error_txtSede);

        txtRegistroCargo = (TextView) rootView.findViewById(R.id.salidalocal_txtCargo);
        txtRegistroDni = (TextView) rootView.findViewById(R.id.salidalocal_txtDni);
        txtRegistroNombres = (TextView) rootView.findViewById(R.id.salidalocal_txtNombres);
        txtRegistroSede = (TextView) rootView.findViewById(R.id.salidalocal_txtSede);
        txtRegistroLocal = (TextView) rootView.findViewById(R.id.salidalocal_txtLocal);
        txtRegistroAula = (TextView) rootView.findViewById(R.id.salidalocal_txtAula);
        txtRegistroNbungalow = (TextView) rootView.findViewById(R.id.salidalocal_txtNbungalow);
        txtRegistroRbungalow = (TextView) rootView.findViewById(R.id.salidalocal_txtRbungalow);

        txtRegistroDni_yaregistrado = (TextView) rootView.findViewById(R.id.salidalocal_txtDni_yaregistrado);
        txtRegistroNombres_yaregistrado = (TextView) rootView.findViewById(R.id.salidalocal_txtNombres_yaregitstrado);
        txtRegistroFecha = (TextView) rootView.findViewById(R.id.salidalocal_txtfecha);


        txtErrorLocal_error = (TextView) rootView.findViewById(R.id.salidalocal_txtLocal_error);
        txtErrorSede_error = (TextView) rootView.findViewById(R.id.salidalocal_txtSede_error);
        txtRegistroDireccion = (TextView) rootView.findViewById(R.id.salidalocal_txtdireccion_error);


        edtDni.setTransformationMethod(new NumericKeyBoardTransformationMethod());
//        edtDni.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
//                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    ocultarTeclado(edtDni);
//                    btnBuscar.requestFocus();
//                    return true;
//                }
//                return false;
//            }
//        });
        return rootView;
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtDni.requestFocus();
        //EDITTEXT BUSCAR
        edtDni.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               // edtDni.setText(" ");
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(edtDni.getText().length()==8){
                    ocultarTeclado(edtDni);
                    String dni = edtDni.getText().toString();
                    if(!dni.equals("")){
                        if(!validarDNI(dni)) {
                            cvRegistro.setVisibility(View.GONE);
                            cvYaregistrado.setVisibility(View.GONE);
                            cvError.setVisibility(View.GONE);
                            cvNoregistrado.setVisibility(View.VISIBLE);
                            cvAviso.setVisibility(View.GONE);
                            edtDni.setText("");
                            edtDni.requestFocus();
                        }
                        else{
                            if(validarSEDE(dni))
                            { buscarDNI(dni);
                                edtDni.setText("");
                                edtDni.requestFocus();
                            }
                            else{cvError.setVisibility(View.VISIBLE);
                                cvNoregistrado.setVisibility(View.GONE);
                                cvRegistro.setVisibility(View.GONE);
                                cvYaregistrado.setVisibility(View.GONE);
                                cvAviso.setVisibility(View.GONE);
                                edtDni.setText("");
                                edtDni.requestFocus();
                            }

                        }
                    }
                    else {
                        Toast.makeText(context, "Ingrese DNI ", Toast.LENGTH_SHORT).show();
                        edtDni.setText("");
                        edtDni.requestFocus();}
                }

            }
        });
        //BOTON BUSCAR
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = edtDni.getText().toString();
                if(!dni.equals("")){

                    if(!validarDNI(dni)) {
                        cvRegistro.setVisibility(View.GONE);
                        cvYaregistrado.setVisibility(View.GONE);
                        cvError.setVisibility(View.GONE);
                        cvNoregistrado.setVisibility(View.VISIBLE);
                        cvAviso.setVisibility(View.GONE);
                        edtDni.setText("");
                        edtDni.requestFocus();
                    }
                    else{
                        if(validarSEDE(dni))
                        { buscarDNI(dni);
                            edtDni.setText("");
                            edtDni.requestFocus();
                        }
                        else{cvError.setVisibility(View.VISIBLE);
                            cvNoregistrado.setVisibility(View.GONE);
                            cvRegistro.setVisibility(View.GONE);
                            cvYaregistrado.setVisibility(View.GONE);
                            cvAviso.setVisibility(View.GONE);
                            edtDni.setText("");
                            edtDni.requestFocus();
                        }

                    }
                }
                else {
                    Toast.makeText(context, "Ingrese DNI ", Toast.LENGTH_SHORT).show();
                    edtDni.setText("");
                    edtDni.requestFocus();}
            }
        });
    }

    public boolean buscarDNI(String dni){
        boolean encontrado = false;

        try {
            Data data = new Data(context);
            data.open();
            Registrado registrado = data.getRegistrado(dni);
            data.close();
            if(registrado != null){
                encontrado = true;
                data = new Data(context);
                data.open();
                Registrado registrados = data.getFechaRegistro(registrado.getCodigo());
                if(registrados.getEstado2().equals("1")){
                    cvError.setVisibility(View.GONE);
                    cvNoregistrado.setVisibility(View.GONE);
                    cvYaregistrado.setVisibility(View.VISIBLE);
                    cvRegistro.setVisibility(View.GONE);
                    cvAviso.setVisibility(View.GONE);
                    txtRegistroDni_yaregistrado.setText(registrado.getCodigo());
                    txtRegistroNombres_yaregistrado.setText(registrado.getNombres());
                    txtRegistroFecha.setText(registrado.getAnio2()+"/"+registrado.getMes2()+"/"+registrado.getDia2()+"  -  "+registrado.getHora2()+":"+registrado.getMinuto2());

                }
                else{
                    cvError.setVisibility(View.GONE);
                    cvNoregistrado.setVisibility(View.GONE);
                    cvYaregistrado.setVisibility(View.GONE);
                    cvRegistro.setVisibility(View.VISIBLE);
                    cvAviso.setVisibility(View.GONE);
                    txtRegistroSede.setText(registrado.getSede_region());
                    txtRegistroNombres.setText(registrado.getNombres());
                    txtRegistroDni.setText(registrado.getCodigo());
                    txtRegistroLocal.setText(registrado.getCargo());
                    txtRegistroCargo.setText(registrado.getCargo());
                    txtRegistroAula.setText(registrado.getAula());
                    txtRegistroRbungalow.setText("Responsable de Bungalow :  "+registrado.getResp_bungalow());
                    txtRegistroNbungalow.setText(registrado.getN_bungalow());
                    Calendar calendario = Calendar.getInstance();
                    int yy = calendario.get(Calendar.YEAR);
                    int mm = calendario.get(Calendar.MONTH) + 1;
                    int dd = calendario.get(Calendar.DAY_OF_MONTH);
                    int hora = calendario.get(Calendar.HOUR_OF_DAY);
                    int minuto = calendario.get(Calendar.MINUTE);

                    ContentValues registroactualizado = new ContentValues();
                    registroactualizado.put("dia2", checkDigito(dd));
                    registroactualizado.put("mes2", checkDigito(mm));
                    registroactualizado.put("anio2", checkDigito(yy));
                    registroactualizado.put("hora2", checkDigito(hora));
                    registroactualizado.put("minuto2", checkDigito(minuto));
                    registroactualizado.put("estado2", "1");
                    data.actualizarFechaRegistro(dni, registroactualizado);
                }
                data.close();
            }
            else {
                Data dato = new Data(context);
                dato.open();
                Nacional nacional = dato.getNacional(dni);
                data.close();
                cvError.setVisibility(View.GONE);
                cvNoregistrado.setVisibility(View.GONE);
                cvYaregistrado.setVisibility(View.GONE);
                cvRegistro.setVisibility(View.GONE);
                cvAviso.setVisibility(View.VISIBLE);
                txtErrorSede_error.setText(nacional.getSede_region());
                txtErrorLocal_error.setText(nacional.getSede_region());
                txtRegistroDireccion.setText(nacional.getDireccion());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encontrado;
    }

    public boolean validarDNI(String dni){
        boolean encontrado = false;

        try {
            Data data = new Data(context);
            data.open();
            Nacional nacional = data.getNacional(dni);
            data.close();
            if(nacional != null){
                encontrado = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encontrado;
    }

    public boolean validarSEDE(String dni){
        boolean encontrado = false;

        try {
            Data data = new Data(context);
            data.open();
            Nacional nacional = data.getNacional(dni);
            data.close();
            if(sede.equals(nacional.getSede_region())){
                encontrado = true;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encontrado;
    }


    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
}
