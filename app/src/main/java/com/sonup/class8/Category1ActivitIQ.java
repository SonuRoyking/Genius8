package com.sonup.class8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Category1ActivitIQ extends AppCompatActivity {

    RecyclerView recyclerView ;
    CustomAdapter1 customAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category1_activit_i_q);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);

        String[]title = new String[]
                {
                        "Important Question"

                };
        String[]htmlFile = new String[]
                {

                       "impQuestios"

                };

        customAdapter1=new CustomAdapter1(this , title , htmlFile);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter1);


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Category1ActivitIQ.this , HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent intent = new Intent(Category1ActivitIQ.this , HomeActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}