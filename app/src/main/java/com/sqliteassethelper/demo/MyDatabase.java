package com.sqliteassethelper.demo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteAssetHelper
{

    private static final String DATABASE_NAME = "yogalite.db";
    private static final int DATABASE_VERSION = 1;
    private static final String ID="id";
    private static final String t1="name";
    private static final String t2="description";
    private static final String t3="image";
    private static final String t4="benefits";
    private static final String POSES_TABLE="poses";


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<Poses> getPoses(){
        SQLiteDatabase db=getWritableDatabase();
        String[] columns={MyDatabase.ID,MyDatabase.t1,MyDatabase.t2,MyDatabase.t3,MyDatabase.t4};
//        String[] selectionArgs={categoryId+"",subjectId+"",yearId+""};
        Cursor cursor=db.query(MyDatabase.POSES_TABLE, columns, null, null, null, null, null);
//        Cursor cursor=db.query(MyDatabase.TABLE_NAME, columns, null,null, null, null, null);
        ArrayList<Poses> questionsArrayList=new ArrayList<>();

        while(cursor.moveToNext()){



            Poses questions=new Poses();
            questions.id=cursor.getInt(cursor.getColumnIndex(MyDatabase.ID));
            questions.t1=cursor.getString(cursor.getColumnIndex(MyDatabase.t1));
            questions.t2=cursor.getString(cursor.getColumnIndex(MyDatabase.t2));
            questions.t3=cursor.getString(cursor.getColumnIndex(MyDatabase.t3));
            questions.t4=cursor.getString(cursor.getColumnIndex(MyDatabase.t4));
            questionsArrayList.add(questions);

        }
        return questionsArrayList;
    }



}