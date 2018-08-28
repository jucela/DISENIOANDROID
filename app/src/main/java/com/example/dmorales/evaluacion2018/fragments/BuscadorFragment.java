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
import com.example.dmorales.evaluacion2018.modelo.Registrado;

import java.io.IOException;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuscadorFragment extends Fragment {

    ImageView btnBuscar;
    EditText edtDni;

    CardView cvNoregistrado;
    CardView cvYaregistrado;
    CardView cvRegistro;
    CardView cvError;

    TextView txtErrorCargo;
    TextView txtErrorSede;
    TextView txtErrorLocal;

    TextView txtRegistroCargo;
    TextView txtRegistroDni;
    TextView txtRegistroNombres;
    TextView txtRegistroSede;
    TextView txtRegistroLocal;
    TextView txtRegistroAula;

    String sede;
    Context context;



    public BuscadorFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    public BuscadorFragment(String sede, Context context) {
        this.sede = sede;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.buscador, container, false);

        btnBuscar = (ImageView) rootView.findViewById(R.id.salida_btnBuscar);
        edtDni = (EditText) rootView.findViewById(R.id.salida_edtDni);

//        cvError = (CardView) rootView.findViewById(R.id.salida_cvError);
//        cvNoregistrado = (CardView) rootView.findViewById(R.id.salida_cvNoRegistrado);
//        cvRegistro = (CardView) rootView.findViewById(R.id.salida_cvsalida);
//        cvYaregistrado = (CardView) rootView.findViewById(R.id.salida_cvYaRegistrado);
//
//        txtErrorCargo = (TextView) rootView.findViewById(R.id.salida_error_txtCargo);
//        txtErrorLocal = (TextView) rootView.findViewById(R.id.salida_error_txtLocal);
//        txtErrorSede = (TextView) rootView.findViewById(R.id.salida_error_txtSede);
//
//        txtRegistroCargo = (TextView) rootView.findViewById(R.id.salida_txtCargo);
//        txtRegistroAula = (TextView) rootView.findViewById(R.id.salida_txtAula);
//        txtRegistroDni = (TextView) rootView.findViewById(R.id.salida_txtDni);
//        txtRegistroLocal = (TextView) rootView.findViewById(R.id.salida_txtLocal);
//        txtRegistroNombres = (TextView) rootView.findViewById(R.id.salida_txtNombres);
//        txtRegistroSede = (TextView) rootView.findViewById(R.id.salida_txtSede);


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
//        //EDITTEXT BUSCAR
        edtDni.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(edtDni.getText().length()==9){
                    edtDni.setText("");
                    edtDni.requestFocus();
//                    ocultarTeclado(edtDni);
//                    btnBuscar.requestFocus();
//                    String dni = edtDni.getText().toString();
//                    if(!dni.equals("")){
//                        if(!buscarDNI(dni)) {
//                            cvRegistro.setVisibility(View.GONE);
//                            cvYaregistrado.setVisibility(View.GONE);
//                            cvError.setVisibility(View.GONE);
//                            cvNoregistrado.setVisibility(View.VISIBLE);
//                        }
//                    }
                }


            }
        });
//        //BOTON BUSCAR
//
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDni.setText("");
                edtDni.requestFocus();
//                ocultarTeclado(edtDni);
//                btnBuscar.requestFocus();
//                String dni = edtDni.getText().toString();
//                if(!dni.equals("")){
//                    if(!buscarDNI(dni)) {
//                        cvRegistro.setVisibility(View.GONE);
//                        cvYaregistrado.setVisibility(View.GONE);
//                        cvError.setVisibility(View.GONE);
//                        cvNoregistrado.setVisibility(View.VISIBLE);
//                    }
//                }
//                edtDni.setText("");
            }
        });
    }

//    public boolean buscarDNI(String dni){
//        boolean encontrado = false;
//
//        try {
//            Data data = new Data(context);
//            data.open();
//            //Nacional nacional = data.getNacional(dni);
//            Registrado registrado = data.getRegistrado(dni);
//            data.close();
//            if(registrado != null){
//                encontrado = true;
//                if(sede.equals(registrado.getSede())){
//                    data = new Data(context);
//                    data.open();
//                    Registrado registrados = data.getFechaRegistro(registrado.getCodigo());
//                    if(registrados != null){
//                        cvError.setVisibility(View.GONE);
//                        cvNoregistrado.setVisibility(View.GONE);
//                        cvYaregistrado.setVisibility(View.VISIBLE);
//                        cvRegistro.setVisibility(View.GONE);
//                    }
//                    if(registrados != null){
//                        cvError.setVisibility(View.GONE);
//                        cvNoregistrado.setVisibility(View.GONE);
//                        cvYaregistrado.setVisibility(View.GONE);
//                        cvRegistro.setVisibility(View.VISIBLE);
//                        txtRegistroSede.setText(registrado.getSede());
//                        txtRegistroNombres.setText(registrado.getNombres());
//                        txtRegistroDni.setText(registrado.getCodigo());
//                        txtRegistroLocal.setText(registrado.getSede());
//                        txtRegistroCargo.setText(registrado.getSede());
//                        txtRegistroAula.setText("Aula " + registrado.getAula());
//                        Calendar calendario = Calendar.getInstance();
//                        int yy = calendario.get(Calendar.YEAR);
//                        int mm = calendario.get(Calendar.MONTH)+1;
//                        int dd = calendario.get(Calendar.DAY_OF_MONTH);
//                        int hora = calendario.get(Calendar.HOUR_OF_DAY);
//                        int minuto = calendario.get(Calendar.MINUTE);
//
//                        ContentValues registroactualizado = new ContentValues();
//                        registroactualizado.put("sdia",checkDigito(dd));
//                        registroactualizado.put("smes",checkDigito(mm));
//                        registroactualizado.put("sanio",checkDigito(yy));
//                        registroactualizado.put("shora",checkDigito(hora));
//                        registroactualizado.put("sminuto",checkDigito(minuto));
//                        registroactualizado.put("estado2","1");
//                        data.actualizarFechaRegistro(dni,registroactualizado);
//                        Toast.makeText(context, "Se Registro Salida", Toast.LENGTH_SHORT).show();
//                    }
//                    data.close();
//                }else{
//                    cvError.setVisibility(View.VISIBLE);
//                    cvNoregistrado.setVisibility(View.GONE);
//                    cvRegistro.setVisibility(View.GONE);
//                    cvYaregistrado.setVisibility(View.GONE);
//                    txtErrorSede.setText(registrado.getSede());
//                    txtErrorLocal.setText(registrado.getNom_local());
//                    txtErrorCargo.setText(registrado.getNom_local());
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return encontrado;
//    }
//
//    public String checkDigito (int number) {
//        return number <= 9 ? "0" + number : String.valueOf(number);
//    }
}
