package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBmain_casee extends SQLiteOpenHelper {
    public static final String DBNAME="casee.db";
    public static final String Casee1="casee";
    public static final int VER=1;
    String query ;
    public DBmain_casee( Context context) {
        super(context, DBNAME, null, VER);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        query="create table "+Casee1+"(id integer primary key, case_status text,clinte_name text,case_number text,case_name text,case_date text,remarks_casee text)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        query="drop table if exists "+Casee1+"";

        db.execSQL(query);

        onCreate(db);

    }
}
