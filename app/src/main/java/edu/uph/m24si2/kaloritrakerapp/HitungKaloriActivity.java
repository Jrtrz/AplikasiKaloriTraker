package edu.uph.m24si2.kaloritrakerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HitungKaloriActivity extends AppCompatActivity {

    Spinner spMakanan;
    Button btnHitung, btnKembali, btnSimpan;
    ImageView imgMakanan;

    DatabaseHelper dbHelper;

    TextView txtKalori;
    TextView txtProtein;
    TextView txtLemak;
    TextView txtKarbo;

    String[] makanan = {
            "Nasi Goreng",
            "Mie Goreng",
            "Bakso",
            "Ayam Goreng",
            "Sate Ayam"
    };

    int[] kalori = {550, 480, 350, 260, 300};
    int[] protein = {15, 12, 18, 25, 20};
    int[] lemak = {20, 18, 10, 15, 12};
    int[] karbo = {70, 65, 25, 10, 15};

    // Array untuk menyimpan ID gambar makanan (menggunakan launcher sebagai placeholder)
    int[] gambarMakanan = {
            R.mipmap.ic_launcher_round, // Nasi Goreng
            R.mipmap.ic_launcher_round, // Mie Goreng
            R.mipmap.ic_launcher_round, // Bakso
            R.mipmap.ic_launcher_round, // Ayam Goreng
            R.mipmap.ic_launcher_round  // Sate Ayam
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitungkalori);
        spMakanan = findViewById(R.id.spMakanan);
        imgMakanan = findViewById(R.id.imgMakanan);

        dbHelper = new DatabaseHelper(this);

        btnHitung = findViewById(R.id.btnHitung);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnKembali = findViewById(R.id.btnKembali);

        txtKalori = findViewById(R.id.txtKalori);
        txtProtein = findViewById(R.id.txtProtein);
        txtLemak = findViewById(R.id.txtLemak);
        txtKarbo = findViewById(R.id.txtKarbo);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                makanan);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spMakanan.setAdapter(adapter);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = spMakanan.getSelectedItemPosition();

                txtKalori.setText("Kalori : " + kalori[i] + " kkal");
                txtProtein.setText("Protein : " + protein[i] + " gram");
                txtLemak.setText("Lemak : " + lemak[i] + " gram");
                txtKarbo.setText("Karbohidrat : " + karbo[i] + " gram");

                // Update gambar makanan berdasarkan pilihan
                imgMakanan.setImageResource(gambarMakanan[i]);

                // Tampilkan tombol simpan
                btnSimpan.setVisibility(View.VISIBLE);
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = spMakanan.getSelectedItemPosition();

                boolean inserted = dbHelper.insertHistory(
                        makanan[i],
                        kalori[i],
                        protein[i],
                        lemak[i],
                        karbo[i]
                );

                if (inserted) {
                    Toast.makeText(HitungKaloriActivity.this,
                            "Berhasil disimpan ke riwayat!",
                            Toast.LENGTH_SHORT).show();
                    btnSimpan.setVisibility(View.GONE);
                } else {
                    Toast.makeText(HitungKaloriActivity.this,
                            "Gagal menyimpan data",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}