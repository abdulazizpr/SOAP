package com.example.x453.soap;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.x453.soap.DB.conf.DBRekapMedis;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //menggunakan arrayList untuk menyimpan
    //data yang akan ditampilkan
    private ArrayList<String> items = new ArrayList<>();
    static final int ACT2_REQUEST = 99;  // request code

    //penghubung antara data dengan listview
    ArrayAdapter adapter;
    int yesOrNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //inisiasi is
        DBRekapMedis db = new DBRekapMedis(getApplicationContext());
        db.open();
        items = db.getAllRekap();

        final ListView listAngka = (ListView) findViewById(R.id.listAngka);

        adapter = new ArrayAdapter (this, android.R.layout.simple_expandable_list_item_1, items);

        listAngka.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> av, View v, int pos, long id) {

                final AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setIcon(android.R.drawable.ic_dialog_alert);
                b.setMessage("Are you sure?");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        yesOrNo = 1;
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        yesOrNo = 0;
                    }
                });

                b.show();

                if (yesOrNo == 1) {
                    String selectedItem = items.get(pos);
                    items.remove(selectedItem);
                    adapter.notifyDataSetChanged();
                }

                return true;
            }
        });

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
        startActivityForResult(intent1,ACT2_REQUEST);
    }
}
