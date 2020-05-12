package com.ichsannugraha.tugasutsakb10117267;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBiodataActivity extends AppCompatActivity {
    private EditText mNimEdit;
    private EditText mNamaEdit;
    private EditText mKelasEdit;
    private EditText mTeleponEdit;
    private EditText mEmailEdit;
    private EditText mSosmedEdit;

    private Button mAddBiodata;

    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_biodata);
        getSupportActionBar().setTitle("Tambah Biodata");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        mNimEdit = findViewById(R.id.nimProfilEdit);
        mNamaEdit = findViewById(R.id.namaProfilEdit);
        mKelasEdit = findViewById(R.id.kelasProfilEdit);
        mTeleponEdit = findViewById(R.id.teleponProfilEdit);
        mEmailEdit = findViewById(R.id.emailProfilEdit);
        mSosmedEdit = findViewById(R.id.sosmedProfilEdit);

        mAddBiodata = findViewById(R.id.addBiodataBtn);

        mAddBiodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }

    private void addData() {
        String nim = mNimEdit.getText().toString();
        String nama = mNamaEdit.getText().toString();
        String kelas = mKelasEdit.getText().toString();
        String telepon = mTeleponEdit.getText().toString();
        String email = mEmailEdit.getText().toString();
        String sosmed = mSosmedEdit.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put(BiodataContract.BiodataEntry.COLUMN_NIM, nim);
        cv.put(BiodataContract.BiodataEntry.COLUMN_NAMA, nama);
        cv.put(BiodataContract.BiodataEntry.COLUMN_KELAS, kelas);
        cv.put(BiodataContract.BiodataEntry.COLUMN_TELEPON, telepon);
        cv.put(BiodataContract.BiodataEntry.COLUMN_EMAIL, email);
        cv.put(BiodataContract.BiodataEntry.COLUMN_SOSMED, sosmed);

        mDatabase.insert(BiodataContract.BiodataEntry.TABLE_NAME, null, cv);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}


/*
    Tanggal Pengerjaan  : 5/12/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF-8
 */
