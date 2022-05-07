package com.example.myapplication;


import static com.example.myapplication.DBmain_casee.Casee1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
public Button button, show, edit;
EditText case_status, clinte_name,case_number,case_name,case_date,remarks;
    DBmain_casee dBmain;
    SQLiteDatabase sqLiteDatabase;
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casee);
        dBmain = new DBmain_casee(this);
        //create method
        findid();
        insertData();
        editData();



/*
                String casestatus = case_status.getText().toString();
                String clintename = clinte_name.getText().toString();
                String casenumber = case_number.getText().toString();
                String casename = case_name.getText().toString();
                String casedate = case_date.getText().toString();
                String remark = remarks.getText().toString();
                */
/*case_DataHolder obj = new case_DataHolder(casestatus, clintename,casename,casedate,remark);

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
               intent.putExtra("keycasenumber",casenumber);
               startActivity(intent);
            */

        }

    private void editData() {
        if (getIntent().getBundleExtra("userdata")!=null){
            Bundle bundle=getIntent().getBundleExtra("userdata");
            id=bundle.getInt("id");
            case_status.setText(bundle.getString("case_status"));
            clinte_name.setText(bundle.getString("clinte_name"));
            case_number.setText(bundle.getString(" case_number"));
            case_name.setText(bundle.getString("case_name"));
            case_date.setText(bundle.getString(" case_date"));
            remarks.setText(bundle.getString("remarks"));
            edit.setVisibility(View.VISIBLE);
            button.setVisibility(View.GONE);
        }

    }

    private void insertData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("case_status", case_status.getText().toString());
                cv.put("clinte_name", clinte_name.getText().toString());
                cv.put("case_number", case_number.getText().toString());
                cv.put("case_name", case_name.getText().toString());
                cv.put("case_date", case_date.getText().toString());
                cv.put("remarks_casee", remarks.getText().toString());
                sqLiteDatabase = dBmain.getWritableDatabase();
                Long recinsert = sqLiteDatabase.insert(Casee1, null, cv);
                if (recinsert != null) {
                    Toast.makeText(casee.this, "successfully inserted data", Toast.LENGTH_SHORT).show();
                    //clear when click on submit
                    case_status.setText("");
                   case_name.setText("");
                    case_number.setText("");
                    clinte_name.setText("");
                    case_date.setText("");
                    remarks.setText("");
                } else {
                    Toast.makeText(casee.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(casee.this, Display_Data_casee.class);
                startActivity(intent);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv=new ContentValues();
                cv.put("case_status", case_status.getText().toString());
                cv.put("clinte_name", clinte_name.getText().toString());
                cv.put("case_number", case_number.getText().toString());
                cv.put("case_name", case_name.getText().toString());
                cv.put("case_date", case_date.getText().toString());
                cv.put("remarks_casee", remarks.getText().toString());

                sqLiteDatabase=dBmain.getReadableDatabase();
                long recedit=sqLiteDatabase.update(Casee1,cv,"case_number="+case_number,null);
                if (recedit!=-1){
                    Toast.makeText(casee.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                   button.setVisibility(View.VISIBLE);
                    edit.setVisibility(View.GONE);
                }else{
                    Toast.makeText(casee.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void findid() {
        case_status= (EditText) findViewById(R.id.casestatus_casee);
        clinte_name= (EditText) findViewById(R.id.clientname_casee);
        case_number = (EditText) findViewById(R.id.casenumber_casee);
        case_name = (EditText) findViewById(R.id.casename_casee);
        case_date = (EditText)findViewById(R.id.casedate_casee);
        remarks= (EditText)findViewById(R.id.remarks_casee);
        button = (Button) findViewById(R.id.button_login );
       show = (Button) findViewById(R.id.button_showdata_casee );
       edit = (Button) findViewById(R.id.edit_btn_casee);
    }
}
