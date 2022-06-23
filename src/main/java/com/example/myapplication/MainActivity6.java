package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity6 extends AppCompatActivity {
    private BDAplication myDB;
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button but5;
    private Button but6;
    private Button but7;
    private Button but8;
    private Button but9;
    private Button but10;
    private Button but11;
    private Button but12;
    private Button butonNotzl;
    private TextView varPreluareAEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        varPreluareAEditText = findViewById(R.id.IDpentruApuneEnglezaAici);
        but1 = findViewById(R.id.ButonDeVerificareRaspunsului1);
        but2 = findViewById(R.id.butonDeVerificareRaspunsului2);
        but3 = findViewById(R.id.butonDeVerificareRaspunsului3);
        but4 = findViewById(R.id.butonDeVerificareRaspunsului4);
        but5 = findViewById(R.id.butonDeVerificareRaspunsului5);
        but6 = findViewById(R.id.butonDeVerificareRaspunsului6);
        but7 = findViewById(R.id.butonDeVerificareRaspunsului7);
        but8 = findViewById(R.id.butonDeVerificareRaspunsului8);
        but9 = findViewById(R.id.butonDeVerificareRaspunsului9);
        but10 = findViewById(R.id.butonDeVerificareRaspunsului10);
        but11 = findViewById(R.id.butonDeVerificareRaspunsului11);
        but12 = findViewById(R.id.butonDeVerificareRaspunsului12);

        myDB = new BDAplication(MainActivity6.this);


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
            buffer.append("Engleza: " + cur.getString(1) + "\n");
            buffer.append("Romana: " + cur.getString(2) + "\n");
            Engleza.add(cur.getString(1));
            Romana.add(cur.getString(2));

            //Toast.makeText(MainActivity2.this, cur.getString(0), Toast.LENGTH_SHORT).show();
        }

        ArrayList numbers = new ArrayList();
        for (int i = 1; i < Engleza.size(); i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        int[] arr = new int[numbers.size()];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (int) numbers.get(i);
        }
        Random random = new Random();
        Random rand = new Random();


        int SaveRand = random.nextInt(Engleza.size());
        // showMessage("Data", buffer.toString());
        String eng = Engleza.get(SaveRand);
        String ro = Romana.get(SaveRand);
        varPreluareAEditText.setText(eng);
        boolean s = false;
        for (int i = 1; i < 12; i++) {
            if (arr[i] == SaveRand) {
                s = true;
                break;
            } else {
                s = false;
            }
        }
        int zz = 11;
        if (!s) {
            arr[rand.nextInt(zz + 1)] = SaveRand;
        }


        but1.setText(Romana.get(arr[1]));
        but2.setText(Romana.get(arr[2]));
        but3.setText(Romana.get(arr[3]));
        but4.setText(Romana.get(arr[4]));
        but5.setText(Romana.get(arr[5]));
        but6.setText(Romana.get(arr[6]));
        but7.setText(Romana.get(arr[7]));
        but8.setText(Romana.get(arr[8]));
        but9.setText(Romana.get(arr[9]));
        but10.setText(Romana.get(arr[10]));
        but11.setText(Romana.get(arr[11]));
        but12.setText(Romana.get(arr[12]));


        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity6.this, "FTS", Toast.LENGTH_SHORT).show();
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but1.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but2.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but3.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but4.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but5.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but6.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but7.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but8.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but9.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but10.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but11.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        but12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("zzzzzzzzzzaaa");
                if (ro.equals(but12.getText().toString())) {
                    Toast.makeText(MainActivity6.this, "Bravo esti destept", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                } else {
                    Toast.makeText(MainActivity6.this, ro, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
        butonNotzl = findViewById(R.id.Notz);
        butonNotzl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void showMessage(String error, String no_data_found) {
    }
}