package com.ichsannugraha.tugasutsakb10117267;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailTemanActivity extends AppCompatActivity {
    private TextView mNimDetail;
    private TextView mNamaDetail;
    private TextView mKelasDetail;
    private TextView mTeleponDetail;
    private TextView mEmailDetail;
    private TextView mSosmedDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_teman);
        getSupportActionBar().setTitle("Detail Teman");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNimDetail = findViewById(R.id.nimDetailTxt);
        mNamaDetail = findViewById(R.id.namaDetailTxt);
        mKelasDetail = findViewById(R.id.kelasDetailTxt);
        mTeleponDetail = findViewById(R.id.teleponDetailTxt);
        mEmailDetail = findViewById(R.id.emailDetailTxt);
        mSosmedDetail = findViewById(R.id.sosmedDetailTxt);

        Intent i =getIntent();

        if (i.hasExtra("nimTeman") && i.hasExtra("namaTeman") && i.hasExtra("kelasTeman") &&
                i.hasExtra("teleponTeman") && i.hasExtra("emailTeman") && i.hasExtra("sosmedTeman")) {

            String nimTeman = i.getStringExtra("nimTeman");
            String namaTeman = i.getStringExtra("namaTeman");
            String kelasTeman = i.getStringExtra("kelasTeman");
            String teleponTeman = i.getStringExtra("teleponTeman");
            String emailTeman = i.getStringExtra("emailTeman");
            String sosmedTeman = i.getStringExtra("sosmedTeman");

            mNimDetail.setText(nimTeman);
            mNamaDetail.setText(namaTeman);
            mKelasDetail.setText(kelasTeman);
            mTeleponDetail.setText(teleponTeman);
            mEmailDetail.setText(emailTeman);
            mSosmedDetail.setText(sosmedTeman);
        }
    }
}


/*
    Tanggal Pengerjaan  : 5/12/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF-8
 */
