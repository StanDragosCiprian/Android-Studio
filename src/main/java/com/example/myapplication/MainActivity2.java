package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private EditText z1;
    private EditText z2;
    private TextView tx;
    private TextView tx2;
    private Button btn;
    private Button joc;
    private BDAplication myDB;
    private Button ButonDeAfisareDate;
private String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tx = (TextView) findViewById(R.id.EngTV2);
        tx2 = (TextView) findViewById(R.id.RomTV);
        btn = findViewById(R.id.but);
        z1 = findViewById(R.id.Engleza);
        z2 = findViewById(R.id.Romana);
        myDB = new BDAplication(MainActivity2.this);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String value = extras.getString("key");
                    //The key argument here must match that used in the other activity
                    Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                }

                //myDB.onUpgrade(myDB.getWritableDatabase(), 1, 2);

                boolean isInserted = myDB.insertData(z1.getText().toString(), z2.getText().toString(), "");

                // Show toast when data inserted successfully
                if(isInserted){
                    Toast.makeText(MainActivity2.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity2.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }






            }
        });
        ButonDeAfisareDate=findViewById(R.id.IDAfisareDate);
        ButonDeAfisareDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cur = myDB.getAllData();

                if(cur.getCount() == 0){
                    showMessage("Error","No Data Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (cur.moveToNext()){

                    buffer.append("ID: "+ cur.getString(0)+"\n");  // 0 is index here shows columns in database
                    buffer.append("Engleza: "+ cur.getString(1)+"\n");
                    buffer.append("Romana: "+ cur.getString(2)+"\n");

                    //Toast.makeText(MainActivity2.this, cur.getString(0), Toast.LENGTH_SHORT).show();
                }
                showMessage("Data",buffer.toString());
            }
        });
joc=findViewById(R.id.Joc);
joc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(i);
    }
});

    }

    private void showMessage(String error, String no_data_found) {
        //myDB.onUpgrade(myDB.getWritableDatabase(),0,1);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(error);
        builder.setMessage(no_data_found);
        builder.show();
    }


}
