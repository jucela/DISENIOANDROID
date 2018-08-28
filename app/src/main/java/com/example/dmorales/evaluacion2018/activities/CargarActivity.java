package com.example.dmorales.evaluacion2018.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dmorales.evaluacion2018.R;

public class CargarActivity extends AppCompatActivity {

    Button btnsalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar);

        btnsalir = (Button) findViewById(R.id.btn_salir);

        btnsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CargarActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
