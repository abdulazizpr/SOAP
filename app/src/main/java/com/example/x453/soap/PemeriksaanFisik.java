package com.example.x453.soap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.x453.soap.DB.conf.DBIdentitasDiri;
import com.example.x453.soap.DB.conf.DBPemeriksaan;

public class PemeriksaanFisik extends AppCompatActivity {

    public final static String EXTRA_NOREK = "com.example.x453.soap.NOREK3";
    DBPemeriksaan.Pemeriksaan P;
    DBPemeriksaan db;
    String norek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemeriksaan_fisik);

        EditText bb_sebelum = (EditText) findViewById(R.id.berat_sebelum);
        EditText bb_sekarang = (EditText) findViewById(R.id.berat_sekarang);
        EditText tinggi_badan = (EditText) findViewById(R.id.tinggi_badan);
        EditText imt = (EditText) findViewById(R.id.imt);
        EditText tekanan_darah = (EditText) findViewById(R.id.tekanan_darah);
        EditText nadi = (EditText) findViewById(R.id.nadi);
        EditText respirasi = (EditText) findViewById(R.id.rr);
        EditText suhu = (EditText) findViewById(R.id.suhu);
        EditText mata = (EditText) findViewById(R.id.mata);
        EditText wajah = (EditText) findViewById(R.id.wajah);
        EditText mamma = (EditText) findViewById(R.id.mamma);
        EditText abodemen_i = (EditText) findViewById(R.id.abodemen_i);
        EditText abodemen_p = (EditText) findViewById(R.id.abodemen_p);
        EditText extrem_a = (EditText) findViewById(R.id.extrem_a);
        EditText extrem_b = (EditText) findViewById(R.id.extrem_b);
        EditText gen_luar = (EditText) findViewById(R.id.gen_luar);
        EditText pem_dalam = (EditText) findViewById(R.id.pem_dalam);

        db = new DBPemeriksaan(getApplicationContext());
        db.open();

        Intent intent2 = getIntent();
        norek = intent2.getStringExtra(Main3Activity.EXTRA_NOREK);
        P = db.getPemeriksaan(norek);

        bb_sebelum.setText(P.BB_SEBELUM);
        bb_sekarang.setText(P.BB_SEKARANG);
        tinggi_badan.setText(P.TINGGI_BADAN);
        imt.setText(P.IMT);
        tekanan_darah.setText(P.TEKANAN_DARAH);
        nadi.setText(P.NADI);
        respirasi.setText(P.RESPIRASI);
        suhu.setText(P.SUHU);
        mata.setText(P.MATA);
        wajah.setText(P.WAJAH);
        mamma.setText(P.MAMMA);
        abodemen_i.setText(P.ABODEMEN_INSPEKSI);
        abodemen_p.setText(P.ABODEMEN_PALPASI);
        extrem_a.setText(P.EXTREMITAS_ATAS);
        extrem_b.setText(P.EXTREMITAS_BAWAH);
        gen_luar.setText(P.GENITALIA_LUAR);
        pem_dalam.setText(P.PEMERIKSAAN_DALAM);

        db.close();
    }

    public void save_pf(View v){
        Intent intent3 = new Intent(this,Main3Activity.class);

        EditText bb_sebelum = (EditText) findViewById(R.id.berat_sebelum);
        EditText bb_sekarang = (EditText) findViewById(R.id.berat_sekarang);
        EditText tinggi_badan = (EditText) findViewById(R.id.tinggi_badan);
        EditText imt = (EditText) findViewById(R.id.imt);
        EditText tekanan_darah = (EditText) findViewById(R.id.tekanan_darah);
        EditText nadi = (EditText) findViewById(R.id.nadi);
        EditText respirasi = (EditText) findViewById(R.id.rr);
        EditText suhu = (EditText) findViewById(R.id.suhu);
        EditText mata = (EditText) findViewById(R.id.mata);
        EditText wajah = (EditText) findViewById(R.id.wajah);
        EditText mamma = (EditText) findViewById(R.id.mamma);
        EditText abodemen_i = (EditText) findViewById(R.id.abodemen_i);
        EditText abodemen_p = (EditText) findViewById(R.id.abodemen_p);
        EditText extrem_a = (EditText) findViewById(R.id.extrem_a);
        EditText extrem_b = (EditText) findViewById(R.id.extrem_b);
        EditText gen_luar = (EditText) findViewById(R.id.gen_luar);
        EditText pem_dalam = (EditText) findViewById(R.id.pem_dalam);

        db.open();
        if(P.NO_REKAP == null){
            db.insertPemeriksaan(
               Integer.parseInt(bb_sebelum.getText().toString()),
               Integer.parseInt(bb_sekarang.getText().toString()),
               Integer.parseInt(tinggi_badan.getText().toString()),
               Integer.parseInt(imt.getText().toString()),
               Integer.parseInt(tekanan_darah.getText().toString()),
               Integer.parseInt(nadi.getText().toString()),
               Integer.parseInt(respirasi.getText().toString()),
               Integer.parseInt(suhu.getText().toString()),
               mata.getText().toString(),
               wajah.getText().toString(),
               mamma.getText().toString(),
               abodemen_i.getText().toString(),
               abodemen_p.getText().toString(),
               extrem_a.getText().toString(),
               extrem_b.getText().toString(),
               gen_luar.getText().toString(),
               pem_dalam.getText().toString(),
               norek
            );
        }else{
            db.updatePemeriksaan(
                    Integer.parseInt(bb_sebelum.getText().toString()),
                    Integer.parseInt(bb_sekarang.getText().toString()),
                    Integer.parseInt(tinggi_badan.getText().toString()),
                    Integer.parseInt(imt.getText().toString()),
                    Integer.parseInt(tekanan_darah.getText().toString()),
                    Integer.parseInt(nadi.getText().toString()),
                    Integer.parseInt(respirasi.getText().toString()),
                    Integer.parseInt(suhu.getText().toString()),
                    mata.getText().toString(),
                    wajah.getText().toString(),
                    mamma.getText().toString(),
                    abodemen_i.getText().toString(),
                    abodemen_p.getText().toString(),
                    extrem_a.getText().toString(),
                    extrem_b.getText().toString(),
                    gen_luar.getText().toString(),
                    pem_dalam.getText().toString(),
                    norek
            );
        }

        db.close();
        intent3.putExtra(EXTRA_NOREK,norek);
        startActivity(intent3);

    }
}
