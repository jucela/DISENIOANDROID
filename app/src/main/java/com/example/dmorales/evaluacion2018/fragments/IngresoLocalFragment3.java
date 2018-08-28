package com.example.dmorales.evaluacion2018.fragments;


import android.annotation.SuppressLint;
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
public class IngresoLocalFragment3 extends Fragment {

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
    TextView txtRegistroNbungalow;
    TextView txtRegistroRbungalow;

    TextView txtRegistroDni_yaregistrado;
    TextView txtRegistroNombres_yaregistrado;
    TextView txtRegistroFecha;
    TextView txtRegistroDireccion;
    TextView txtErrorSede_error;
    TextView txtErrorLocal_error;

    String sede;
    String cod_local;
    Context context;



    public IngresoLocalFragment3() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    public IngresoLocalFragment3(String cod_local, Context context) {
        this.cod_local = cod_local;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ingresolocal, container, false);
        btnBuscar = (ImageView) rootView.findViewById(R.id.ingresolocal_btnBuscar);
        edtDni = (EditText) rootView.findViewById(R.id.ingresolocal_edtDni);

        cvError = (CardView) rootView.findViewById(R.id.ingresolocal_cvError);
        cvNoregistrado = (CardView) rootView.findViewById(R.id.ingresolocal_cvNoRegistrado);
        cvRegistro = (CardView) rootView.findViewById(R.id.ingresolocal_cvRegistro);
        cvYaregistrado = (CardView) rootView.findViewById(R.id.ingresolocal_cvYaRegistrado);

        txtErrorCargo = (TextView) rootView.findViewById(R.id.ingresolocal_error_txtCargo);
        txtErrorLocal = (TextView) rootView.findViewById(R.id.ingresolocal_error_txtLocal);
        txtErrorSede = (TextView) rootView.findViewById(R.id.ingresolocal_error_txtSede);

        txtRegistroCargo = (TextView) rootView.findViewById(R.id.ingresolocal_txtCargo);
        txtRegistroDni = (TextView) rootView.findViewById(R.id.ingresolocal_txtDni);
        txtRegistroNombres = (TextView) rootView.findViewById(R.id.ingresolocal_txtNombres);
        txtRegistroSede = (TextView) rootView.findViewById(R.id.ingresolocal_txtSede);
        txtRegistroLocal = (TextView) rootView.findViewById(R.id.ingresolocal_txtLocal);
        txtRegistroAula = (TextView) rootView.findViewById(R.id.ingresolocal_txtAula);
        txtRegistroNbungalow = (TextView) rootView.findViewById(R.id.ingresolocal_txtNbungalow);
        txtRegistroRbungalow = (TextView) rootView.findViewById(R.id.ingresolocal_txtRbungalow);

        txtRegistroDni_yaregistrado = (TextView) rootView.findViewById(R.id.ingresolocal_txtDni_yaregistrado);
        txtRegistroNombres_yaregistrado = (TextView) rootView.findViewById(R.id.ingresolocal_txtNombres_yaregitstrado);
        txtRegistroFecha = (TextView) rootView.findViewById(R.id.ingresolocal_txtfecha);


