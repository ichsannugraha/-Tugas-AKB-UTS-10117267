package com.ichsannugraha.tugasutsakb10117267;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ichsannugraha.tugasutsakb10117267.BiodataContract.*;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodata.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("CREATE TABLE tbl_biodata (nim INT PRIMARY KEY, nama TEXT, kelas TEXT, telepon TEXT, email TEXT, sosmed TEXT)");
        final String SQL_CREATE_BIODATALIST_TABLE = "CREATE TABLE " +
                BiodataEntry.TABLE_NAME + " (" +
                BiodataEntry.COLUMN_NIM + " TEXT PRIMARY KEY, " +
                BiodataEntry.COLUMN_NAMA + " TEXT NOT NULL, " +
                BiodataEntry.COLUMN_KELAS + " TEXT NOT NULL, " +
                BiodataEntry.COLUMN_TELEPON + " TEXT NOT NULL, " +
                BiodataEntry.COLUMN_EMAIL + " TEXT NOT NULL, " +
                BiodataEntry.COLUMN_SOSMED + " TEXT NOT NULL " +
                ");";

        db.execSQL(SQL_CREATE_BIODATALIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BiodataEntry.TABLE_NAME);
        onCreate(db);
    }

/*
    @Override
    public Cursor read() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM tbl_kontak", null);
    }

    @Override
    public boolean create(Biodata biodata) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO tbl_biodata VALUES ('"+biodata.getNim()+"','"+biodata.getNama()+"'," +
                "'"+biodata.getKelas()+"','"+biodata.getTelepon()+"','"+biodata.getEmail()+"','"+biodata.getSosmed()+"')");
        return true;
    }

    @Override
    public boolean update(Biodata biodata) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE tbl_biodata SET nama='"+biodata.getNama()+"', kelas='"+biodata.getKelas()+"', " +
                " telepon='"+biodata.getTelepon()+"', email'"+biodata.getEmail()+"', sosmed'"+biodata.getSosmed()+"' " +
                " WHERE nim='"+biodata.getNim()+"'");
        return true;
    }

    @Override
    public boolean delete(String id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM tbl_biodata WHERE nim='"+id+"'");
        return true;
    }

 */
}


/*
    Tanggal Pengerjaan  : 5/12/2020
    NIM                 : 10117267
    Nama                : Ichsan Nugraha
    Kelas               : IF-8
 */
