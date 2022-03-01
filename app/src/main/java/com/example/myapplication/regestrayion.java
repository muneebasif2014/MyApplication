package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class regestrayion extends AppCompatActivity {
    EditText name, pass, update;
    mydbadaptor helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestrayion);
        name=(EditText) findViewById(R.id.editext_name);
        pass=(EditText) findViewById(R.id.pass_edittext);
        helper= new mydbadaptor(this);
    }
    public void adduser(View view)
    {
        String t1 = name.getText().toString();
        String t2 = pass.getText().toString();
        if(t1.isEmpty() || t2.isEmpty())
        {
            Message.message(getApplicationContext(),"Enter Both Name and Password");
        }
        else
        {
            long id = helper.insertdata(t1,t2);
            if(id<=0)
            {
                Message.message(getApplicationContext(),"Insertion Unsuccessful");
                name.setText("");
                pass.setText("");
            } else
            {
                Message.message(getApplicationContext(),"Insertion Successful");
                name.setText("");
                pass.setText("");
            }
        }
    }
}