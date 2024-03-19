package com.example.cajero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnSalir;
    Button btnConsulta;
    Button btnRetiros;
    Button btnDeposito;
    Button btnTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnSalir = findViewById(R.id.btnSalir);
        btnConsulta= findViewById(R.id.btnconsulta);
        btnRetiros = findViewById(R.id.btnRetiros);
        btnDeposito = findViewById(R.id.btnDeposito);
        btnTrans = findViewById(R.id.btnTrans);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });
        btnRetiros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, RetiroActivity.class));

            }
        });
    }
}