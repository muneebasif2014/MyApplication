package com.example.myapplication;

import static com.example.myapplication.DBmain.TABLENAME;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    EditText name, number,address,category,remarks;
    Button submit, display, edit;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dBmain = new DBmain(this);
        //create method
        findid();
        insertData();
        editData();
    }

    private void editData() {
        if (getIntent().getBundleExtra("userdata")!=null){
            Bundle bundle=getIntent().getBundleExtra("userdata");
            id=bundle.getInt("id");
            name.setText(bundle.getString("name"));
            number.setText(bundle.getString("number"));
            address.setText(bundle.getString("address"));
            category.setText(bundle.getString("category"));
            remarks.setText(bundle.getString("remarks"));
            edit.setVisibility(View.VISIBLE);
            submit.setVisibility(View.GONE);
        }
    }

    private void insertData() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name", name.getText().toString());
                cv.put("number", number.getText().toString());
                cv.put("address", address.getText().toString());
                cv.put("category", category.getText().toString());
                cv.put("remarks", remarks.getText().toString());

                sqLiteDatabase = dBmain.getWritableDatabase();
                Long recinsert = sqLiteDatabase.insert(TABLENAME, null, cv);
                if (recinsert != null) {
                    Toast.makeText(MainActivity.this, "successfully inserted data", Toast.LENGTH_SHORT).show();
                    //clear when click on submit
                    name.setText("");
                    number.setText("");
                    address.setText("");
                    category.setText("");
                    remarks.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //when click on display button open display data activity
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, DispalyData.class);
                startActivity(intent);
            }
        });
        //storing edited data
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv=new ContentValues();
                cv.put("name",name.getText().toString());
                cv.put("number",number.getText().toString());
                cv.put("address",address.getText().toString());
                cv.put("category",category.getText().toString());
                cv.put("remarks",remarks.getText().toString());

                sqLiteDatabase=dBmain.getReadableDatabase();
                long recedit=sqLiteDatabase.update(TABLENAME,cv,"id="+id,null);
                if (recedit!=-1){
                    Toast.makeText(MainActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                    submit.setVisibility(View.VISIBLE);
                    edit.setVisibility(View.GONE);
                }else{
                    Toast.makeText(MainActivity.this, "something wrong try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




    private void findid() {
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        address = (EditText) findViewById(R.id.address);
        category = (EditText) findViewById(R.id.category);
        remarks = (EditText) findViewById(R.id.remarks);
        submit = (Button) findViewById(R.id.submit_btn);
        display = (Button) findViewById(R.id.display_btn);
        edit = (Button) findViewById(R.id.edit_btn);
    }
}