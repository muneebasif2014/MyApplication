package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class lawyer extends AppCompatActivity {
    Button b1;
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
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = t1.getText().toString();
                String name = t2.getText().toString();
                String num = t3.getText().toString();
                String addr = t4.getText().toString();
                String catag = t5.getText().toString();
                String rem = t6.getText().toString();

                Lawyer_details_dataholder obj = new Lawyer_details_dataholder(name, num, addr,catag,rem);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference("Lawyer");
                node.child(id).setValue(obj);
                Toast.makeText(getApplicationContext(),"data insert", Toast.LENGTH_LONG).show();
            }
        });
    }
}