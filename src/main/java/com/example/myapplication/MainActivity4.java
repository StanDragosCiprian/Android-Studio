package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
    private String val;
    private TextView viewfirst;
    private EditText rover;
    private Button butver;
    private BDAplication myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle extras = getIntent().getExtras();
        myDB = new BDAplication(MainActivity4.this);
        Random rand = new Random();
        viewfirst = findViewById(R.id.Test);
        rover = findViewById(R.id.ZonaDePunereAIduluipentruAfiSters);
        List<String> Engleza = new ArrayList<String>();
        List<String> Romana = new ArrayList<String>();

        Cursor cur = myDB.getAllData();

        if (cur.getCount() == 0) {
            showMessage("Error", "No Data Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();

        while (cur.moveToNext()) {

            buffer.append("ID: " + cur.getString(0) + "\n");  // 0 is index here shows columns in database
            buffer.append("Name: " + cur.getString(1) + "\n");
            buffer.append("Surname: " + cur.getString(2) + "\n");
            Engleza.add(cur.getString(1));
            Romana.add(cur.getString(2));

            //Toast.makeText(MainActivity2.this, cur.getString(0), Toast.LENGTH_SHORT).show();
        }
        int valoareAleatorie = rand.nextInt(Engleza.size());
       // showMessage("Data", buffer.toString());
        String eng = Engleza.get(valoareAleatorie);
        String ro = Romana.get(valoareAleatorie);
        viewfirst.setText(eng);
        butver = findViewById(R.id.ver);
        butver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ro.equals(rover.getText().toString())) {
                    Toast.makeText(MainActivity4.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity4.this, ro, Toast.LENGTH_SHORT).show();
                }
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void showMessage(String error, String no_data_found) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(error);
        builder.setMessage(no_data_found);
        builder.show();
    }
}