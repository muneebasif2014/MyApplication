package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mainpage extends AppCompatActivity {
    public TextView textView , text, text2 , txt3, txt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);


        textView= (TextView) findViewById(R.id.txt1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v )  {
                Intent intent= new Intent(mainpage.this, casee.class);
                startActivity(intent);
            }

        });
    text = (TextView) findViewById(R.id.txt2);
    text.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mainpage.this, MainActivity.class);
            startActivity(intent);
        }
    });
text2=(TextView) findViewById(R.id.txt3);
text2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mainpage.this, clinte.class);
        startActivity(intent);
    }
});
txt3 = (TextView) findViewById(R.id.txt4);
txt3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent= new Intent(mainpage.this, Schedule.class);
        startActivity(intent);
    }
});
        txt4 = (TextView) findViewById(R.id.txt5);
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(mainpage.this, UPdate.class);
                startActivity(intent);
            }
        });


    }
}