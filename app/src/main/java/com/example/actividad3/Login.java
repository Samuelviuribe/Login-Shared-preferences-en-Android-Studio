package com.example.actividad3;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtiene el nombre de usuario y contraseña ingresados por el usuario.

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Realiza la validación de las credenciales

                if (isValidCredentials(username, password)) {
                    // Credenciales válidas, navega a la siguiente pantalla (HomeActivity).
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);

                    // Guarda el nombre de usuario en SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.apply();
                } else {
                    // Credenciales inválidas, muestra un mensaje de error o notificación al usuario.
                    Toast.makeText(Login.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para validar las credenciales
    private boolean isValidCredentials(String username, String password) {
        // Aquí puedes implementar la lógica de validación, como verificar en una base de datos o en otro lugar.
        // Este es un ejemplo que valida "samuel" como nombre de usuario y "0000" como contraseña.
        return username.equals("samuel") && password.equals("0000");
    }
}

