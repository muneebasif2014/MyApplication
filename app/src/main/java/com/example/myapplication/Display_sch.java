package com.example.myapplication;

import static com.example.myapplication.Dbmain_sch.sch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class Display_sch extends AppCompatActivity {
    Dbmain_sch dBmain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    MyAdapter_sch myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sch);
        dBmain=new Dbmain_sch(this);
        //create method
        findid();
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void displayData() {
        sqLiteDatabase=dBmain.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select *from "+sch+"",null);
        ArrayList<Schedule_dataholder> modelArrayList=new ArrayList<>();
        while (cursor.moveToNext()){
            String id=cursor.getString(0);
            String name=cursor.getString(1);
            String number=cursor.getString(2);
            String address=cursor.getString(3);
            String category=cursor.getString(4);
            String remarks=cursor.getString(5);
            modelArrayList.add(new Schedule_dataholder(id, name, number,address,category,remarks));
        }
        cursor.close();
        myAdapter=new MyAdapter_sch(this,R.layout.singledata_sch,modelArrayList,sqLiteDatabase);
        recyclerView.setAdapter(myAdapter);
    }

    private void findid() {
        recyclerView=findViewById(R.id.rv_sch);
    }
}