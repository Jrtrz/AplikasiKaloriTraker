package edu.uph.m24si2.kaloritrakerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etNama, etUsername, etPassword, etConfirmPassword;
    private Button btnRegister;
    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi Komponen
        etNama = findViewById(R.id.etNama);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);
        txtLogin = findViewById(R.id.txtLogin);

        // Tombol Register
        btnRegister.setOnClickListener(v -> {

            String nama = etNama.getText().toString().trim();
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirm = etConfirmPassword.getText().toString().trim();

            if (nama.isEmpty()) {
                etNama.setError("Nama harus diisi");
                return;
            }

            if (username.isEmpty()) {
                etUsername.setError("Username harus diisi");
                return;
            }

            if (password.isEmpty()) {
                etPassword.setError("Password harus diisi");
                return;
            }

            if (confirm.isEmpty()) {
                etConfirmPassword.setError("Konfirmasi Password harus diisi");
                return;
            }

            if (!password.equals(confirm)) {
                Toast.makeText(RegisterActivity.this,
                        "Password tidak sama",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(RegisterActivity.this,
                    "Registrasi Berhasil",
                    Toast.LENGTH_SHORT).show();

            // Kembali ke Login
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        });

        // Sudah punya akun
        txtLogin.setOnClickListener(v -> {

            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        });

    }
}