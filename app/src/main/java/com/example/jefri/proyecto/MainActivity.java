package com.example.jefri.proyecto;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner;
    EditText editText;
    TextView textView;
    TextView textView2;
    double us;
    double euro;
    double peso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        editText = findViewById(R.id.rode);
        textView = findViewById(R.id.txt);
        textView2 = findViewById(R.id.txt2);
        findViewById(R.id.calculate).setOnClickListener(this);
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.Coin, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        if(editText.getText().toString().equals("")){

            Toast.makeText(this, "please enter a quantity", Toast.LENGTH_SHORT).show();
        }else {

            if(spinner.getSelectedItemPosition()==0){

                us = Double.parseDouble(editText.getText().toString());
                double usToPeso =  us * 49.97;
                double usToEuro = us * 0.86046;

                textView.setText("Peso: "+ usToPeso);
                textView2.setText("Euro: "+ usToEuro);

            }else if(spinner.getSelectedItemPosition()==1){

                euro = Double.parseDouble(editText.getText().toString());
                double euroToPeso = euro * 57.5331;
                double euroToUs = euro * 1.16203;
                textView.setText("Peso: "+ euroToPeso);
                textView2.setText("Dollar: "+ euroToUs);

            }else {

                peso = Double.parseDouble(editText.getText().toString());
                double pesoToUs = peso * 0.01990;
                double pesoToEuro = peso * 0.01712;
                textView.setText("Euro: "+ pesoToEuro);
                textView2.setText("Dollar: "+ pesoToUs);
            }
        }
    }
}
