package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class verticlal extends AppCompatActivity {
    EditText name, pass;
    mydbadaptor helper;


    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verticlal);
        name= (EditText) findViewById(R.id.ali1);
        pass= (EditText ) findViewById(R.id.pass);



        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(verticlal.this, mainpage.class);
                startActivity(intent);
            }
        });
    }
    public void  logindatabase()
    {

    }
}