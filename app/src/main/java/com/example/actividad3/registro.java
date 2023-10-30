package com.example.actividad3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class registro extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usernameEditText = findViewById(R.id.nombretext);
        passwordEditText = findViewById(R.id.contraseñatext);
        Button registerButton = findViewById(R.id.registerButton);
        Button backToLoginButton = findViewById(R.id.backToLoginButton);

        backToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirige al usuario a la página de inicio de sesión.
                Intent intent = new Intent(registro.this, Login.class);
                startActivity(intent);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtiene el nombre de usuario y contraseña ingresados por el usuario.
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Guarda las credenciales del usuario en SharedPreferences.
                saveUserCredentials(username, password);

                // Muestra una notificación de registro exitoso.
                showRegistrationNotification();

                // Borra los campos de los EditText.
                usernameEditText.setText("");
                passwordEditText.setText("");
            }
        });
    }

    private void showRegistrationNotification() {
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
    }

    // Método para guardar las credenciales del usuario en SharedPreferences.
    private void saveUserCredentials(String username, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }
}
