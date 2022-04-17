package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class case_details extends AppCompatActivity {
public Button button ;
EditText t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_details);
        button = (Button) findViewById(R.id.button_login);

        t1 = (EditText)findViewById(R.id.case_type);
        t2 = (EditText)findViewById(R.id.case_charges);
        t3 = (EditText)findViewById(R.id.case_petitioner);
        t4 = (EditText)findViewById(R.id.case_reponder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String case_type = t1.getText().toString();
                String case_charges = t2.getText().toString();
                String case_petitioner= t3.getText().toString();
                String case_responder= t4.getText().toString();
                String case_numb = getIntent().getStringExtra("keycasenumber");
case_detail_Dataholder obj = new case_detail_Dataholder(case_type , case_charges ,     case_petitioner   , case_responder);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference("casee_opponent_detail");

                node.child(case_numb).setValue(obj);
                Intent intent= new Intent(case_details.this, opponent_details.class);
                startActivity(intent);
            }
        });
    }
}