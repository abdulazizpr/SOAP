package com.example.x453.soap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.x453.soap.DB.conf.DBRekapMedis;

public class Main2Activity extends AppCompatActivity {

    public final static String EXTRA_NOREK = "com.example.x453.soap.NOREK1";
    static final int ACT2_REQUEST = 99;  // request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void klikButton1(View v){
        Intent intent2 = new Intent(this,Main3Activity.class);

        EditText tgl_masuk = (EditText) findViewById(R.id.tgl_msk);
        EditText jam_masuk = (EditText) findViewById(R.id.jam_msk);
        EditText tgl_pengkajian = (EditText) findViewById(R.id.tgl_pengkajian);
        EditText jam_pengkajian = (EditText) findViewById(R.id.jam_pengkajian);
        EditText tempat_pengkajian = (EditText) findViewById(R.id.tempat_pengkajian);

        //inisiasi is
        DBRekapMedis db = new DBRekapMedis(getApplicationContext());
        db.open();

        String norek = db.getLastNoRekap();
        String lastNorek;
        if(norek == null){
            lastNorek = "RKP001";
        }else{
            int getNorek = Integer.parseInt(norek.substring(4,6));
            getNorek++;
            if(getNorek < 10) {
                lastNorek = "RKP00" + getNorek;
            } else if(getNorek >=10 && getNorek < 100){
                lastNorek = "RKP0" + getNorek;
            }else{
                lastNorek = "RKP" + getNorek;
            }
        }



        db.insertRekapMedis(lastNorek,tgl_masuk.getText().toString(),jam_masuk.getText().toString(),tgl_pengkajian.getText().toString(),
                jam_pengkajian.getText().toString(),tempat_pengkajian.getText().toString());

        intent2.putExtra(EXTRA_NOREK,lastNorek);
        startActivity(intent2);

    }
}
