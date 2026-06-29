package edu.uph.m24si2.kaloritrakerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Nama Database
    private static final String DATABASE_NAME = "KaloriTracker.db";
    private static final int DATABASE_VERSION = 1;

    // Nama Tabel
    public static final String TABLE_HISTORY = "history";

    // Nama Kolom
    public static final String COL_ID = "id";
    public static final String COL_NAMA = "nama_makanan";
    public static final String COL_KALORI = "kalori";
    public static final String COL_PROTEIN = "protein";
    public static final String COL_LEMAK = "lemak";
    public static final String COL_KARBO = "karbohidrat";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_HISTORY + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAMA + " TEXT, " +
                COL_KALORI + " INTEGER, " +
                COL_PROTEIN + " INTEGER, " +
                COL_LEMAK + " INTEGER, " +
                COL_KARBO + " INTEGER)";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
        onCreate(db);

    }

    // Menyimpan Data
    public boolean insertHistory(String nama,
                                 int kalori,
                                 int protein,
                                 int lemak,
                                 int karbo) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COL_NAMA, nama);
        values.put(COL_KALORI, kalori);
        values.put(COL_PROTEIN, protein);
        values.put(COL_LEMAK, lemak);
        values.put(COL_KARBO, karbo);

        long result = db.insert(TABLE_HISTORY, null, values);

        db.close();

        return result != -1;
    }

    // Menampilkan Semua Data
    public Cursor getAllHistory() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery(
                "SELECT * FROM " + TABLE_HISTORY + " ORDER BY id DESC",
                null
        );
    }

    // Menghapus Semua Data
    public void deleteAllHistory() {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_HISTORY, null, null);

        db.close();
    }
}