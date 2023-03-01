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
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    FileInputStream in = null;
    ArrayList<String> definitions = new ArrayList<String>();
    ArrayList<String> terms = new ArrayList<String>();
    ArrayList<String> answers = new ArrayList<String>();
    String currentQuestion;
    String currentAnswer;


    int counter = 0;
    int iteration = 0;
    String answerTxt;
    Map<String,String> map = new HashMap<String,String>();
    public TextView textViewTextDefinition;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
//    Button button1 = findViewById(R.id.button1);
//    Button button2 = findViewById(R.id.button2);
//    Button button3 = findViewById(R.id.button3);
//    Button button4 = findViewById(R.id.button4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewTextDefinition = findViewById(R.id.textViewTextQuestion);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);








        String str = null;
        BufferedReader br = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.quiz);
            br = new BufferedReader(new InputStreamReader(is));
            System.out.println("File in RAW is open");
            while ((str = br.readLine()) != null) {
                String[] arrayOfString = str.split(":");
                int counter = 0;
                for(String split : arrayOfString){
                    if(counter == 0){
                        definitions.add(split);
                    }
                    if(counter == 1){
                        terms.add(split);
                    }
                    counter++;
                }

            }
            is.close();
            System.out.println("File in RAW is closed");
        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }


        //create map
        for(int i = 0; i < terms.size(); i++){
            map.put(definitions.get(i),terms.get(i));//place key and associate data in map
        }



        long seed = System.nanoTime();
        Collections.shuffle(definitions, new Random(seed));
        Collections.shuffle(terms, new Random(seed));

        currentQuestion = definitions.get(0);
        textViewTextDefinition.setText(currentQuestion);
        answers.add(terms.get(0));
        answers.add(terms.get(1));
        answers.add(map.get(textViewTextDefinition.getText().toString()));
        answerTxt = answers.get(2);
        answers.add(terms.get(3));
        Collections.shuffle(answers);


        button1.setText(answers.get(0));
        button2.setText(answers.get(1));
        button3.setText(answers.get(2));
        button4.setText(answers.get(3));

        String button1Txt = button1.getText().toString();
        String button2Txt = button2.getText().toString();
        String button3Txt = button3.getText().toString();
        String button4Txt = button4.getText().toString();
//        String answerTxt = map.get(textViewTextDefinition.getText().toString());


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(button1);

                setQuestion();
                setButtons();


//
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(button2);


                setQuestion();
                setButtons();

//
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(button3);

                setQuestion();
                setButtons();

//
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(button4);

                setQuestion();
                setButtons();


//
            }
        });


    }// end oncreate
    private void setButtons(){

        answers.add(terms.get(0));
        answers.add(terms.get(1));
        answers.add(terms.get(2));
        String strAnswer = map.get(currentQuestion);
        answers.add(strAnswer);
        answerTxt = strAnswer;

        Collections.shuffle(answers);
        button1.setText(answers.get(0));
        button2.setText(answers.get(1));
        button3.setText(answers.get(2));
        button4.setText(answers.get(3));
        Collections.shuffle(terms);
    }

    private void setQuestion(){

        deleteIndexZero();
        if (definitions.size() == 0) {
//                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

            Intent intenttolast = new Intent(MainActivity2.this, MainActivity3.class);
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            intenttolast.putExtra("score", counter);
            intenttolast.putExtra("name", name);
            startActivity(intenttolast);
        }
        else {
            answers.removeAll(answers);
            textViewTextDefinition.setText(definitions.get(0));
            currentQuestion = textViewTextDefinition.getText().toString();
//        textViewTextDefinition.setText(currentQuestion);
//                    String answerTxt = map.get(textViewTextDefinition.getText().toString());


        }

    }
    private void checkAnswer(Button buttonAnswer){

        currentAnswer = buttonAnswer.getText().toString();


        iteration++;




            if (currentAnswer.equals(answerTxt)) {
                counter++;
                Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
            }

            else{
                Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
            }

    }


    public void loadQuestion() {
        textViewTextDefinition.setText(definitions.get(0));

    }

    public void deleteIndexZero(){
        definitions.remove(0);
    }

}


