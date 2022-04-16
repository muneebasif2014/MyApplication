package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
                String case_status_up = t1.getText().toString();
                String cas_num_up = t2.getText().toString();
                String case_name_up = t1.getText().toString();
                String case_date_up = t1.getText().toString();
                String case_update_up = t1.getText().toString();

                update_dataholder obj = new update_dataholder(case_status_up , case_name_up , case_date_up ,case_update_up );
           FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference("update_case");
                node.child(cas_num_up).setValue(obj);
                Toast.makeText(getApplicationContext(),"data insert", Toast.LENGTH_LONG).show();



            }
        });
    }
}