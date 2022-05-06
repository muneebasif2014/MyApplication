package com.example.myapplication;

import static com.example.myapplication.DBmain.Clinte;
import static com.example.myapplication.DBmain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class displaydata_clinte extends AppCompatActivity {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    MyAdapter_clinte myAdapter_clinte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaydata_clinte);
        dBmain=new DBmain(this);
        //create method
        findid();
        displaydata();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void displaydata() {
        sqLiteDatabase=dBmain.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from "+Clinte+"",null);
        ArrayList<clinte_dataholder> modelArrayList=new ArrayList<>();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String email=cursor.getString(2);
            String number=cursor.getString(3);
            String address=cursor.getString(4);
            String city=cursor.getString(5);
            String remarks=cursor.getString(6);
            modelArrayList.add(new clinte_dataholder( name,email, number,address,city,remarks));
        }
        cursor.close();
        myAdapter_clinte=new MyAdapter_clinte(this,R.layout.sinflrdata_clinte,modelArrayList,sqLiteDatabase);
        recyclerView.setAdapter(myAdapter_clinte);
    }

    private void findid() {
        recyclerView=findViewById(R.id.rv_clinte);
    }
}