package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBmain_up extends SQLiteOpenHelper {
    public static final String DBNAME="update_activity.db";
    public static final String up="update_up";
    public static final int VER=1;
    String query ;
    public DBmain_up(Context context) {
        super(context, DBNAME, null, VER);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        query="create table " +up+" ( case_status text,case_number text,case_name text,case_date text,update_up text)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        query="drop table if exists "+up+"";

        db.execSQL(query);

        onCreate(db);

    }
}
