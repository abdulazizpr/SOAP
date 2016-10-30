package com.example.x453.soap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DataPenunjang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_penunjang);
    }

    public void klikButtonDP(View v) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
