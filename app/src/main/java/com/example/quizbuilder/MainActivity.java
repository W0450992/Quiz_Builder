package com.example.quizbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import android.widget.*;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import android.content.*;
import java.io.*;
import java.util.*;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    public EditText editTextTextPersonName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);
        Button buttonStart = (Button) findViewById(R.id.buttonStart);





//        Map<String,String> map = new HashMap<String,String>();//create map
//        map.put("","Red");//place key and associate data in map
//        map.put("Color2","Blue");
//        map.put("Color3","Green");
//        map.put("Color4","White");



        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", editTextTextPersonName.getText().toString());
                startActivity(intent);







            }
        });




        }

    @Override
    public void onClick(View v) {

    }
}