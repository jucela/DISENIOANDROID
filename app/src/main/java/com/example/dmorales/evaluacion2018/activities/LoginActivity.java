package com.example.dmorales.evaluacion2018.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dmorales.evaluacion2018.R;
import com.example.dmorales.evaluacion2018.modelo.Data;
import com.example.dmorales.evaluacion2018.modelo.UsuarioLocal;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edtClave;
    Button btnIngresar;
    TextView btncargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtClave = (TextInputEditText) findViewById(R.id.login_edtClave);
        btnIngresar = (Button) findViewById(R.id.login_btnIngresar);
        btncargar =(TextView) findViewById(R.id.txt_cargarmarco);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar(edtClave.getText().toString());
            }
        });

        btncargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,CargarActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void ingresar(String clave){
        try{
            Data data = new Data(LoginActivity.this);
            data.open();
            UsuarioLocal usuarioLocal = data.getUsuarioLocal(clave);
            data.close();


                  if (usuarioLocal != null){
                      if(usuarioLocal.getCod_nivel().equals("I"))
                      {  Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                          intent.putExtra("cod_local", usuarioLocal.getCod_local());
                          intent.putExtra("sede", usuarioLocal.getSede_region());
                          intent.putExtra("usuario", usuarioLocal.getUsuario());
                          intent.putExtra("nombrenivel", usuarioLocal.getNom_nivel());
                          intent.putExtra("fase", usuarioLocal.getFase());
                          startActivity(intent);  }
                      else if(usuarioLocal.getCod_nivel().equals("II"))
                           { Intent intent2 = new Intent(LoginActivity.this, MainActivity2.class);
                               intent2.putExtra("cod_local", usuarioLocal.getCod_local());
                               intent2.putExtra("sede", usuarioLocal.getSede_region());
                               intent2.putExtra("usuario", usuarioLocal.getUsuario());
                               intent2.putExtra("nombrenivel", usuarioLocal.getNom_nivel());
                               intent2.putExtra("fase", usuarioLocal.getFase());
                               startActivity(intent2);   }
                           else if(usuarioLocal.getCod_nivel().equals("III"))
                                {Intent intent3 = new Intent(LoginActivity.this, MainActivity3.class);
                                    intent3.putExtra("cod_local", usuarioLocal.getCod_local());
                                    intent3.putExtra("sede", usuarioLocal.getSede_region());
                                    intent3.putExtra("usuario", usuarioLocal.getUsuario());
                                    intent3.putExtra("nombrenivel", usuarioLocal.getNom_nivel());
                                    intent3.putExtra("fase", usuarioLocal.getFase());
                                    startActivity(intent3);    }
                                else if(usuarioLocal.getCod_nivel().equals("VI"))
                                     {Intent intent6 = new Intent(LoginActivity.this, MainActivity6.class);
                                         intent6.putExtra("cod_local", usuarioLocal.getCod_local());
                                      intent6.putExtra("sede", usuarioLocal.getSede_region());
                                      intent6.putExtra("usuario", usuarioLocal.getUsuario());
                                      intent6.putExtra("nombrenivel", usuarioLocal.getNom_nivel());
                                      intent6.putExtra("fase", usuarioLocal.getFase());
                                      startActivity(intent6);    }
                  }else{
                      Toast.makeText(this, "CLAVE NO REGISTRADA", Toast.LENGTH_SHORT).show();
                  }


//            if(usuarioLocal.getCod_nivel().equals("I"))
//              {
//                  if (usuarioLocal != null){
//                      Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                      intent.putExtra("sede", usuarioLocal.getSede_region());
//                      intent.putExtra("usuario", usuarioLocal.getUsuario());
//                      intent.putExtra("nombrenivel", usuarioLocal.getNom_nivel());
//                      intent.putExtra("fase", usuarioLocal.getFase());
//                      startActivity(intent);
//                  }else{
//                      Toast.makeText(this, "CLAVE INCORRECTA", Toast.LENGTH_SHORT).show();
//                  }
//              }
//            else if(usuarioLocal.getCod_nivel().equals("II"))
//                   {
//                       if (usuarioLocal != null){
//                           Intent intent2 = new Intent(LoginActivity.this, MainActivity2.class);
//                           intent2.putExtra("sede", usuarioLocal.getSede_region());
//                           intent2.putExtra("usuario", usuarioLocal.getUsuario());
//                           intent2.putExtra("nombrenivel", usuarioLocal.getNom_nivel());
//                           intent2.putExtra("fase", usuarioLocal.getFase());
//                           startActivity(intent2);
//                       }else{
//                           Toast.makeText(this, "CLAVE INCORRECTA", Toast.LENGTH_SHORT).show();
//                       }
//
//                   }
//            else  if(usuarioLocal.getCod_nivel().equals("III"))
//               {
//                if (usuarioLocal != null){
//                    Intent intent3 = new Intent(LoginActivity.this, MainActivity3.class);
//                    intent3.putExtra("sede", usuarioLocal.getSede_region());
//                    intent3.putExtra("usuario", usuarioLocal.getUsuario());
//                    intent3.putExtra("nombrenivel", usuarioLocal.getNom_nivel());
//                    intent3.putExtra("fase", usuarioLocal.getFase());
//                    startActivity(intent3);
//                }else{
//                    Toast.makeText(this, "CLAVE INCORRECTA", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//            else {Toast.makeText(this, "CLAVE NO REGISTRADA", Toast.LENGTH_SHORT).show();}

//            if (usuarioLocal != null){
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                intent.putExtra("sede", usuarioLocal.getSede_region());
//                intent.putExtra("usuario", usuarioLocal.getUsuario());
//                intent.putExtra("nombrenivel", usuarioLocal.getNom_nivel());
//                intent.putExtra("fase", usuarioLocal.getFase());
//                startActivity(intent);
//            }else{
//                Toast.makeText(this, "CLAVE INCORRECTA", Toast.LENGTH_SHORT).show();
//            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
