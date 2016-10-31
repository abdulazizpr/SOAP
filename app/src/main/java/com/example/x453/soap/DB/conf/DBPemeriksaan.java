package com.example.x453.soap.DB.conf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Abdul Aziz Priatna on 31/10/2016.
 */

public class DBPemeriksaan {

    public static class Pemeriksaan {
        public String BB_SEBELUM;
        public String BB_SEKARANG;
        public String TINGGI_BADAN;
        public String IMT;
        public String TEKANAN_DARAH;
        public String NADI;
        public String RESPIRASI;
        public String SUHU;
        public String MATA;
        public String WAJAH;
        public String MAMMA;
        public String ABODEMEN_INSPEKSI;
        public String ABODEMEN_PALPASI;
        public String EXTREMITAS_ATAS;
        public String EXTREMITAS_BAWAH;
        public String GENITALIA_LUAR;
        public String PEMERIKSAAN_DALAM;
        public String NO_REKAP;

        public Pemeriksaan(){
        }

    }

    private SQLiteDatabase db;
    private final OpenHelper dbHelper;

    public  DBPemeriksaan (Context c) {
        dbHelper =  new OpenHelper(c);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long insertPemeriksaan(int bb_sebelum, int bb_sekarang, int tinggi_badan,int imt, int tekanan_darah, int nadi, int respirasi, int suhu, String mata, String wajah, String mamma, String abodemen_i, String abodemen_p, String extrem_a, String extrem_b, String gen_luar, String pem_dalam, String norek) {
        ContentValues newValues = new ContentValues();
        newValues.put("BB_SEBELUM_HAMIL", bb_sebelum);
        newValues.put("BB_SEKARANG", bb_sekarang);
        newValues.put("TINGGI_BADAN", tinggi_badan);
        newValues.put("IMT", imt);
        newValues.put("TEKANAN_DARAH", tekanan_darah);
        newValues.put("NADI", nadi);
        newValues.put("RESPIRASI", respirasi);
        newValues.put("SUHU", suhu);
        newValues.put("MATA", mata);
        newValues.put("WAJAH", wajah);
        newValues.put("MAMMA", mamma);
        newValues.put("ABODEMEN_INSPEKSI", abodemen_i);
        newValues.put("ABODEMEN_PALPASI", abodemen_p);
        newValues.put("EXTREMITAS_ATAS", extrem_a);
        newValues.put("EXTREMITAS_BAWAH", extrem_b);
        newValues.put("GENITALIA_LUAR", gen_luar);
        newValues.put("PEMERIKSAAN_DALAM", pem_dalam);
        newValues.put("NO_REKAP", norek);
        return db.insert("PEMERIKSAAN_FISIK", null, newValues);
    }

    public long updatePemeriksaan(int bb_sebelum, int bb_sekarang, int tinggi_badan,int imt, int tekanan_darah, int nadi, int respirasi, int suhu, String mata, String wajah, String mamma, String abodemen_i, String abodemen_p, String extrem_a, String extrem_b, String gen_luar, String pem_dalam, String norek) {
        ContentValues newValues = new ContentValues();
        newValues.put("BB_SEBELUM_HAMIL", bb_sebelum);
        newValues.put("BB_SEKARANG", bb_sekarang);
        newValues.put("TINGGI_BADAN", tinggi_badan);
        newValues.put("IMT", imt);
        newValues.put("TEKANAN_DARAH", tekanan_darah);
        newValues.put("NADI", nadi);
        newValues.put("RESPIRASI", respirasi);
        newValues.put("SUHU", suhu);
        newValues.put("MATA", mata);
        newValues.put("WAJAH", wajah);
        newValues.put("MAMMA", mamma);
        newValues.put("ABODEMEN_INSPEKSI", abodemen_i);
        newValues.put("ABODEMEN_PALPASI", abodemen_p);
        newValues.put("EXTREMITAS_ATAS", extrem_a);
        newValues.put("EXTREMITAS_BAWAH", extrem_b);
        newValues.put("GENITALIA_LUAR", gen_luar);
        newValues.put("PEMERIKSAAN_DALAM", pem_dalam);
        newValues.put("NO_REKAP", norek);
        return db.update("PEMERIKSAAN_FISIK", newValues,"NO_REKAP='"+norek+"'",null);
    }

    //ambil data mahasiswa berdasarkan nama
    public DBPemeriksaan.Pemeriksaan getPemeriksaan(String norek) {
        Cursor cur = null;
        DBPemeriksaan.Pemeriksaan A = new DBPemeriksaan.Pemeriksaan();

        //kolom yang diambil
        String selectQuery = "SELECT * FROM PEMERIKSAAN_FISIK WHERE NO_REKAP='"+norek+"'";
        cur = db.rawQuery(selectQuery,null);

        if (cur.getCount()>0) {  //ada data? ambil
            cur.moveToFirst();
            A.BB_SEBELUM = cur.getString(1);
            A.BB_SEKARANG = cur.getString(2);
            A.TINGGI_BADAN = cur.getString(3);
            A.IMT = cur.getString(4);
            A.TEKANAN_DARAH = cur.getString(5);
            A.NADI = cur.getString(6);
            A.RESPIRASI = cur.getString(7);
            A.SUHU = cur.getString(8);
            A.MATA = cur.getString(9);
            A.WAJAH = cur.getString(10);
            A.MAMMA = cur.getString(11);
            A.ABODEMEN_INSPEKSI = cur.getString(12);
            A.ABODEMEN_PALPASI = cur.getString(13);
            A.EXTREMITAS_ATAS = cur.getString(14);
            A.EXTREMITAS_BAWAH = cur.getString(15);
            A.GENITALIA_LUAR = cur.getString(16);
            A.PEMERIKSAAN_DALAM = cur.getString(17);
            A.NO_REKAP = cur.getString(18);
        }

        return A;
    }

}
