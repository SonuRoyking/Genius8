package com.sonup.class8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScreActivity extends AppCompatActivity {
        private TextView  score , total;
        private Button done_btn ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scre);


        score = findViewById(R.id.score);
        total = findViewById(R.id.total);
        done_btn = findViewById(R.id.done_btn);


        score.setText(String.valueOf(getIntent().getIntExtra("score", 0)));
        total.setText(String.valueOf(getIntent().getIntExtra("total", 0)));

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ScreActivity.this , QuizActivity.class);
                startActivity(intent);
                finish();

            }
        });






    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ScreActivity.this , QuizActivity.class);
        startActivity(intent);
        finish();
    }
}