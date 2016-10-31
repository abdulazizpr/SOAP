package com.example.x453.soap.DB.conf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Abdul Aziz Priatna on 31/10/2016.
 */

public class DBAnamnesa {

    public static class Anamnesa {
        public String KELUHAN;
        public String HPHT;
        public String LAMA_MENSTRUASI;
        public String BANYAKNYA;
        public String SIKLUS;
        public String LAMA;
        public String BANYAK;
        public String RIWAYAT_PENDARAHAN;
        public String MUNTAH_BERLEBIHAN;
        public String NYERI_ULU_HATI;
        public String PUSING_BERAT;
        public String USIA_KEHAMILAN;
        public String IMUNISASI;
        public String PERGERAKAN_JANIN;
        public String ANC;
        public String DIPERIKSA_KE;
        public String OBAT_YANG_DIKONSUMSI;
        public String NO_REKAP;

        public Anamnesa(){
        }

    }

    private SQLiteDatabase db;
    private final OpenHelper dbHelper;

    public  DBAnamnesa(Context c) {
        dbHelper =  new OpenHelper(c);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long insertAnamnesa(String keluhan,String hpht, int lama_menstruasi, int banyaknya, int siklus, int lama, int banyak, String riwayat_pendarahan, String muntah_berlebihan, String nyeri, String pusing, int usia_kehamilan, String imunisasi, String pergreakan, int anc, String diperiksa, String obat,String norek) {
        ContentValues newValues = new ContentValues();
        newValues.put("KELUHAN", keluhan);
        newValues.put("HPHT", hpht);
        newValues.put("LAMA_MENSTRUASI", lama_menstruasi);
        newValues.put("BANYAKNYA", banyaknya);
        newValues.put("SIKLUS", siklus);
        newValues.put("LAMA", lama);
        newValues.put("BANYAK", banyak);
        newValues.put("RIWAYAT_PENDARAHAN", riwayat_pendarahan);
        newValues.put("MUNTAH_BERLEBIHAN", muntah_berlebihan);
        newValues.put("NYERI_ULU_HATI", nyeri);
        newValues.put("PUSING_BERAT", pusing);
        newValues.put("USIA_KEHAMILAN", usia_kehamilan);
        newValues.put("IMUNISASI", imunisasi);
        newValues.put("PERGERAKAN_JANIN", pergreakan);
        newValues.put("ANC", anc);
        newValues.put("DIPERIKSA_KE", diperiksa);
        newValues.put("OBAT", obat);
        newValues.put("NO_REKAP", norek);
        return db.insert("ANAMNESA", null, newValues);
    }

    public long updateAnamnesa(String keluhan,String hpht, int lama_menstruasi, int banyaknya, int siklus, int lama, int banyak, String riwayat_pendarahan, String muntah_berlebihan, String nyeri, String pusing, int usia_kehamilan, String imunisasi, String pergreakan, int anc, String diperiksa, String obat,String norek) {
        ContentValues newValues = new ContentValues();
        newValues.put("KELUHAN", keluhan);
        newValues.put("HPHT", hpht);
        newValues.put("LAMA_MENSTRUASI", lama_menstruasi);
        newValues.put("BANYAKNYA", banyaknya);
        newValues.put("SIKLUS", siklus);
        newValues.put("LAMA", lama);
        newValues.put("BANYAK", banyak);
        newValues.put("RIWAYAT_PENDARAHAN", riwayat_pendarahan);
        newValues.put("MUNTAH_BERLEBIHAN", muntah_berlebihan);
        newValues.put("NYERI_ULU_HATI", nyeri);
        newValues.put("PUSING_BERAT", pusing);
        newValues.put("USIA_KEHAMILAN", usia_kehamilan);
        newValues.put("IMUNISASI", imunisasi);
        newValues.put("PERGERAKAN_JANIN", pergreakan);
        newValues.put("ANC", anc);
        newValues.put("DIPERIKSA_KE", diperiksa);
        newValues.put("OBAT", obat);
        newValues.put("NO_REKAP", norek);
        return db.update("ANAMNESA", newValues,"NO_REKAP='"+norek+"'",null);
    }

    //ambil data mahasiswa berdasarkan nama
    public DBAnamnesa.Anamnesa getAnamnesa(String norek) {
        Cursor cur = null;
        DBAnamnesa.Anamnesa A = new DBAnamnesa.Anamnesa();

        //kolom yang diambil
        String selectQuery = "SELECT * FROM ANAMNESA WHERE NO_REKAP='"+norek+"'";
        cur = db.rawQuery(selectQuery,null);

        if (cur.getCount()>0) {  //ada data? ambil
            cur.moveToFirst();
            A.KELUHAN = cur.getString(1);
            A.HPHT = cur.getString(2);
            A.LAMA_MENSTRUASI = cur.getString(3);
            A.BANYAKNYA = cur.getString(4);
            A.SIKLUS = cur.getString(5);
            A.LAMA = cur.getString(6);
            A.BANYAK = cur.getString(7);
            A.RIWAYAT_PENDARAHAN = cur.getString(8);
            A.MUNTAH_BERLEBIHAN = cur.getString(9);
            A.NYERI_ULU_HATI = cur.getString(10);
            A.PUSING_BERAT = cur.getString(11);
            A.USIA_KEHAMILAN = cur.getString(12);
            A.IMUNISASI = cur.getString(13);
            A.PERGERAKAN_JANIN = cur.getString(14);
            A.ANC = cur.getString(15);
            A.DIPERIKSA_KE = cur.getString(16);
            A.OBAT_YANG_DIKONSUMSI = cur.getString(17);
            A.NO_REKAP = cur.getString(18);
        }

        return A;
    }

}
