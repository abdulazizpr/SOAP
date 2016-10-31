package com.example.x453.soap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    public final static String EXTRA_NOREK = "com.example.x453.soap.NOREK2";
    static final int ACT_REQUEST = 22;  // request code
    static final int ACT2_REQUEST = 25;  // request code

    public String norek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent2 = getIntent();

        if(intent2.getStringExtra(MainActivity.EXTRA_NOREK) != null){
            norek =  intent2.getStringExtra(MainActivity.EXTRA_NOREK);
        }else{
            norek =  intent2.getStringExtra(Main2Activity.EXTRA_NOREK);
        }
        Toast toast = Toast.makeText(getApplicationContext(), norek , Toast.LENGTH_SHORT);
        toast.show();
    }

    //untuk pemeriksaan fisik
    public void klikButton3(View v){
        Intent intent3 = new Intent(this,PemeriksaanFisik.class);

        intent3.putExtra(EXTRA_NOREK, norek);
        startActivityForResult(intent3,ACT2_REQUEST);
    }

    //untuk identitas dir
    public void klikButtonID(View v){
        Intent intent4 = new Intent(this,Identitas_diri1.class);

        intent4.putExtra(EXTRA_NOREK, norek);
        startActivityForResult(intent4,ACT2_REQUEST);

    }

    //untuk data penunjang
    public void klikDP(View v){
        Intent intent5 = new Intent(this,DataPenunjang.class);

        intent5.putExtra(EXTRA_NOREK, norek);
        startActivityForResult(intent5,ACT2_REQUEST);
    }

    //untuk assesment
    public void klikAs(View v) {
        Intent intent = new Intent(this, Assesment.class);

        intent.putExtra(EXTRA_NOREK,Main2Activity.EXTRA_NOREK);

        intent.putExtra(EXTRA_NOREK, norek);
        startActivityForResult(intent,ACT2_REQUEST);
    }

    //untuk planning
    public void klikPl(View v) {
        Intent intent = new Intent(this, Planning.class);

        intent.putExtra(EXTRA_NOREK, norek);
        startActivityForResult(intent,ACT2_REQUEST);
    }

    //untuk anamnesa
    public void klikAnam(View v) {
        Intent intent = new Intent(this, Anamnesa.class);

        intent.putExtra(EXTRA_NOREK, norek);
        startActivityForResult(intent,ACT2_REQUEST);
    }


}
