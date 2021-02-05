package com.sonup.class8;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;
import java.util.List;

public class QuizComputer extends AppCompatActivity {

    private TextView question, no_counter;
    private LinearLayout options_layout;
    private Button next_btn;
    private int count = 0;
    private List<QuestionModel> list;
    private int position = 0;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_computer);

        question = findViewById(R.id.question);
        no_counter = findViewById(R.id.no_counter);
        options_layout = findViewById(R.id.optionsLayout);
        next_btn = findViewById(R.id.next_btn);

        list = new ArrayList<>();
        list.add(new QuestionModel("Which of the following is not a web browser ?", "Google", "Internet Explorer", "Firefox", "Whithat", "Whithat"));










        for (int i = 0; i < 4; i++) {
            options_layout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswer((Button) view);
                }


            });

        }
        playAnim(question, 0, list.get(position).getQuestion());
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next_btn.setEnabled(false);
                next_btn.setAlpha(0.07f);
                enabledoption(true);
                position++;
                if (position == list.size()) {
                    Intent scoreintent = new Intent(QuizComputer.this, ScreActivity.class);
                    finish();
                    scoreintent.putExtra("score", score);
                    scoreintent.putExtra("total", list.size());
                    startActivity(scoreintent);
                    return;

                }
                count = 0;
                playAnim(question, 0, list.get(position).getQuestion());

            }
        });

    }

    private void enabledoption(boolean enable) {

        for (int i = 0 ; i < 4 ;  i ++){

            options_layout.getChildAt(i).setEnabled(enable);
            if(enable){
                options_layout.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#595959")));

            }

        }


    }

    private void playAnim(final View view, final int value, final String data) {
        view.animate().alpha(value).scaleX(value).scaleY(1).setDuration(500).setStartDelay(50)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (value == 0 && count < 4) {
                    String option = "";
                    if (count == 0) {
                        option = list.get(position).getOptionA();
                    } else if (count == 1) {
                        option = list.get(position).getOptionB();
                    } else if (count == 2) {
                        option = list.get(position).getOptionC();
                    } else if (count == 3) {
                        option = list.get(position).getOptionD();
                    }


                    playAnim(options_layout.getChildAt(count), 0, option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (value == 0) {
                    try {
                        ((TextView) view).setText(data);
                        no_counter.setText(position + 1 + "/" + list.size());
                    } catch (ClassCastException ex) {
                        ((Button) view).setText(data);
                    }
                    view.setTag(data);

                    playAnim(view, 1, data);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(QuizComputer.this , QuizActivity.class);
        startActivity(intent);
        finish();
    }



    private void checkAnswer(Button selectedOption) {

        enabledoption(false);
        next_btn.setEnabled(true);
        next_btn.setAlpha(1);
        if (selectedOption.getText().toString().equals(list.get(position).getCorrectAns())) {
            score++;
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00ff00")));

            Button correctOption = (Button )options_layout.findViewWithTag(list.get(position).getCorrectAns());
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0e9913")));
            correctOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0e9913")));


            StyleableToast.makeText(getApplicationContext(), "Right Answer", R.style.rightToast).show();

        }

        else {
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));

            StyleableToast.makeText(getApplicationContext() , "Wrong Answer" , R.style.wrongToast).show();





        }
    }



}

