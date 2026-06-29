package edu.uph.m24si2.kaloritrakerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCamera, btnKalori, btnHistory, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = findViewById(R.id.btnCamera);
        btnKalori = findViewById(R.id.btnKalori);
        btnHistory = findViewById(R.id.btnHistory);
        btnLogout = findViewById(R.id.btnLogout);

        // Ambil Foto Makanan
        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CameraActivity.class);
            startActivity(intent);
        });

        // Hitung Kalori
        btnKalori.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HitungKaloriActivity.class);
            startActivity(intent);
        });

        // Riwayat
        btnHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
        });

        // Logout
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}