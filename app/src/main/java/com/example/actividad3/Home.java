package com.example.actividad3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    private EditText dataEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dataEditText = findViewById(R.id.dataEditText);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputData = dataEditText.getText().toString();

                // Aquí puedes hacer lo que quieras con los datos ingresados, como guardarlos en SharedPreferences, una base de datos, etc.
                // En este ejemplo, mostraremos una notificación con los datos ingresados.
                showNotification("Datos ingresados: " + inputData);
            }
        });
    }

    private void showNotification(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}






