package com.example.myapplication;

import static com.example.myapplication.DBmain_casee.Casee1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Display_Data_casee extends AppCompatActivity {
    DBmain_casee dBmain;
    SQLiteDatabase sqLiteDatabase;
    RecyclerView recyclerView;
    MyAdapter_casee myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data_casee);
        dBmain=new DBmain_casee(this);
        //create method
        findid();
        displayData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void displayData() {
        sqLiteDatabase=dBmain.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select *from "+Casee1+"",null);
        ArrayList<case_DataHolder> modelArrayList=new ArrayList<>();
        while (cursor.moveToNext()){
            String id=cursor.getString(0);
            String name=cursor.getString(1);
            String number=cursor.getString(2);
            String address=cursor.getString(3);
            String category=cursor.getString(4);
            String remarks=cursor.getString(5);
            modelArrayList.add(new case_DataHolder(id, name, number,address,category,remarks));
        }
        cursor.close();
        myAdapter=new MyAdapter_casee(this, R.layout.singledata_casee, modelArrayList, sqLiteDatabase) {
            @Override
            public ModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return super.onCreateViewHolder(parent, viewType);
            }
        };
        recyclerView.setAdapter(myAdapter);
    }

    private void findid() {
        recyclerView=findViewById(R.id.rv_casee);

    }
}