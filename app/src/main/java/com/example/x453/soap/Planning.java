package com.example.x453.soap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.x453.soap.DB.conf.DBCatatan;

public class Planning extends AppCompatActivity {

    public final static String EXTRA_NOREK = "com.example.x453.soap.NOREK3";
    DBCatatan.Catatan C;
    DBCatatan db;
    String norek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        EditText catatan = (EditText) findViewById(R.id.isi_planning);
        db = new DBCatatan(getApplicationContext());

        db.open();
        Intent intent2 = getIntent();
        norek = intent2.getStringExtra(Main3Activity.EXTRA_NOREK);
        C = db.getCatatan("Planning",norek);

        catatan.setText(C.CONTENT_CATATAN);

        db.close();
    }

    public void klikPlanning(View v) {
        Intent intent = new Intent(this, Main3Activity.class);

        EditText catatan = (EditText) findViewById(R.id.isi_planning);

        db.open();
        if(C.NO_REKAP == null){
            db.insertCatatan(catatan.getText().toString(),"Planning",norek);
        }else{

            db.updateCatatan(catatan.getText().toString(),"Planning",norek);
        }

        intent.putExtra(EXTRA_NOREK,norek);
        startActivity(intent);
    }
}
