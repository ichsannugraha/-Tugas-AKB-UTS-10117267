package com.ichsannugraha.tugasutsakb10117267.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ichsannugraha.tugasutsakb10117267.AddBiodataActivity;
import com.ichsannugraha.tugasutsakb10117267.Adapter.BiodataAdapter;
import com.ichsannugraha.tugasutsakb10117267.BiodataContract;
import com.ichsannugraha.tugasutsakb10117267.DatabaseHelper;
import com.ichsannugraha.tugasutsakb10117267.R;

public class TemanFragment extends Fragment {
    private SQLiteDatabase mDatabase;
    private BiodataAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teman, container, false);

        DatabaseHelper dbHelper = new DatabaseHelper(getActivity());
        mDatabase = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = rootView.findViewById(R.id.rv_biodata);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new BiodataAdapter(getActivity(), getAllItems());
        recyclerView.setAdapter(mAdapter);
        mAdapter.swapCursor(getAllItems());

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                removeItem((String) viewHolder.itemView.getTag());
            }
        }).attachToRecyclerView(recyclerView);

        FloatingActionButton mFloatingBtn =rootView.findViewById(R.id.floatingBtn);
        mFloatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AddBiodataActivity.class);
                startActivity(i);
            }
        });


        return rootView;
    }

    private Cursor getAllItems() {
        return mDatabase.query(
                BiodataContract.BiodataEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                BiodataContract.BiodataEntry.COLUMN_NIM + " ASC"
        );
    }

    private void removeItem(String nim) {
        mDatabase.delete(BiodataContract.BiodataEntry.TABLE_NAME,
                BiodataContract.BiodataEntry.COLUMN_NIM + "=" + nim, null);
        mAdapter.swapCursor(getAllItems());
    }
}


/*
    Tanggal Pengerjaan  : 5/11/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF-8
 */