package com.example.x453.soap;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.example.x453.soap.DB.conf.DBAnamnesa;
import com.example.x453.soap.DB.conf.DBIdentitasDiri;

public class Anamnesa extends AppCompatActivity implements OnItemSelectedListener {

    private EditText DateHPHT;
    public final static String EXTRA_NOREK = "com.example.x453.soap.NOREK5";
    private DatePickerDialog fromDatePickerDialog;

    private SimpleDateFormat dateFormatter;

    DBAnamnesa.Anamnesa A;
    DBAnamnesa db;
    String norek;

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

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        EditText keluhan = (EditText) findViewById(R.id.eTKeluhan);
        DateHPHT = (EditText) findViewById(R.id.etHPHT);
        DateHPHT.setInputType(InputType.TYPE_NULL);
        EditText lama_menstruasi = (EditText) findViewById(R.id.lamamens);
        EditText banyaknya = (EditText) findViewById(R.id.banyak);
        EditText siklus = (EditText) findViewById(R.id.siklus);
        EditText lamanya = (EditText) findViewById(R.id.lamanya);
        EditText banyak = (EditText) findViewById(R.id.banyaknya2);
        EditText usia_kehamilan = (EditText) findViewById(R.id.usiaKehamilan);
        EditText pergerakan = (EditText) findViewById(R.id.pergerakan);
        EditText anc = (EditText) findViewById(R.id.anc);
        EditText periksa = (EditText) findViewById(R.id.periksa);
        EditText obat = (EditText) findViewById(R.id.obat);

        db = new DBAnamnesa(getApplicationContext());
        db.open();

        Intent intent2 = getIntent();
        norek = intent2.getStringExtra(Main3Activity.EXTRA_NOREK);
        A = db.getAnamnesa(norek);

        keluhan.setText(A.KELUHAN);
        DateHPHT.setText(A.HPHT);
        lama_menstruasi.setText(A.LAMA_MENSTRUASI);
        banyaknya.setText(A.BANYAKNYA);
        siklus.setText(A.SIKLUS);
        lamanya.setText(A.LAMA);
        banyak.setText(A.BANYAK);
        spinner.setSelection(dataAdapter.getPosition(A.RIWAYAT_PENDARAHAN));
        spinner2.setSelection(dataAdapter2.getPosition(A.MUNTAH_BERLEBIHAN));
        spinner3.setSelection(dataAdapter3.getPosition(A.NYERI_ULU_HATI));
        spinner4.setSelection(dataAdapter4.getPosition(A.PUSING_BERAT));
        usia_kehamilan.setText(A.USIA_KEHAMILAN);
        spinner5.setSelection(dataAdapter4.getPosition(A.IMUNISASI));
        pergerakan.setText(A.PERGERAKAN_JANIN);
        anc.setText(A.ANC);
        periksa.setText(A.DIPERIKSA_KE);
        obat.setText(A.OBAT_YANG_DIKONSUMSI);

        db.close();

        setDateTimeField(DateHPHT);



    }

    private void setDateTimeField(final EditText Date) {
        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDatePickerDialog.show();
            }
        });

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                Date.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
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

        EditText keluhan = (EditText) findViewById(R.id.eTKeluhan);
        EditText HPHT = (EditText) findViewById(R.id.etHPHT);
        EditText lama_menstruasi = (EditText) findViewById(R.id.lamamens);
        EditText banyaknya = (EditText) findViewById(R.id.banyak);
        EditText siklus = (EditText) findViewById(R.id.siklus);
        EditText lamanya = (EditText) findViewById(R.id.lamanya);
        EditText banyak = (EditText) findViewById(R.id.banyaknya2);
        Spinner  riwayat_pendarahan = (Spinner) findViewById(R.id.spinner);
        Spinner  muntah_berlebihan = (Spinner) findViewById(R.id.spinner2);
        Spinner  nyeri_ulu_hati = (Spinner) findViewById(R.id.spinner3);
        Spinner  pusing_berat = (Spinner) findViewById(R.id.spinner4);
        EditText usia_kehamilan = (EditText) findViewById(R.id.usiaKehamilan);
        Spinner  imunisasi = (Spinner) findViewById(R.id.spinner5);
        EditText pergerakan = (EditText) findViewById(R.id.pergerakan);
        EditText anc = (EditText) findViewById(R.id.anc);
        EditText periksa = (EditText) findViewById(R.id.periksa);
        EditText obat = (EditText) findViewById(R.id.obat);

        db.open();
        if(A.NO_REKAP ==  null){
            db.insertAnamnesa(
                    keluhan.getText().toString(),
                    HPHT.getText().toString(),
                    Integer.parseInt(lama_menstruasi.getText().toString()),
                    Integer.parseInt(banyaknya.getText().toString()),
                    Integer.parseInt(siklus.getText().toString()),
                    Integer.parseInt(lamanya.getText().toString()),
                    Integer.parseInt(banyak.getText().toString()),
                    riwayat_pendarahan.getSelectedItem().toString(),
                    muntah_berlebihan.getSelectedItem().toString(),
                    nyeri_ulu_hati.getSelectedItem().toString(),
                    pusing_berat.getSelectedItem().toString(),
                    Integer.parseInt(usia_kehamilan.getText().toString()),
                    imunisasi.getSelectedItem().toString(),
                    pergerakan.getText().toString(),
                    Integer.parseInt(anc.getText().toString()),
                    periksa.getText().toString(),
                    obat.getText().toString(),
                    norek
            );
        }else{
            db.updateAnamnesa(
                    keluhan.getText().toString(),
                    HPHT.getText().toString(),
                    Integer.parseInt(lama_menstruasi.getText().toString()),
                    Integer.parseInt(banyaknya.getText().toString()),
                    Integer.parseInt(siklus.getText().toString()),
                    Integer.parseInt(lamanya.getText().toString()),
                    Integer.parseInt(banyak.getText().toString()),
                    riwayat_pendarahan.getSelectedItem().toString(),
                    muntah_berlebihan.getSelectedItem().toString(),
                    nyeri_ulu_hati.getSelectedItem().toString(),
                    pusing_berat.getSelectedItem().toString(),
                    Integer.parseInt(usia_kehamilan.getText().toString()),
                    imunisasi.getSelectedItem().toString(),
                    pergerakan.getText().toString(),
                    Integer.parseInt(anc.getText().toString()),
                    periksa.getText().toString(),
                    obat.getText().toString(),
                    norek
            );
        }

        db.close();
        intent.putExtra(EXTRA_NOREK,norek);
        startActivity(intent);
    }
}
