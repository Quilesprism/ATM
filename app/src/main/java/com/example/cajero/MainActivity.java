package com.example.cajero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private EditText editTextCuenta;
    private EditText editTextPIN;
    private Button buttonIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCuenta = findViewById(R.id.editTextCuenta);
        editTextPIN = findViewById(R.id.editTextPIN);
        buttonIngresar = findViewById(R.id.buttonIngresar);

        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cuenta = editTextCuenta.getText().toString();
                String pin = editTextPIN.getText().toString();
                if (validarCuenta(cuenta) && validarPIN(pin)) {
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    intent.putExtra("cuenta", cuenta);
                    activityLauncher.launch(intent);
                }
            }
        });
    }

    private boolean validarCuenta(String cuenta) {
        return true;
    }
    private boolean validarPIN(String pin) {
        return true;
    }
}
