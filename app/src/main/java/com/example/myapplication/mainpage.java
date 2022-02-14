package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class mainpage extends AppCompatActivity {
    public TextView textView , text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);


        textView= (TextView) findViewById(R.id.textview1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mainpage.this, casee.class);
                startActivity(intent);
            }
        });
        text = (TextView) findViewById(R.id.text1);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mainpage.this, labtask.class);
                startActivity(i);
            }
        });

    }
}