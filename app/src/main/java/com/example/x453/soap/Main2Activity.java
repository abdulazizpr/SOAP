package com.example.x453.soap;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.x453.soap.DB.conf.DBRekapMedis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    public final static String EXTRA_NOREK = "com.example.x453.soap.NOREK1";
    static final int ACT2_REQUEST = 99;  // request code

    private SimpleDateFormat dateFormatter;
    private DatePickerDialog tgl_msk;
    private DatePickerDialog tgl_pkj;

    private EditText jam_masuk;
    private EditText jam_pengkajian;
    private int mHour,mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        EditText tgl_masuk = (EditText) findViewById(R.id.tgl_msk);
        tgl_masuk.setInputType(InputType.TYPE_NULL);
        EditText tgl_pengkajian = (EditText) findViewById(R.id.tgl_pengkajian);
        tgl_pengkajian.setInputType(InputType.TYPE_NULL);

        setDateTimeField(tgl_masuk,tgl_pengkajian);

        jam_masuk = (EditText) findViewById(R.id.jam_msk);
        jam_pengkajian = (EditText) findViewById(R.id.jam_pengkajian);
        jam_masuk.setInputType(InputType.TYPE_NULL);
        jam_pengkajian.setInputType(InputType.TYPE_NULL);
        jam_masuk.setOnClickListener(this);
        jam_pengkajian.setOnClickListener(this);

    }

    private void setDateTimeField(final EditText Date1,final EditText Date2) {

        //tanggal masuk
        Date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tgl_msk.show();
            }
        });

        Calendar newCalendar = Calendar.getInstance();

        tgl_msk = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                Date1.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        //tanggal pengkajian
        Date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tgl_pkj.show();
            }
        });


        Calendar newCalendar2 = Calendar.getInstance();
        tgl_pkj = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                Date2.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar2.get(Calendar.YEAR), newCalendar2.get(Calendar.MONTH), newCalendar2.get(Calendar.DAY_OF_MONTH));
    }

    public void klikButton1(View v){
        Intent intent2 = new Intent(this,Main3Activity.class);

        EditText tgl_masuk = (EditText) findViewById(R.id.tgl_msk);
        EditText jam_msk = (EditText) findViewById(R.id.jam_msk);
        EditText tgl_pengkajian = (EditText) findViewById(R.id.tgl_pengkajian);
        EditText jam_pkj = (EditText) findViewById(R.id.jam_pengkajian);
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

        String input1 = tgl_masuk.getText().toString();
        if(TextUtils.isEmpty(input1)) {
            tgl_masuk.setError("Tanggal Masuk Harus Diisi !");
            return;
        }

        String input2 = jam_msk.getText().toString();
        if(TextUtils.isEmpty(input2)) {
            jam_masuk.setError("Jam Masuk Harus Diisi !");
            return;
        }

        String input3 = tgl_pengkajian.getText().toString();
        if(TextUtils.isEmpty(input3)) {
            tgl_pengkajian.setError("Tanggal Pengkajian Harus Diisi !");
            return;
        }

        String input4 = jam_pkj.getText().toString();
        if(TextUtils.isEmpty(input4)) {
            jam_pengkajian.setError("Jam Pengkajian Harus Diisi !");
            return;
        }

        String input5 = tempat_pengkajian.getText().toString();
        if(TextUtils.isEmpty(input5)) {
            tempat_pengkajian.setError("Tempat Pengkajian Harus Diisi !");
            return;
        }

        db.insertRekapMedis(lastNorek,tgl_masuk.getText().toString(),jam_msk.getText().toString(),tgl_pengkajian.getText().toString(),
                jam_pkj.getText().toString(),tempat_pengkajian.getText().toString());

        intent2.putExtra(EXTRA_NOREK,lastNorek);
        startActivity(intent2);

    }

    @Override
    public void onClick(View v) {
        if(v == jam_masuk){
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            jam_masuk.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }else if(v == jam_pengkajian){
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            jam_pengkajian.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}
