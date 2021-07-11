package com.example.youmatter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AppDataBase extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "You_Matter";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Foods";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_IMAGEID = "IMAGE";
   /* public static final String COLUMN_MNUMBER = "Meter Number";
    public static final String COLUMN_AMOUNT = "Pending Amount";
    public static final String COLUMN_LUNIT = "Last Unit";
    public static final String COLUMN_CUNIT = "Current Unit"; */


    public AppDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, " +  COLUMN_IMAGEID + " TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    Cursor getData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db!= null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
