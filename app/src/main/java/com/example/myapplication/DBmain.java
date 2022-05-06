package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {
    public static final String DBNAME="lawyer.db";
    public static final String TABLENAME="lawyer";
    public static final String Clinte="Clinte";

    public static final int VER=1;
    String query , query2;
    public DBmain(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        query="create table "+TABLENAME+"(id integer primary key, name text, number text,address text,category text,remarks text)";
        query2 = "create table "+Clinte+"(id integer primary key, name text,email text, number text,address text,city text,remarks text)";

        db.execSQL(query);
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        query="drop table if exists "+TABLENAME+"";
        query="drop table if exists "+Clinte+"";

        db.execSQL(query);

        onCreate(db);
        db.execSQL(query2);
        onCreate(db);
    }

}

