package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class opponent_details extends AppCompatActivity {
public Button button;
EditText t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opponent_details);
        button = (Button) findViewById(R.id.button3);
        t1 = (EditText) findViewById(R.id.opponentname);
        t2 = (EditText) findViewById(R.id.oppolawyer) ;
        t3 = (EditText) findViewById(R.id.oppcontact) ;
        String case_num = getIntent().getStringExtra("keycasenumber");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oppname = t1.getText().toString();
                String opplawyer = t2.getText().toString();
                String oppcont = t3.getText().toString();
                casee_opponent_detail obj = new casee_opponent_detail(oppname ,    opplawyer,   oppcont);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference("casee_opponent_detail");
                node.child(case_num).setValue(obj);
                Intent i = new Intent(opponent_details.this, location_case.class);
                startActivity(i);
            }
        });
    }
}