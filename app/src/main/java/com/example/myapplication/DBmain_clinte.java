package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmain_clinte extends SQLiteOpenHelper {
    public static final String DBNAME="clinte.db";

    public static final String Clinte="Clinte";

    public static final int VER=1;
    String query ;
    public DBmain_clinte(@Nullable Context context) { super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        query = "create table "+Clinte+"(id integer primary key, name text,email text, number text,address text,city text,remarks text)";

        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        query="drop table if exists "+Clinte+"";


        db.execSQL(query);

        onCreate(db);

    }

}
