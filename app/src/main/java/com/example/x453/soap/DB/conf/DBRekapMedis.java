package com.example.x453.soap.DB.conf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Abdul Aziz Priatna on 30/10/2016.
 */

public class DBRekapMedis {

    public static class RekapMedis {
        public String NO_REKAP;
        public String TGL_MASUK;
        public String JAM_MASUK;
        public String TGL_PENGKAJIAN;
        public String JAM_PENGKAJIAN;
        public String TEMPAT_PENGKAJIAN;

        public RekapMedis(){
        }

        public void setAll(String no, String tgl_masuk,String jam_masuk, String tgl_pengkajian, String jam_pengkajian,String tempat_pengkajian){
            NO_REKAP = no;
            TGL_MASUK = tgl_masuk;
            JAM_MASUK = jam_masuk;
            TGL_PENGKAJIAN = tgl_pengkajian;
            JAM_PENGKAJIAN = jam_pengkajian;
            TEMPAT_PENGKAJIAN = tempat_pengkajian;
        }

    }

    private SQLiteDatabase db;
    private final OpenHelper dbHelper;

    public DBRekapMedis(Context c) {
        dbHelper =  new OpenHelper(c);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long insertRekapMedis(String no, String tgl_masuk,String jam_masuk, String tgl_pengkajian, String jam_pengkajian,String tempat_pengkajian) {
        ContentValues newValues = new ContentValues();
        newValues.put("NO_REKAP", no);
        newValues.put("TGL_MASUK", tgl_masuk);
        newValues.put("JAM_MASUK", jam_masuk);
        newValues.put("TGL_PENGKAJIAN", tgl_pengkajian);
        newValues.put("JAM_PENGKAJIAN", jam_pengkajian);
        newValues.put("TEMPAT_PENGKAJIAN", tempat_pengkajian);
        return db.insert("REKAP_MEDIS", null, newValues);
    }

    //ambil semua data rekap
    public ArrayList<String> getAllRekap() {
        Cursor cur = null;
        ArrayList<String> rkp = new ArrayList<>();

        //Mahasiswa M = new Mahasiswa();

        String selectQuery = "SELECT * FROM REKAP_MEDIS";
        cur = db.rawQuery(selectQuery,null);
        if(cur.moveToFirst()){
            do{
                //RekapMedis M = new RekapMedis();
                //M.setAll(cur.getString(1),cur.getString(2),cur.getString(3),cur.getString(4),cur.getString(5),cur.getString(6));
                rkp.add(cur.getString(0));
                //System.out.println(cur.getString(1));
            }while (cur.moveToNext());
        }
        cur.close();
        System.out.println("ok");
        return rkp;
    }


    //ambil data mahasiswa berdasarkan nama
    public String getLastNoRekap() {
        Cursor cur = null;
        String rkp = null ;

        //kolom yang diambil
        String selectQuery = "SELECT * FROM REKAP_MEDIS ORDER BY NO_REKAP DESC LIMIT 1";
        cur = db.rawQuery(selectQuery,null);

        if (cur.getCount()>0) {  //ada data? ambil
            cur.moveToFirst();
            rkp = cur.getString(0);
        }

        return rkp;
    }
}
