package com.example.x453.soap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Assesment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assesment);
    }

    public void klikButtonAs(View v) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
