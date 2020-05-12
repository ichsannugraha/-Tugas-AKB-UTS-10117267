package com.ichsannugraha.tugasutsakb10117267.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;

import com.ichsannugraha.tugasutsakb10117267.R;

public class ProfileFragment extends Fragment {
    private TextView mDeskripsiProfil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        roundPict(rootView);

        mDeskripsiProfil = rootView.findViewById(R.id.deskripsiProfilTxt);
        addDeskripsi(mDeskripsiProfil);

        return rootView;
    }

    public void roundPict(View view){
        //membuat gambar logo iLoker menjadi lingkaran
        ImageView imageView = (ImageView) view.findViewById(R.id.profilePicture);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.profile);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);
    }

    public void addDeskripsi(TextView mDeskripsiProfil) {
        mDeskripsiProfil.setText("Nama saya Ichsan Nugraha, NIM saya 10117267." +
                " Saya kelas IF-8 dan seorang mahasiswa UNIKOM." +
                " Saya hobi nonton kartun dan senang mendengarkan musik.");
    }
}


/*
    Tanggal Pengerjaan  : 5/11/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF-8
 */
