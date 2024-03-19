package com.example.cajero;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Models.Usuario;

public class ConsultaActivity extends AppCompatActivity {
    private Button bntSaldo;
    private TextView txtSaldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        bntSaldo = findViewById(R.id.btnsaldo);
        txtSaldo= findViewById(R.id.txtS);
        bntSaldo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double balance = getIntent().getDoubleExtra("saldo", 0.0);
                txtSaldo.setText(String.valueOf(balance));
            }

        });
    }
}