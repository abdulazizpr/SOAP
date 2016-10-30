package com.example.x453.soap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    //untuk pemeriksaan fisik
    public void klikButton3(View v){
        Intent intent3 = new Intent(this,PemeriksaanFisik.class);
        startActivity(intent3);

    }

    //untuk identitas dir
    public void klikButtonID(View v){
        Intent intent4 = new Intent(this,Identitas_diri1.class);
        startActivity(intent4);

    }

    //untuk data penunjang
    public void klikDP(View v){
        Intent intent5 = new Intent(this,DataPenunjang.class);
        startActivity(intent5);
    }

    //untuk assesment
    public void klikAs(View v) {
        Intent intent = new Intent(this, Assesment.class);
        startActivity(intent);
    }

    //untuk planning
    public void klikPl(View v) {
        Intent intent = new Intent(this, Planning.class);
        startActivity(intent);
    }

    //untuk anamnesa
    public void klikAnam(View v) {
        Intent intent = new Intent(this, Anamnesa.class);
        startActivity(intent);
    }


}
