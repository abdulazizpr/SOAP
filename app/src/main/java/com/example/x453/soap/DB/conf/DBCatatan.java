package com.example.x453.soap.DB.conf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Abdul Aziz Priatna on 01/11/2016.
 */

public class DBCatatan {

    public static class Catatan {
        public String CONTENT_CATATAN;
        public String JENIS_CATATAN;
        public String NO_REKAP;
    }

    private SQLiteDatabase db;
    private final OpenHelper dbHelper;

    public DBCatatan (Context c) {
        dbHelper =  new OpenHelper(c);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public long insertCatatan(String content, String jenis,String norek) {
        ContentValues newValues = new ContentValues();
        newValues.put("CONTENT_CATATAN", content);
        newValues.put("JENIS_CATATAN", jenis);
        newValues.put("NO_REKAP", norek);
        return db.insert("CATATAN", null, newValues);
    }

    public long updateCatatan(String content, String jenis,String norek) {
        ContentValues newValues = new ContentValues();
        newValues.put("CONTENT_CATATAN", content);
        newValues.put("JENIS_CATATAN", jenis);
        newValues.put("NO_REKAP", norek);
        return db.update("CATATAN",  newValues,"NO_REKAP='"+norek+"' AND JENIS_CATATAN='"+jenis+"'",null);
    }

    //ambil data mahasiswa berdasarkan nama
    public Catatan getCatatan(String jenis,String norek) {
        Cursor cur = null;
        Catatan M = new Catatan();

        //kolom yang diambil
        String selectQuery = "SELECT * FROM CATATAN WHERE NO_REKAP='"+norek+"' AND JENIS_CATATAN='"+jenis+"'";
        cur = db.rawQuery(selectQuery,null);

        if (cur.getCount()>0) {  //ada data? ambil
            cur.moveToFirst();
            M.CONTENT_CATATAN = cur.getString(1);
            M.JENIS_CATATAN = cur.getString(2);
        }

        return M;
    }

}
