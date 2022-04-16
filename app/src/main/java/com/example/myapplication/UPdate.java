package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UPdate extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        t1= (EditText) findViewById(R.id.case_status_up);
        t2= (EditText) findViewById(R.id.up_CASe_num);
        t3= (EditText) findViewById(R.id.up_case_name);
        t4= (EditText) findViewById(R.id.up_cASe_date);
        t5= (EditText) findViewById(R.id.Up_update);
        b2= (Button) findViewById(R.id.button_up);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}