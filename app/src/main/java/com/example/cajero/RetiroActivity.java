package com.example.cajero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RetiroActivity extends AppCompatActivity {

    private EditText editTextAccountNumber;
    private EditText editTextAmount;
    private Button buttonWithdraw;

    private RequestQueue requestQueue;
    String url = "https://atm-api-eight.vercel.app/api/transaction/withdraw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retiro);

        editTextAccountNumber = findViewById(R.id.editTextC);
        editTextAmount = findViewById(R.id.editTextM);
        buttonWithdraw = findViewById(R.id.btnRetiro);

        requestQueue = Volley.newRequestQueue(this);

        buttonWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                withdrawAmount();
            }
        });
    }

    public void withdrawAmount() {
        final String accountNumber = editTextAccountNumber.getText().toString().trim();
        final String texta = editTextAmount.getText().toString().trim();
        Double amount = Double.parseDouble(texta);
        try {
            JSONObject jsonParams = new JSONObject();
            jsonParams.put("accountNumber", accountNumber);
            jsonParams.put("amount", amount);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonParams, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String message = response.getString("accountNumber");
                        Toast.makeText(getApplicationContext(), "Retiro exitoso de la cuenta " + message , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (JSONException ex) {
                        Toast.makeText(getApplicationContext(), "Error al procesar la respuesta" + ex.getMessage(), Toast.LENGTH_SHORT).show();
                        ex.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Error al procesar la solicitud" + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            Volley.newRequestQueue(this).add(jsonObjectRequest);
        } catch (JSONException ex) {
            Toast.makeText(getApplicationContext(), "Error al procesar la solicitud" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.printStackTrace();

        }


    }
}
