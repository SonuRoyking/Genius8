package com.sonup.class8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Study1Activity extends AppCompatActivity {

    WebView webView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study1);
        webView=(WebView) findViewById(R.id.webView);
        WebSettings webSettings  = webView.getSettings();



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        Intent intent = getIntent();
        String url = intent.getStringExtra("file");
        webView.loadUrl("file:///android_asset/" + url+".html");
        webView.setWebViewClient(new WebViewClient());



    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Study1Activity.this , Category1ActivitIQ.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent intent = new Intent(Study1Activity.this , Category1ActivitIQ.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}