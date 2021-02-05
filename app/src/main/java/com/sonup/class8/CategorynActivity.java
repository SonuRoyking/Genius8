package com.sonup.class8;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategorynActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryn);

     getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);

        String[]title = new String[]
                {
                    "Physics" , "Chemistry " , "Biology"

                };
String[]htmlFile = new String[]
        {

    "physics" , "chemistry" , "bilogy"

        };

customAdapter=new CustomAdapter(this , title , htmlFile);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setAdapter(customAdapter);


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategorynActivity.this , HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent intent = new Intent(CategorynActivity.this , HomeActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}