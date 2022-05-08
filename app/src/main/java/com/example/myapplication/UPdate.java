package com.example.myapplication;

import static com.example.myapplication.DBmain_up.up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UPdate extends AppCompatActivity {
    DBmain_up dBmain;
    SQLiteDatabase sqLiteDatabase;
    EditText t1,t2,t3,t4,t5;
    Button b2,b3;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        dBmain = new DBmain_up(this);
        //create method
        findid();
        insertData();
        editData();



       /* b2.setOnClickListener(new View.OnClickListener() {
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
        });*/
    }

    private void editData() {
        if (getIntent().getBundleExtra("userdata")!=null){
            Bundle bundle=getIntent().getBundleExtra("userdata");

           t1.setText(bundle.getString("case_status"));
           t2.setText(bundle.getString("case_number"));
          t3.setText(bundle.getString("case_name"));
            t4.setText(bundle.getString("case_date"));
          t5.setText(bundle.getString("update_up"));
            b2.setVisibility(View.VISIBLE);
            b3.setVisibility(View.GONE);
        }
    }

    private void insertData() {
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                ContentValues cv = new ContentValues();
                cv.put("case_status", t1.getText().toString());
                cv.put("case_number", t2.getText().toString());
                cv.put("case_name", t3.getText().toString());
                cv.put("case_date", t4.getText().toString());
                cv.put("update_up", t5.getText().toString());

                sqLiteDatabase = dBmain.getWritableDatabase();
                Long recinsert = sqLiteDatabase.insert(up, null, cv);
                if (recinsert != null) {
                    Toast.makeText(UPdate.this, "successfully inserted data", Toast.LENGTH_SHORT).show();
                    //clear when click on submit
                   t1.setText("");
                    t2.setText("");
                   t3.setText("");
                    t4.setText("");
                    t5.setText("");
                } else {
                    Toast.makeText(UPdate.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UPdate.this, Display_update.class);
                startActivity(intent);
            }
        });
    }

    private void findid() {
        t1= (EditText) findViewById(R.id.cases_status_up);
        t2= (EditText) findViewById(R.id.case_number_up);
        t3= (EditText) findViewById(R.id.case_name_up);
        t4= (EditText) findViewById(R.id.case_date_up);
        t5= (EditText) findViewById(R.id.update_up);
        b2= (Button) findViewById(R.id.button_login_up);
        b3= (Button) findViewById(R.id.button_show_up);

    }
}