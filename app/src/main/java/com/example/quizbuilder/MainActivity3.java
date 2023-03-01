package com.example.quizbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.widget.*;
import android.content.*;
import android.view.*;
import java.util.*;

public class MainActivity3 extends AppCompatActivity {

    public EditText editTextTextNameEnd;
    public EditText editTextScore;
    public Button buttonRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editTextTextNameEnd = findViewById(R.id.editTextNameEnd);
        editTextScore = findViewById(R.id.editTextScore);
        buttonRestart = findViewById(R.id.buttonRestart);
        int numOfQuestions = 10;

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int score = intent.getIntExtra("score", 0);

//        int scoreInt = Integer.valueOf(score);

        editTextTextNameEnd.setText(name);

        double percent = score*10;
        String strPercent = percent + "%";
        editTextScore.setText(strPercent);

        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRestart = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(intentRestart);
//
            }
        });

    }
}