package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class lawyer extends AppCompatActivity {
    Button b1,b2;
    EditText t1,t2,t3,t4,t5,t6,t7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer);

        t1= (EditText) findViewById(R.id.lawyerid);
        t2= (EditText) findViewById(R.id.lawyername);
        t3= (EditText) findViewById(R.id.lawyernumber);
        t4= (EditText) findViewById(R.id.address);
        t5= (EditText) findViewById(R.id.category);
        t6= (EditText) findViewById(R.id.remarks);

        b1= (Button) findViewById(R.id.button_login);
        b2=(Button)findViewById(R.id.viewdata);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processinsert(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),t5.getText().toString(),t6.getText().toString());
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),userlist.class));
            }
        });


    }

    private void processinsert(String s, String n, String nb, String a, String c, String r)
    {
        String res=new DBHelper(this).addrecord(n,nb,a,c,r);
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }


}


