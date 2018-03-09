package com.sqliteassethelper.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyDatabase myDatabase;
    private ArrayList<Poses> posesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase=new MyDatabase(MainActivity.this);

        posesArrayList=myDatabase.getPoses();

        for(int i=0;i<posesArrayList.size();i++)
        {
            Log.e(" category filter",posesArrayList.get(i).t1+"");
        }


    }
}
