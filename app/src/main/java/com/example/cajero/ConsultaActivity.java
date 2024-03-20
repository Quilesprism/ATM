package com.example.cajero;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cajero.models.Account;


public class ConsultaActivity extends AppCompatActivity {
    private Button bntSaldo;
    private Button btnH;
    private TextView txtSaldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        bntSaldo = findViewById(R.id.btnsaldo);
        txtSaldo= findViewById(R.id.txtS);
        btnH = findViewById(R.id.btnHT);
        bntSaldo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double balance = Account.getInstance().getMount();
                txtSaldo.setText(String.valueOf(balance));
            }

        });
        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsultaActivity.this, HistorialActivity.class);
                startActivity(intent);
            }
        });


    }
}