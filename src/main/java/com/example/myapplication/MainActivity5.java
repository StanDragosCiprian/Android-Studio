package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    private BDAplication myDB;
    private Button ButonPentruPreluareaIduluiDeStergere;
    private EditText EditTextdePreluareAId_uluiDeUpdata;
    private EditText EditTextdePreluareAId_uluiDeUpdataEngleza;
    private EditText EditTextdePreluareAId_uluiDeUpdataRomana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        myDB = new BDAplication(MainActivity5.this);
        ButonPentruPreluareaIduluiDeStergere=findViewById(R.id.ButonPentruExecutareaEvenimentuluiDeStergere);
        EditTextdePreluareAId_uluiDeUpdata=findViewById(R.id.IDpentruUpdataDatelorDinTabel);
        EditTextdePreluareAId_uluiDeUpdataEngleza=findViewById(R.id.UpdataEnglishDataFromTable);
        EditTextdePreluareAId_uluiDeUpdataRomana=findViewById(R.id.updataRomanaDataFromTable);
        ButonPentruPreluareaIduluiDeStergere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
boolean UpdataFromTable=myDB.updateData(EditTextdePreluareAId_uluiDeUpdata.getText().toString(), EditTextdePreluareAId_uluiDeUpdataEngleza.getText().toString(), EditTextdePreluareAId_uluiDeUpdataRomana.getText().toString(),"");
if(UpdataFromTable){
    Toast.makeText(MainActivity5.this, "mere", Toast.LENGTH_SHORT).show();
}else{
    Toast.makeText(MainActivity5.this, "nu mere", Toast.LENGTH_SHORT).show();
}
            }
        });
    }
}