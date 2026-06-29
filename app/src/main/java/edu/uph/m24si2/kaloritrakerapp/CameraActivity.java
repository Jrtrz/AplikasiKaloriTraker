package edu.uph.m24si2.kaloritrakerapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity {

    ImageView imgFood;
    Button btnAmbilFoto, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imgFood = findViewById(R.id.imgFood);
        btnAmbilFoto = findViewById(R.id.btnAmbilFoto);
        btnKembali = findViewById(R.id.btnKembali);

        btnAmbilFoto.setOnClickListener(v -> {

            // Dummy
            // imgFood.setImageResource(R.drawable.makanan); // TODO: Add makanan drawable

            Toast.makeText(this,
                    "Foto makanan berhasil diambil (Dummy)",
                    Toast.LENGTH_SHORT).show();

        });

        btnKembali.setOnClickListener(v -> finish());

    }
}