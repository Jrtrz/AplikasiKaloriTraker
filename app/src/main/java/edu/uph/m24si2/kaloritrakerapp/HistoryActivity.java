package edu.uph.m24si2.kaloritrakerapp;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Food> foodList;
    HistoryAdapter adapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.recyclerHistory);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodList = new ArrayList<>();

        databaseHelper = new DatabaseHelper(this);

        loadData();

        adapter = new HistoryAdapter(foodList);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {

        Cursor cursor = databaseHelper.getAllHistory();

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                int kalori = cursor.getInt(2);
                int protein = cursor.getInt(3);
                int lemak = cursor.getInt(4);
                int karbo = cursor.getInt(5);

                foodList.add(new Food(
                        id,
                        nama,
                        kalori,
                        protein,
                        lemak,
                        karbo
                ));

            } while (cursor.moveToNext());

        }

        cursor.close();
    }
}