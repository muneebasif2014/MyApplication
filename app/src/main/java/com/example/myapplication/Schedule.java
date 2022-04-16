package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Schedule extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5,t6;
    Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Spinner dropdown = findViewById(R.id.spinner1);

        String[] items = new String[]{"select Schedule type", "Meeting with clinte", "case Disussion ","Case hearing ","other"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);
        t1= (EditText) findViewById(R.id.case_status);
        t2= (EditText) findViewById(R.id.clientname);
        t3= (EditText) findViewById(R.id.casenum);
        t4= (EditText) findViewById(R.id.casename);
        t5= (EditText) findViewById(R.id.casedate);
        t6= (EditText) findViewById(R.id.scremsrk);
      b2= (Button) findViewById(R.id.button1);
      b2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

          }
      });

    }
}