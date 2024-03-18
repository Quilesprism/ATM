package com.example.cajero;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    private RequestQueue requestQueue;
    String url = "https://atm-api-eight.vercel.app/api/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextCuenta);
        editTextPassword = findViewById(R.id.editTextPIN);
        buttonLogin = findViewById(R.id.buttonIngresar);

        requestQueue = Volley.newRequestQueue(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }
    public void loginUser() {
        // Obteniendo los valores de nombre de usuario y contraseña desde los EditTexts
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        // Creando una solicitud POST usando StringRequest
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Manejar la respuesta del servidor, por ejemplo, mostrar un mensaje o iniciar una nueva actividad
                        Toast.makeText(MainActivity.this, "Respuesta del servidor: " + response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Manejar errores de la solicitud, por ejemplo, mostrar un mensaje de error
                        Toast.makeText(MainActivity.this, "Error al iniciar sesión: " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                // Definir los parámetros de la solicitud POST (nombre de usuario y contraseña)
                Map<String, String> params = new HashMap<>();
                params.put("accountNumber,", username);
                params.put("password", password);
                return params;
            }
        };

        // Agregando la solicitud a la cola de solicitudes
        requestQueue.add(stringRequest);
    }


}

