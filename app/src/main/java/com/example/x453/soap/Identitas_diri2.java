package com.example.x453.soap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.x453.soap.DB.conf.DBIdentitasDiri;

public class Identitas_diri2 extends AppCompatActivity implements OnItemSelectedListener {

    DBIdentitasDiri.IdentitasDiri I;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identitas_diri2);

        // ========================= Spinner untuk GOLONGAN DARAH ==========================

        // Spinner element
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);

        // Spinner click listener
        spinner3.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories3 = new ArrayList<String>();
        categories3.add("A");
        categories3.add("B");
        categories3.add("O");
        categories3.add("AB");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner3.setAdapter(dataAdapter3);


        // ========================= Spinner untuk Pendidikan =====================================

        // Spinner element
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);

        // Spinner click listener
        spinner4.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories4 = new ArrayList<String>();
        categories4.add("SD/Sederajat");
        categories4.add("SMP/Sederajat");
        categories4.add("SMA/Sederajat");
        categories4.add("D1");
        categories4.add("D2");
        categories4.add("D3");
        categories4.add("D4");
        categories4.add("S1");
        categories4.add("S2");
        categories4.add("S3");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories4);

        // Drop down layout style - list view with radio button
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner4.setAdapter(dataAdapter4);

        DBIdentitasDiri db = new DBIdentitasDiri(getApplicationContext());
        db.open();

        I = db.getIdentitas(Identitas_diri1.EXTRA_NOREK,"Suami");

        EditText nama = (EditText) findViewById(R.id.tfNamaSuami);
        EditText umur = (EditText) findViewById(R.id.tfUmurSuami);
        EditText suku = (EditText) findViewById(R.id.tfSukuSuami);
        EditText agama = (EditText) findViewById(R.id.tfAgamaSuami);
        spinner4.setSelection(dataAdapter4.getPosition(I.PEND_TERAKHIR));
        spinner3.setSelection(dataAdapter3.getPosition(I.GOL_DARAH));
        EditText pekerjaan = (EditText) findViewById(R.id.tfPekerjaanSuami);
        EditText alamat = (EditText) findViewById(R.id.tfAlamatSuami);
        EditText status_pernikahan = (EditText) findViewById(R.id.tfSPSuami);

        nama.setText(I.NAMA);
        umur.setText(I.UMUR);
        suku.setText(I.SUKU);
        agama.setText(I.AGAMA);
        pekerjaan.setText(I.PEKERJAAN);
        alamat.setText(I.ALAMAT);
        status_pernikahan.setText(I.STATUS_PERNIKAHAN);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void save_id(View v){
        Intent intent3 = new Intent(this,Main3Activity.class);
        startActivity(intent3);

    }
}
