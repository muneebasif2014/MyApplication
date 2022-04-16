package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class clinte extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5,t6;
    Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinte);

        t1= (EditText) findViewById(R.id.clinte_name);
        t2= (EditText) findViewById(R.id.Add_clinte);
        t3= (EditText) findViewById(R.id.city_clinte);
        t4= (EditText) findViewById(R.id.num_clinte);
        t5= (EditText) findViewById(R.id.emil_clinte);
        t6= (EditText) findViewById(R.id.remarks_clinte);
        b2= (Button) findViewById(R.id.button_clinte);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}