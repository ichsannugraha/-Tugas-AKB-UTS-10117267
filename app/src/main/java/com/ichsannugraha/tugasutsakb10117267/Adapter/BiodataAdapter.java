package com.ichsannugraha.tugasutsakb10117267.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ichsannugraha.tugasutsakb10117267.BiodataContract;
import com.ichsannugraha.tugasutsakb10117267.DetailTemanActivity;
import com.ichsannugraha.tugasutsakb10117267.R;

public class BiodataAdapter extends RecyclerView.Adapter<BiodataAdapter.BiodataViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public BiodataAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public class BiodataViewHolder extends RecyclerView.ViewHolder {
        public TextView nimText;
        public TextView namaText;
        public TextView kelasText;
        public TextView teleponText;
        public TextView emailText;
        public TextView sosmedText;
        public RelativeLayout parentLayout;

        public BiodataViewHolder(@NonNull View itemView) {
            super(itemView);

            nimText = itemView.findViewById(R.id.nimTeman);
            namaText = itemView.findViewById(R.id.namaTeman);
            kelasText = itemView.findViewById(R.id.kelasTeman);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    @NonNull
    @Override
    public BiodataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.biodata_items, parent, false);
        return new BiodataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BiodataViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        final String nim = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_NIM));
        final String nama = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_NAMA));
        final String kelas = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_KELAS));
        final String telepon = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_TELEPON));
        final String email = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_EMAIL));
        final String sosmed = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_SOSMED));

        holder.nimText.setText(nim);
        holder.namaText.setText(nama);
        holder.kelasText.setText(kelas);
        holder.itemView.setTag(nim);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailTemanActivity.class);
                i.putExtra("nimTeman", nim);
                i.putExtra("namaTeman", nama);
                i.putExtra("kelasTeman", kelas);
                i.putExtra("teleponTeman", telepon);
                i.putExtra("emailTeman", email);
                i.putExtra("sosmedTeman", sosmed);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}


/*
    Tanggal Pengerjaan  : 5/12/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF-8
 */
