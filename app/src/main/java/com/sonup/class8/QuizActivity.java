package com.sonup.class8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends AppCompatActivity {

    private Button quizPhysics;
    private Button quizChemistry ;
    private Button quizBiology ;
    private Button quizHistory ;
    private Button quizEnglishGrammar ;
    private Button quizHindiGrammar ;
    private Button quizComputer ;
    private Button quizGK ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        quizPhysics = findViewById(R.id.quiz_physics);
        quizPhysics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntet = new Intent(QuizActivity.this , QuizPhysics.class );
                startActivity(categoryIntet);

            }
        });
        quizChemistry = findViewById(R.id.quiz_chemitry);
        quizChemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntet = new Intent(QuizActivity.this , QuizChemistry.class );
                startActivity(categoryIntet);

            }
        });

        quizBiology = findViewById(R.id.quiz_bilogy);
        quizBiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntet = new Intent(QuizActivity.this , QuizBilogy.class );
                startActivity(categoryIntet);

            }
        });

        quizHistory = findViewById(R.id.quiz_history);
        quizHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntet = new Intent(QuizActivity.this , QuizHisory.class );
                startActivity(categoryIntet);

            }
        });


        quizEnglishGrammar = findViewById(R.id.quiz_englishgrammar);
        quizEnglishGrammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntet = new Intent(QuizActivity.this , QuizEnglish.class );
                startActivity(categoryIntet);

            }
        });

        quizHindiGrammar = findViewById(R.id.quiz_hindigrammar);
        quizHindiGrammar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntet = new Intent(QuizActivity.this , QuizHindiG.class );
                startActivity(categoryIntet);

            }
        });

        quizComputer = findViewById(R.id.quiz_computer);
        quizComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntet = new Intent(QuizActivity.this , QuizComputer.class );
                startActivity(categoryIntet);

            }
        });

        quizGK = findViewById(R.id.quiz_gk);
        quizGK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this , QuizGk.class );
                startActivity(intent);

            }
        });


    }
















    @Override
    public void onBackPressed() {
        Intent intent = new Intent(QuizActivity.this , HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent intent = new Intent(QuizActivity.this , HomeActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}