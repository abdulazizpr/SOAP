package com.example.x453.soap;

import android.support.annotation.IntegerRes;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.x453.soap.DB.conf.DBIdentitasDiri;

public class Identitas_diri1 extends AppCompatActivity implements OnItemSelectedListener{


    public final static String EXTRA_NOREK = "com.example.x453.soap.NOREK3";
    DBIdentitasDiri.IdentitasDiri I;
    DBIdentitasDiri db;
    String norek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identitas_diri1);

        // ========================= Spinner untuk GOLONGAN DARAH ==========================

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("A");
        categories.add("B");
        categories.add("O");
        categories.add("AB");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        // ========================= Spinner untuk Pendidikan ==============================

        // Spinner element
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        // Spinner click listener
        spinner2.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();
        categories2.add("SD/Sederajat");
        categories2.add("SMP/Sederajat");
        categories2.add("SMA/Sederajat");
        categories2.add("D1");
        categories2.add("D2");
        categories2.add("D3");
        categories2.add("D4");
        categories2.add("S1");
        categories2.add("S2");
        categories2.add("S3");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner2.setAdapter(dataAdapter2);


        db = new DBIdentitasDiri(getApplicationContext());
        db.open();

        Intent intent2 = getIntent();
        norek = intent2.getStringExtra(Main3Activity.EXTRA_NOREK);
        I = db.getIdentitas(norek,"Istri");

        EditText nama = (EditText) findViewById(R.id.tfNamaIstri);
        EditText umur = (EditText) findViewById(R.id.tfUmurIstri);
        EditText suku = (EditText) findViewById(R.id.tfSukuIstri);
        EditText agama = (EditText) findViewById(R.id.tfAgamaIstri);
        spinner2.setSelection(dataAdapter2.getPosition(I.PEND_TERAKHIR));
        spinner.setSelection(dataAdapter.getPosition(I.GOL_DARAH));
        EditText pekerjaan = (EditText) findViewById(R.id.tfPekerjaan);
        EditText alamat = (EditText) findViewById(R.id.tfAlamat);
        EditText status_pernikahan = (EditText) findViewById(R.id.tfStatusPernikahan);

        nama.setText(I.NAMA);
        umur.setText(I.UMUR);
        suku.setText(I.SUKU);
        agama.setText(I.AGAMA);
        pekerjaan.setText(I.PEKERJAAN);
        alamat.setText(I.ALAMAT);
        status_pernikahan.setText(I.STATUS_PERNIKAHAN);

        db.close();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void klikButton(View v) {
        Intent intent2 = new Intent(this, Identitas_diri2.class);

        EditText nama = (EditText) findViewById(R.id.tfNamaIstri);
        EditText umur = (EditText) findViewById(R.id.tfUmurIstri);
        EditText suku = (EditText) findViewById(R.id.tfSukuIstri);
        EditText agama = (EditText) findViewById(R.id.tfAgamaIstri);
        Spinner pend_terakhir = (Spinner)findViewById(R.id.spinner2);
        Spinner gol_darah = (Spinner)findViewById(R.id.spinner);
        EditText pekerjaan = (EditText) findViewById(R.id.tfPekerjaan);
        EditText alamat = (EditText) findViewById(R.id.tfAlamat);
        EditText status_pernikahan = (EditText) findViewById(R.id.tfStatusPernikahan);

        db.open();
        if(I.NOREK == null){
            db.insertIdentitas(
                    nama.getText().toString(),
                    Integer.parseInt(umur.getText().toString()),
                    suku.getText().toString(),
                    agama.getText().toString(),
                    pend_terakhir.getSelectedItem().toString(),
                    gol_darah.getSelectedItem().toString(),
                    pekerjaan.getText().toString(),
                    alamat.getText().toString(),status_pernikahan.getText().toString(),
                    "Istri",norek);
        }else{
            db.updateIdentitas(
                    nama.getText().toString(),
                    Integer.parseInt(umur.getText().toString()),
                    suku.getText().toString(),
                    agama.getText().toString(),
                    pend_terakhir.getSelectedItem().toString(),
                    gol_darah.getSelectedItem().toString(),
                    pekerjaan.getText().toString(),
                    alamat.getText().toString(),status_pernikahan.getText().toString(),
                    "Istri",norek);
        }

        db.close();
        intent2.putExtra(EXTRA_NOREK,Main3Activity.EXTRA_NOREK);
        startActivity(intent2);
    }
}
