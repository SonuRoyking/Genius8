package com.sonup.class8;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {

    private Button notes;
    private Button Quiz ;

    private Button syllabus ;
    private Button Questionmodel ;
    private Button IMPQuestions ;



    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        notes = findViewById(R.id.notes_btn);
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this , CategorynActivity.class );
                startActivity(intent);

            }
        });
        syllabus = findViewById(R.id.syllabus);
        syllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent syllabusIntent = new Intent(HomeActivity.this , SyllabusActivity.class );
                startActivity(syllabusIntent);

            }
        });
        Questionmodel = findViewById(R.id.questionModel);
        Questionmodel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this , QuestionModelActivity.class );
                startActivity(intent);

            }
        });

        Quiz = findViewById(R.id.quiz);
        Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoryIntet = new Intent(HomeActivity.this , QuizActivity.class );
                startActivity(categoryIntet);

            }
        });

        IMPQuestions = findViewById(R.id.importantQ);
        IMPQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this , Category1ActivitIQ.class );
                startActivity(intent);

            }
        });



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home , R.id.nav_study , R.id.nav_quiz , R.id.nav_update ,
                R.id.nav_share , R.id.nav_rate , R.id.nav_other)






                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home :
                        break;

                    case R.id.nav_study :
                        Intent intent=new Intent(HomeActivity.this , CategorynActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                    case R.id.nav_quiz :
                        Intent qintent=new Intent(HomeActivity.this ,QuizActivity.class);
                        startActivity(qintent);
                        finish();
                        break;

                    case R.id.nav_update :
                       try {
                           startActivity(new Intent(Intent.ACTION_VIEW,
                                   Uri.parse("market://details?id=" + "com.sonup.class8")));
                       }
                       catch (ActivityNotFoundException e)
                       {
                           startActivity(new Intent(Intent.ACTION_VIEW,
                           Uri.parse("http//play.google.com/store/apps/details?id"  +getPackageName())));

                       }

                        break;

                    case R.id.nav_share :
                        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                        sharingIntent.setType("text/plane");
                        String shareBody="https://play.google.com/store/apps/details?id=com.truecaller";
                        String sharesuject= "Complete Class 8 Solution + Quiz App";

                                sharingIntent.putExtra(Intent.EXTRA_TEXT , shareBody);
                                sharingIntent.putExtra(Intent.EXTRA_SUBJECT , sharesuject);
                                startActivity(Intent.createChooser(sharingIntent , "Share Using"));



                    case R.id.nav_rate :
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("market://details?id=" + "com.sonup.class8")));
                        }
                        catch (ActivityNotFoundException e)
                        {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http//play.google.com/store/apps/details?id"  +getPackageName())));

                        }

                        break;
                    case R.id.nav_other :
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW , Uri.parse("market://search?q=pub:Roy Warriors")));
                        
                        }catch (android.content.ActivityNotFoundException anfe){
                            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https:///play.google.com/store/apps/developer?id=Developer+Name+Here")));
                            
                            
                        }
                        
                        
                        break;
                }

                drawer.closeDrawers();
                return false;
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        
        
        int id = item.getItemId();
        if(id == R.id.action_privacy){
            Intent intent = new Intent(HomeActivity.this, Policy.class);
            startActivity(intent);
            finish();

            return true;
        }

        else
            if(id == R.id.action_abut){
                StyleableToast.makeText(getApplicationContext(),"Roy Warriors  Made by  Sonu " , R.style.rightToast).show();
                return  true;
            }

            else
            if(id == R.id.action_contact){
                StyleableToast.makeText(getApplicationContext(),"kr6513782@gmail.com ", R.style.rightToast).show();
                return  true;
            }
            else
            if(id == R.id.action_exit){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Do you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                HomeActivity.super.onBackPressed();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.cancel();

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


                return true;

            }
        
        return super.onOptionsItemSelected(item);
    }
}