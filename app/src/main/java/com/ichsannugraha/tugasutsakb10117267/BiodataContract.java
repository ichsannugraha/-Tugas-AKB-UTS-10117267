package com.ichsannugraha.tugasutsakb10117267;

import android.provider.BaseColumns;

public class BiodataContract {

    private BiodataContract() {
        //Konstruktor
    }

    public static final class BiodataEntry implements BaseColumns {
        public static final String TABLE_NAME = "biodataList";
        public static final String COLUMN_NIM = "nim";
        public static final String COLUMN_NAMA = "nama";
        public static final String COLUMN_KELAS = "kelas";
        public static final String COLUMN_TELEPON = "telepon";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_SOSMED = "sosmed";
    }

}
