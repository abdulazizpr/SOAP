package com.example.x453.soap.DB.conf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abdul Aziz Priatna on 30/10/2016.
 */

public class OpenHelper extends SQLiteOpenHelper {

    //kalau ada upgrage, increment versi database
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dbSOAP.db";

    public static final String TABLE_REKAP_MEDIS = "CREATE TABLE REKAP_MEDIS (" +
                                                        "NO_REKAP TEXT PRIMARY KEY," +
                                                        "TGL_MASUK DATE," +
                                                        "JAM_MASUK TEXT," +
                                                        "TGL_PENGKAJIAN DATE," +
                                                        "JAM_PENGKAJIAN TEXT," +
                                                        "TEMPAT_PENGKAJIAN TEXT)";

    public static final String TABLE_IDENTITAS_PASIEN = "CREATE TABLE IDENTITAS_PASIEN (" +
                                                            "NO INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                            "NAMA TEXT," +
                                                            "UMUR INTEGER," +
                                                            "SUKU TEXT," +
                                                            "AGAMA TEXT," +
                                                            "PENDIDIKAN_TERAKHIR TEXT," +
                                                            "GOLDAR TEXT," +
                                                            "PEKERJAAN TEXT," +
                                                            "ALAMAT TEXT," +
                                                            "STATUS_PERNIKAHAN TEXT," +
                                                            "JENIS_IDENTITAS TEXT," +
                                                            "NO_REKAP INTEGER,"+
                                                            "FOREIGN KEY(NO_REKAP) REFERENCES REKAP_MEDIS(NO_REKAP))";

    public static final String TABLE_ANAMNESA = "CREATE TABLE ANAMNESA("+
                                                    "NO INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                    "KELUHAN TEXT," +
                                                    "HPHT DATE," +
                                                    "LAMA_MENSTRUASI INTEGER," +
                                                    "BANYAKNYA INTEGER," +
                                                    "SIKLUS INTEGER," +
                                                    "LAMA INTEGER," +
                                                    "BANYAK INTEGER," +
                                                    "RIWAYAT_PENDARAHAN TEXT," +
                                                    "MUNTAH_BERLEBIHAN TEXT," +
                                                    "NYERI_ULU_HATI TEXT," +
                                                    "PUSING_BERAT TEXT," +
                                                    "USIA_KEHAMILAN INTEGER," +
                                                    "IMUNISASI TEXT," +
                                                    "PERGERAKAN_JANIN TEXT," +
                                                    "ANC INTEGER," +
                                                    "DIPERIKSA_KE TEXT," +
                                                    "OBAT_YG_DIKONSUMSI TEXT," +
                                                    "NO_REKAP INTEGER,"+
                                                    "FOREIGN KEY(NO_REKAP) REFERENCES REKAP_MEDIS(NO_REKAP))";

    public static final String TABLE_PEMERIKSAAN_FISIK = "CREATE TABLE PEMERIKSAAN_FISIK(" +
                                                                "NO INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                                "BB_SEBELUM_HAMIL INTEGER," +
                                                                "BB_SEKARANG INTEGER," +
                                                                "TINGGI_BADAN INTEGER," +
                                                                "IMT INTEGER," +
                                                                "TEKANAN_DARAH INTEGER," +
                                                                "NADI INTEGER," +
                                                                "RESPIRASI INTEGER," +
                                                                "SUHU INTEGER," +
                                                                "MATA TEXT," +
                                                                "WAJAH TEXT," +
                                                                "MAMMA TEXT," +
                                                                "ABODEMEN_INSPEKSI TEXT," +
                                                                "ABODEMEN PALPASI TEXT," +
                                                                "EXTREMITAS_ATAS TEXT," +
                                                                "EXTREMITAS_BAWAH TEXT," +
                                                                "GENITALIA_LUAR TEXT," +
                                                                "PEMERIKSAAN_DALAM TEXT," +
                                                                "NO_REKAP INTEGER,"+
                                                                "FOREIGN KEY(NO_REKAP) REFERENCES REKAP_MEDIS(NO_REKAP))";

    public static final String TABLE_CATATAN = "CREATE TABLE CATATAN(" +
                                                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                    "CONTENT_CATATAN TEXT," +
                                                    "JENIS_CATATAN TEXT," +
                                                    "NO_REKAP INTEGER,"+
                                                    "FOREIGN KEY(NO_REKAP) REFERENCES REKAP_MEDIS(NO_REKAP))";


    public OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create database
        db.execSQL(TABLE_REKAP_MEDIS);      //tabel rekap medis
        db.execSQL(TABLE_IDENTITAS_PASIEN); //tabel identitas pasien
        db.execSQL(TABLE_ANAMNESA);         //tabel anamnesa
        db.execSQL(TABLE_PEMERIKSAAN_FISIK);//tabel pemeriksaan fisik
        db.execSQL(TABLE_CATATAN);//tabel pemeriksaan fisik

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //jika app diupgrade (diinstall yang baru) maka database akan dicreate ulang (data hilang)
        //jika tidak tidak ingin hilang, bisa diproses disini
        db.execSQL("DROP TABLE IF EXITS REKAP_MEDIS");
        db.execSQL("DROP TABLE IF EXITS IDENTITAS_PASIEN");
        db.execSQL("DROP TABLE IF EXITS ANAMNESA");
        db.execSQL("DROP TABLE IF EXITS PEMERIKSAAN_FISIK");
        db.execSQL("DROP TABLE IF EXITS CATATAN");

    }

}
