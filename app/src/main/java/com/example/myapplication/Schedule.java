package com.example.myapplication;

import static com.example.myapplication.Dbmain_sch.sch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Schedule extends AppCompatActivity {
    Dbmain_sch dBmain;
    SQLiteDatabase sqLiteDatabase;
    EditText t1,t2,t3,t4,t5,t6;
    Button b2,b3,edit;
    int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        dBmain = new Dbmain_sch(this);
        //create method
        findid();
        insertData();
        editData();

        Spinner dropdown = findViewById(R.id.spinner1);

        String[] items = new String[]{"select Schedule type", "Meeting with clinte", "case Disussion ","Case hearing ","other"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);

     /* b2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              String case_status = t1.getText().toString();
              String clintename = t2.getText().toString();
              String casenum = t3.getText().toString();
              String case_name =t4.getText().toString();
              String case_date = t5.getText().toString();
              String sc_remarks = t6.getText().toString();
              String drop = dropdown.getSelectedItem().toString();

              Schedule_dataholder obj = new Schedule_dataholder(case_status, drop ,clintename  , case_name, case_date , sc_remarks  );
              FirebaseDatabase db = FirebaseDatabase.getInstance();
              DatabaseReference node = db.getReference("Schedual");
              node.child(casenum).setValue(obj);
              Toast.makeText(getApplicationContext(),"data insert", Toast.LENGTH_LONG).show();
          }
      });*/

    }

    private void findid() {
        t1= (EditText) findViewById(R.id.casestatus);
        t2= (EditText) findViewById(R.id.clientname_sch);
        t3= (EditText) findViewById(R.id.casenumber_sch);
        t4= (EditText) findViewById(R.id.casename_sch);
        t5= (EditText) findViewById(R.id.casedate_sch);
        t6= (EditText) findViewById(R.id.remarks_sch);
        b2= (Button) findViewById(R.id.button_login_sch);
        b3= (Button) findViewById(R.id.button_show_sch);
        edit = (Button)findViewById(R.id.button_edit_sch);
    }

    private void editData() {
        if (getIntent().getBundleExtra("userdata")!=null){
            Bundle bundle=getIntent().getBundleExtra("userdata");

           t1.setText(bundle.getString("case_status"));
           t2.setText(bundle.getString("clinte_name"));
            t3.setText(bundle.getString("case_number"));
            t4.setText(bundle.getString("case_name"));
           t5.setText(bundle.getString("case_date"));
           t6.setText(bundle.getString("remarks_casee"));
            edit.setVisibility(View.VISIBLE);
            b2.setVisibility(View.GONE);
        }
    }

    private void insertData(){
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("case_status", t1.getText().toString());
                cv.put("clinte_name", t2.getText().toString());
                cv.put("case_number", t3.getText().toString());
                cv.put("case_name", t4.getText().toString());
                cv.put("case_date", t5.getText().toString());
                cv.put("remarks_casee", t6.getText().toString());

                sqLiteDatabase = dBmain.getWritableDatabase();
                Long recinsert = sqLiteDatabase.insert(sch, null, cv);
                if (recinsert != null) {
                    Toast.makeText(Schedule.this, "successfully inserted data", Toast.LENGTH_SHORT).show();
                    //clear when click on submit
                    t1.setText("");
                    t2.setText("");
                   t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                } else {
                    Toast.makeText(Schedule.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //when click on display button open display data activity
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Schedule.this, Display_sch.class);
                startActivity(intent);
            }
        });
        //storing edited data
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv=new ContentValues();
                cv.put("case_status",t1.getText().toString());
                cv.put("clinte_name",t2.getText().toString());
                cv.put("case_number",t3.getText().toString());
                cv.put("case_name",t4.getText().toString());
                cv.put("case_date",t5.getText().toString());
                cv.put("remarks_casee",t6.getText().toString());

                sqLiteDatabase=dBmain.getReadableDatabase();
                long recedit=sqLiteDatabase.update(sch,cv,"case_number="+t3,null);
                if (recedit!=-1){
                    Toast.makeText(Schedule.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                   b2.setVisibility(View.VISIBLE);
                    edit.setVisibility(View.GONE);
                }else{
                    Toast.makeText(Schedule.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}