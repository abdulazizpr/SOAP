package com.example.x453.soap;

import android.content.Context;
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
import android.widget.Toast;

import com.example.x453.soap.DB.conf.DBRekapMedis;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //menggunakan arrayList untuk menyimpan
    //data yang akan ditampilkan
    private ArrayList<String> items = new ArrayList<>();
    public final static String EXTRA_NOREK = "com.example.x453.soap.NOREK";
    static final int ACT_REQUEST = 22;  // request code
    static final int ACT2_REQUEST = 25;  // request code
    private String selectedItem;                // Stores the selected list item
    private final Context context = this;        // This context
    public DBRekapMedis db;

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
        db = new DBRekapMedis(getApplicationContext());
        db.open();
        items = db.getAllRekap();
        db.close();

        final ListView listAngka = (ListView) findViewById(R.id.listAngka);
        listAngka.invalidateViews();

        adapter = new ArrayAdapter (this, android.R.layout.simple_expandable_list_item_1, items);

        listAngka.setClickable(true);
        listAngka.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                String isiBaris = (String) listAngka.getItemAtPosition(position);
                Intent intent2 = new Intent(getApplicationContext(),Main3Activity.class);
                intent2.putExtra(EXTRA_NOREK,isiBaris);
                startActivityForResult(intent2,ACT_REQUEST);
                //String pesan = "Posisi:"+position +"->"+ isiBaris;
                //Toast toast = Toast.makeText(getApplicationContext(), pesan, Toast.LENGTH_SHORT);
                //toast.show();
            }
        });

        listAngka.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long rowid) {

                // Store selected item in global variable
                selectedItem = parent.getItemAtPosition(position).toString();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Apakah anda yakin ingin menghapus " + selectedItem + "?");
                builder.setCancelable(false);
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        adapter.remove(selectedItem);
                        adapter.notifyDataSetChanged();
                        db = new DBRekapMedis(getApplicationContext());
                        db.open();
                        db.delete(selectedItem);
                        Toast.makeText(
                                getApplicationContext(),
                                selectedItem + " has been removed.",
                                Toast.LENGTH_SHORT).show();
                        db.close();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Create and show the dialog
                builder.show();

                // Signal OK to avoid further processing of the long click
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

    @Override
    protected void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }

    public void klikButton(View v){
        Intent intent1 = new Intent(this,Main2Activity.class);
        startActivityForResult(intent1,ACT2_REQUEST);
    }
}
