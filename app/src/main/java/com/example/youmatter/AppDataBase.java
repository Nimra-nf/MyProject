package com.example.youmatter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AppDataBase extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "You_Matter";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Foods";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_IMAGEID = "IMAGE";
    public static final String COLUMN_CALORIES = "Calories";


    public static final String TABLE_NAME2 = "Admin";
    public static final String COLUMN_ID2 = "Id";
    public static final String COLUMN_USER_NAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";


    public AppDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, " +  COLUMN_IMAGEID + " TEXT, " + COLUMN_CALORIES + " TEXT);";
        db.execSQL(query);

        String query2 = "CREATE TABLE " + TABLE_NAME2 + " (" + COLUMN_ID2 +  " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USER_NAME + " TEXT, " +  COLUMN_PASSWORD + " TEXT);";
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertUser(String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_NAME, name);
        cv.put(COLUMN_PASSWORD, password);
        db.insert(TABLE_NAME2, null, cv);
    }

    public Cursor CheckAdmin(String uname){
        String query = "SELECT * FROM " + TABLE_NAME2 + " WHERE " + COLUMN_USER_NAME + " == '" + uname + "';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!= null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
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

    public void insertfood(String name, String imageid, int cal){
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues cn = new ContentValues();
        cn.put(COLUMN_NAME, name);
        cn.put(COLUMN_IMAGEID, imageid);
        cn.put(COLUMN_CALORIES, cal);
        long result = mydb.insert(TABLE_NAME,null, cn);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show();
        }

    }
}
