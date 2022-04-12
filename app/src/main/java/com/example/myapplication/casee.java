package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class casee extends AppCompatActivity {
public Button button;
EditText case_status, clinte_name,case_number,case_name,case_date,remarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casee);
        case_status= (EditText) findViewById(R.id.casestatus);
        clinte_name= (EditText) findViewById(R.id.clientname);
        case_number = (EditText) findViewById(R.id.casenumber);
        case_name = (EditText) findViewById(R.id.casename);
        case_date = (EditText)findViewById(R.id.casedate);
        remarks= (EditText)findViewById(R.id.remarks);
        button = (Button) findViewById(R.id.button_login );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             String casestatus= case_status.getText().toString();
               String clintename =clinte_name.getText().toString();
              String casenumber =  case_number.getText().toString();
               String casename =case_name.getText().toString();
              String casedate = case_date.getText().toString();
                String remark= remarks.getText().toString();

case_DataHolder obj = new case_DataHolder(casestatus, clintename,casename,casedate,remark);

            FirebaseDatabase db= FirebaseDatabase.getInstance();
                DatabaseReference node = db.getReference("casee");
                node.child(casenumber).setValue(obj);
                case_status.setText("");
                clinte_name.setText("");
                case_number.setText("");
                case_name.setText("");
                case_date.setText("");
                remarks.setText("");
                Toast.makeText(getApplicationContext(),"data insert", Toast.LENGTH_LONG).show();
               Intent intent = new Intent(casee.this, case_details.class);
                startActivity(intent);
            }
        });
    }
}