package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        t1= (EditText) findViewById(R.id.casestatus);
        t2= (EditText) findViewById(R.id.clientname);
        t3= (EditText) findViewById(R.id.casenumber);
        t4= (EditText) findViewById(R.id.casename);
        t5= (EditText) findViewById(R.id.casedate);
        t6= (EditText) findViewById(R.id.remarks);
      b2= (Button) findViewById(R.id.button_login);
      b2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              String case_status = t1.getText().toString();
              String clintename = t2.getText().toString();
              String casenum = t3.getText().toString();
              String case_name =t4.getText().toString();
              String case_date = t5.getText().toString();
              String sc_remarks = t6.getText().toString();
              String drop = dropdown.getSelectedItem().toString();

              Schedule_dataholder obj = new Schedule_dataholder(case_status, drop ,clintename  , case_name, case_date , sc_remarks  );
              FirebaseDatabase db = FirebaseDatabase.getInstance();
              DatabaseReference node = db.getReference("Schedual");
              node.child(casenum).setValue(obj);
              Toast.makeText(getApplicationContext(),"data insert", Toast.LENGTH_LONG).show();
          }
      });

    }
}