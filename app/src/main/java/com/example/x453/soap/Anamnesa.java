package com.example.x453.soap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Anamnesa extends AppCompatActivity implements OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnesa);
        // ========================= Spinner untuk Riwayat Pendarahan ==========================

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Pernah");
        categories.add("Tidak Pernah");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        // ========================= Spinner untuk Muntah Berlebihan ==========================

        // Spinner element
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        // Spinner click listener
        spinner2.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();
        categories2.add("Pernah");
        categories2.add("Tidak Pernah");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner2.setAdapter(dataAdapter2);

        // ========================= Spinner untuk Nyeri Ulu Hati ==========================

        // Spinner element
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);

        // Spinner click listener
        spinner3.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories3 = new ArrayList<String>();
        categories3.add("Pernah");
        categories3.add("Tidak Pernah");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner3.setAdapter(dataAdapter3);


        // ========================= Spinner untuk Pusing Berat ==========================

        // Spinner element
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);

        // Spinner click listener
        spinner4.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories4 = new ArrayList<String>();
        categories4.add("Pernah");
        categories4.add("Tidak Pernah");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories4);

        // Drop down layout style - list view with radio button
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner4.setAdapter(dataAdapter4);

        // ========================= Spinner untuk Imunisasi ==========================

        // Spinner element
        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);

        // Spinner click listener
        spinner5.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories5 = new ArrayList<String>();
        categories5.add("Pernah");
        categories5.add("Tidak Pernah");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories5);

        // Drop down layout style - list view with radio button
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner5.setAdapter(dataAdapter5);


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

    public void klikButtonAm(View v) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
