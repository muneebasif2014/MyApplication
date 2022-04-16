package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

                String clinte_name = t1.getText().toString();
                String clinte_add = t2.getText().toString();
                String clinte_city = t3.getText().toString();
                String clinte_number= t4.getText().toString();
                String clinte_email = t5.getText().toString();
                String clinte_remarks = t6.getText().toString();

               clinte_dataholder obj = new clinte_dataholder( clinte_add, clinte_city, clinte_number, clinte_email, clinte_remarks);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference("clinte_data");
                node.child(clinte_name).setValue(obj);
                Toast.makeText(getApplicationContext(),"data insert", Toast.LENGTH_LONG).show();
            }
        });
    }


}