        txtErrorLocal_error = (TextView) rootView.findViewById(R.id.ingresolocal_txtLocal_error);
        txtErrorSede_error = (TextView) rootView.findViewById(R.id.ingresolocal_txtSede_error);
        txtRegistroDireccion = (TextView) rootView.findViewById(R.id.ingresolocal_txtdireccion_error);


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
                        if(!buscarDNI(dni)) {
                            cvRegistro.setVisibility(View.GONE);
                            cvYaregistrado.setVisibility(View.GONE);
                            cvError.setVisibility(View.GONE);
                            cvNoregistrado.setVisibility(View.VISIBLE);
                            edtDni.setText("");
                            edtDni.requestFocus();
                        }
                        else{edtDni.setText("");
                            edtDni.requestFocus();}
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
                //ocultarTeclado(edtDni);
                //btnBuscar.requestFocus();
                String dni = edtDni.getText().toString();
                if(!dni.equals("")){
                    if(!buscarDNI(dni)) {
                        //NO EXISTE EN PADRON
                        cvRegistro.setVisibility(View.GONE);
                        cvYaregistrado.setVisibility(View.GONE);
                        cvError.setVisibility(View.GONE);
                        cvNoregistrado.setVisibility(View.VISIBLE);
                        edtDni.setText("");
                        edtDni.requestFocus();
                    }
                    else{edtDni.setText("");
                        edtDni.requestFocus();}
                }
                else {
                Toast.makeText(context, "Ingrese DNI ", Toast.LENGTH_SHORT).show();edtDni.setText("");
                    edtDni.requestFocus();}
            }
        });
    }

    public boolean buscarDNI(String dni){
        boolean encontrado = false;

        try {
            Data data = new Data(context);
            data.open();
            Nacional nacional = data.getNacional(dni);
            data.close();
            if(nacional != null){
                encontrado = true;
                if(cod_local.equals(nacional.getCod_local())){
                    data = new Data(context);
                    data.open();
                    Registrado registrado = data.getFechaRegistro(nacional.getCodigo());
                    if(registrado != null){
                        //YA REGISTRADO
                        cvError.setVisibility(View.GONE);
                        cvNoregistrado.setVisibility(View.GONE);
                        cvYaregistrado.setVisibility(View.VISIBLE);
                        cvRegistro.setVisibility(View.GONE);
                        txtRegistroDni_yaregistrado.setText(registrado.getCodigo());
                        txtRegistroNombres_yaregistrado.setText(registrado.getNombres());
                        txtRegistroFecha.setText(registrado.getAnio1()+"/"+registrado.getMes1()+"/"+registrado.getDia1()+"  -  "+registrado.getHora1()+":"+registrado.getMinuto1());
                    }else{
                        //NUEVO REGISTRADO
                        cvError.setVisibility(View.GONE);
                        cvNoregistrado.setVisibility(View.GONE);
                        cvYaregistrado.setVisibility(View.GONE);
                        cvRegistro.setVisibility(View.VISIBLE);
                        txtRegistroSede.setText(nacional.getSede_region());
                        txtRegistroNombres.setText(nacional.getNombres());
                        txtRegistroDni.setText(nacional.getCodigo());
                        txtRegistroLocal.setText(nacional.getCargo());
                        txtRegistroCargo.setText(nacional.getCargo());
                        txtRegistroAula.setText(nacional.getAula());
                        txtRegistroRbungalow.setText("Responsable de Bungalow :  "+nacional.getResp_bungalow());
                        txtRegistroNbungalow.setText(nacional.getN_bungalow());
                        Calendar calendario = Calendar.getInstance();
                        int yy = calendario.get(Calendar.YEAR);
                        int mm = calendario.get(Calendar.MONTH)+1;
                        int dd = calendario.get(Calendar.DAY_OF_MONTH);
                        int hora = calendario.get(Calendar.HOUR_OF_DAY);
                        int minuto = calendario.get(Calendar.MINUTE);
                        String estado1 = "1";
                        String estado2 = "0";
                        Registrado registrado1 = new Registrado(dni,nacional.getNivel(),
                                nacional.getCod_sede_reg(),nacional.getCod_sede_prov(),nacional.getCod_sede_distrital(),
                                nacional.getSede_region(),nacional.getSede_provincia(),nacional.getSede_distrital(),
                                nacional.getCod_local(),nacional.getNom_local(),nacional.getDireccion(),nacional.getAula(),nacional.getCodigo(),nacional.getNombres(),
                                nacional.getId_cargo(),nacional.getCargo(),nacional.getTipo_candidato(),nacional.getN_bungalow(),nacional.getResp_bungalow(),"","",
                                checkDigito(dd),checkDigito(mm),checkDigito(yy),checkDigito(hora),checkDigito(minuto),"","","","","",estado1,estado2,0,0);
//                        Registrado registrado1 = new Registrado(dni,dni,nacional.getSede(),nacional.getId_local(),nacional.getNom_local(),nacional.getAula(),nacional.getNombres(),
//                                checkDigito(dd),checkDigito(mm),checkDigito(yy),checkDigito(hora),checkDigito(minuto),"","","","","",estado1,estado2,0,0);
                        data.insertarFechaRegistro(registrado1);

                    }
                    data.close();
                }else{
                    //PERTENECE A OTRA SEDE
                    cvError.setVisibility(View.VISIBLE);
                    cvNoregistrado.setVisibility(View.GONE);
                    cvRegistro.setVisibility(View.GONE);
                    cvYaregistrado.setVisibility(View.GONE);
                    txtErrorSede_error.setText(nacional.getSede_region());
                    txtErrorLocal_error.setText(nacional.getSede_region());
                    txtRegistroDireccion.setText(nacional.getDireccion());

                }
            }
            else
                { Toast.makeText(context, "EL MARCO NO SE CARGO", Toast.LENGTH_SHORT).show(); }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return encontrado;
    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
}
