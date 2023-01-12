package com.example.herewego;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database_Helper extends SQLiteOpenHelper {
    public static final String DBNAme = "Login.db";
    Context context;

    public Database_Helper( Context context) {
        super(context, "Login.db", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        try{
            MyDB.execSQL("create table users(Email TEXT primary key,password TEXT)");

        }catch (Exception e){

            Toast.makeText(context, "Table created successfully inside our database", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop table if exists users");
        onCreate(MyDB);
    }

    ///////////////////////////////Inserting values inside the users Table//////////////////////////////////////////////
    public boolean insertData(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);

        contentValues.put("password",password);
        long result = MyDB.insert("users",null,contentValues);

        if (result==-1) return false;
        else
            return true;

    }

    /////////////////Checking the user Email
    public boolean checkUserEmail(String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor =MyDB.rawQuery("Select * from users where email=?",new String[]{email});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }

    /////////////////Checking the user Email and password
    public boolean checkUserPassword(String email,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where email=? and password=?",new String[]{email,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }




}
