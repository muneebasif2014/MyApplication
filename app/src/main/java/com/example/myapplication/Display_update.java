package com.example.myapplication;

import static com.example.myapplication.DBmain_up.up;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class Display_update extends AppCompatActivity {
    DBmain_up dBmain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    MyAdaptor_up myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_update);
        dBmain=new DBmain_up(this);
        //create method
        findid();
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void displayData() {
        sqLiteDatabase=dBmain.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select *from "+up+"",null);
        ArrayList<update_dataholder> modelArrayList=new ArrayList<>();
        while (cursor.moveToNext()){

            String name=cursor.getString(0);
            String number=cursor.getString(1);
            String address=cursor.getString(2);
            String category=cursor.getString(3);
            String remarks=cursor.getString(4);
            modelArrayList.add(new update_dataholder( name, number,address,category,remarks));
        }
        cursor.close();
        myAdapter=new MyAdaptor_up(this,R.layout.singledata_up,modelArrayList,sqLiteDatabase);
        recyclerView.setAdapter(myAdapter);
    }

    private void findid() {
        recyclerView=findViewById(R.id.rv_up);
    }
}