package com.example.x453.soap.DB.conf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Abdul Aziz Priatna on 31/10/2016.
 */

public class DBIdentitasDiri {

    public static class IdentitasDiri {
        public String NAMA;
        public String UMUR;
        public String SUKU;
        public String AGAMA;
        public String PEND_TERAKHIR;
        public String GOL_DARAH;
        public String PEKERJAAN;
        public String ALAMAT;
        public String STATUS_PERNIKAHAN;
        public String JENIS_IDENTITAS;
        public String NOREK;

        public IdentitasDiri(){
        }

    }

    private SQLiteDatabase db;
    private final OpenHelper dbHelper;

    public  DBIdentitasDiri(Context c) {
        dbHelper =  new OpenHelper(c);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long insertIdentitas(String nama,int umur,String suku,String agama,String pend_terakhir,String gol_darah,String pekerjaan, String alamat,String status_pernikahan,String jenis_identitas,String norek) {
        ContentValues newValues = new ContentValues();
        newValues.put("NAMA", nama);
        newValues.put("UMUR", umur);
        newValues.put("SUKU", suku);
        newValues.put("AGAMA", agama);
        newValues.put("PENDIDIKAN_TERAKHIR", pend_terakhir);
        newValues.put("GOLDAR", gol_darah);
        newValues.put("PEKERJAAN", pekerjaan);
        newValues.put("ALAMAT", alamat);
        newValues.put("STATUS_PERNIKAHAN", status_pernikahan);
        newValues.put("JENIS_IDENTITAS", jenis_identitas);
        newValues.put("NO_REKAP", norek);
        return db.insert("IDENTITAS_PASIEN", null, newValues);
    }

    public long updateIdentitas(String nama,int umur,String suku,String agama,String pend_terakhir,String gol_darah,String pekerjaan, String alamat,String status_pernikahan,String jenis_identitas,String norek) {
        ContentValues newValues = new ContentValues();
        newValues.put("NAMA", nama);
        newValues.put("UMUR", umur);
        newValues.put("SUKU", suku);
        newValues.put("AGAMA", agama);
        newValues.put("PENDIDIKAN_TERAKHIR", pend_terakhir);
        newValues.put("GOLDAR", gol_darah);
        newValues.put("PEKERJAAN", pekerjaan);
        newValues.put("ALAMAT", alamat);
        newValues.put("STATUS_PERNIKAHAN", status_pernikahan);
        return db.update("IDENTITAS_PASIEN", newValues,"NO_REKAP='"+norek+"' AND JENIS_IDENTITAS='"+jenis_identitas+"'",null);
    }

    //ambil data mahasiswa berdasarkan nama
    public IdentitasDiri getIdentitas(String norek,String jenis) {
        Cursor cur = null;
        IdentitasDiri I = new IdentitasDiri();

        //kolom yang diambil
        String selectQuery = "SELECT * FROM IDENTITAS_PASIEN WHERE NO_REKAP='"+norek+"' AND JENIS_IDENTITAS='"+jenis+"'";
        cur = db.rawQuery(selectQuery,null);

        if (cur.getCount()>0) {  //ada data? ambil
            cur.moveToFirst();
            I.NAMA = cur.getString(1);
            I.UMUR = cur.getString(2);
            I.SUKU = cur.getString(3);
            I.AGAMA = cur.getString(4);
            I.PEND_TERAKHIR = cur.getString(5);
            I.GOL_DARAH = cur.getString(6);
            I.PEKERJAAN = cur.getString(7);
            I.ALAMAT = cur.getString(8);
            I.STATUS_PERNIKAHAN = cur.getString(9);
            I.JENIS_IDENTITAS = cur.getString(10);
            I.NOREK = cur.getString(11);
        }

        return I;
    }



}
