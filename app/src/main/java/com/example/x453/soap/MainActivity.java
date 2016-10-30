package com.example.x453.soap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //menggunakan arrayList untuk menyimpan
    //data yang akan ditampilkan
    private ArrayList<String> items = new ArrayList<>();

    //penghubung antara data dengan listview
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //inisiasi isi
        items.add("satu");
        items.add("dua");
        items.add("tiga");
        items.add("empat");
        items.add("lima");
        final ListView listAngka = (ListView) findViewById(R.id.listAngka);


       /*buat adapter
       3 parameter:
          - context:
          - layout listview: disini kita menggunakan yg sudah ada (nantinya bisa custom)
          - datanya: items
       */
        adapter = new ArrayAdapter (this, android.R.layout.simple_expandable_list_item_1, items);

        //set adapter ke listview
        listAngka.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void klikButton(View v){
        Intent intent1 = new Intent(this,Main2Activity.class);
        startActivity(intent1);
    }
}
