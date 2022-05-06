package com.example.myapplication;

import static com.example.myapplication.DBmain.Clinte;
import static com.example.myapplication.DBmain.TABLENAME;

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

public class clinte extends AppCompatActivity {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    EditText t1,t2,t3,t4,t5,t6;
    Button sunmite, display, edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinte);
        dBmain = new DBmain(this);
        //create method
        findid();
        insertData();
        editData();

      /*   sunmite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);


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
        });*/
    }

    private void editData() {
        if (getIntent().getBundleExtra("userdata")!=null){
            Bundle bundle=getIntent().getBundleExtra("userdata");

            t1.setText(bundle.getString("name"));
            t2.setText(bundle.getString("email"));
           t3.setText(bundle.getString("number"));
           t4.setText(bundle.getString("address"));
           t5.setText(bundle.getString("city"));

            t6.setText(bundle.getString("remarks"));
            edit.setVisibility(View.VISIBLE);
            sunmite.setVisibility(View.GONE);
        }
    }

    private void insertData() {
        sunmite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv = new ContentValues();
                cv.put("name", t1.getText().toString());
                cv.put("email", t2.getText().toString());
                cv.put("number", t3.getText().toString());
                cv.put("address", t4.getText().toString());
                cv.put("city", t5.getText().toString());
                cv.put("remarks", t6.getText().toString());

                sqLiteDatabase = dBmain.getWritableDatabase();
                Long recinsert = sqLiteDatabase.insert(Clinte, null, cv);
                if (recinsert != null) {
                    Toast.makeText(clinte.this, "successfully inserted data", Toast.LENGTH_SHORT).show();
                    //clear when click on submit
                   t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                } else {
                    Toast.makeText(clinte.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(clinte.this, displaydata_clinte.class);
                startActivity(intent);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues cv=new ContentValues();
                cv.put("name",t1.getText().toString());
                cv.put("email",t2.getText().toString());
                cv.put("number",t3.getText().toString());
                cv.put("address",t4.getText().toString());
                cv.put("city",t5.getText().toString());
                cv.put("remarks",t6.getText().toString());

                sqLiteDatabase=dBmain.getReadableDatabase();
                long recedit=sqLiteDatabase.update(TABLENAME,cv,"name="+t1,null);
                if (recedit!=-1){
                    Toast.makeText(clinte.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                    sunmite.setVisibility(View.VISIBLE);
                    edit.setVisibility(View.GONE);
                }else{
                    Toast.makeText(clinte.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void findid() {

        t1= (EditText) findViewById(R.id.name);
        t2= (EditText) findViewById(R.id.email);
        t3= (EditText) findViewById(R.id.number);
        t4= (EditText) findViewById(R.id.address);
        t5= (EditText) findViewById(R.id.city);
        t6= (EditText) findViewById(R.id.remarks);
        sunmite= (Button) findViewById(R.id.sumite_clinte);
    }


}