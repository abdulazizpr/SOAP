package com.example.x453.soap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PemeriksaanFisik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemeriksaan_fisik);
    }

    public void save_pf(View v){
        Intent intent3 = new Intent(this,Main3Activity.class);
        startActivity(intent3);

    }
}
