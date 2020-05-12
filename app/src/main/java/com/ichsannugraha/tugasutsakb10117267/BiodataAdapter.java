package com.ichsannugraha.tugasutsakb10117267;

import android.content.Context;
import android.database.Cursor;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        public BiodataViewHolder(@NonNull View itemView) {
            super(itemView);

            nimText = itemView.findViewById(R.id.nimTeman);
            namaText = itemView.findViewById(R.id.namaTeman);
            kelasText = itemView.findViewById(R.id.kelasTeman);
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

        String nim = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_NIM));
        String nama = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_NAMA));
        String kelas = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_KELAS));
        String telepon = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_TELEPON));
        String email = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_EMAIL));
        String sosmed = mCursor.getString(mCursor.getColumnIndex(BiodataContract.BiodataEntry.COLUMN_SOSMED));

        holder.nimText.setText(nim);
        holder.namaText.setText(nama);
        holder.kelasText.setText(kelas);
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
