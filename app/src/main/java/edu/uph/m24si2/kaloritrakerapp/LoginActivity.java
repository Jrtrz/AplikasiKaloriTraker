package edu.uph.m24si2.kaloritrakerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi Komponen
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);

        // Tombol Login
        btnLogin.setOnClickListener(v -> {

            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty()) {
                etUsername.setError("Username harus diisi");
                return;
            }

            if (password.isEmpty()) {
                etPassword.setError("Password harus diisi");
                return;
            }

            // Login Dummy
            if (username.equals("admin") && password.equals("12345")) {

                Toast.makeText(this,
                        "Login Berhasil",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            } else {

                Toast.makeText(this,
                        "Username atau Password Salah",
                        Toast.LENGTH_SHORT).show();

            }

        });

        // Pindah ke Register
        txtRegister.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this,
                    RegisterActivity.class);

            startActivity(intent);

        });

    }
}